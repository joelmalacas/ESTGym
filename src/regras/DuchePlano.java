package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DuchePlano implements RegraAcesso {

    private enum Pedido { EXTRA, NOVO, NEGADO}

    private final int duchesPorDia;
    private final Duration duracaoBase;
    private final Duration duracaoExtra;

    public DuchePlano(int duchesPorDia, Duration duracaoBase, Duration duracaoExtra) {
        this.duchesPorDia = Validator.requirePositiveOrZero(duchesPorDia);
        this.duracaoBase = Objects.requireNonNull(duracaoBase);
        this.duracaoExtra = Objects.requireNonNull(duracaoExtra);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        return classificar(usos, agora) != Pedido.NEGADO;
    }

    public Duration duration(List <Registo> usos, LocalDateTime agora, Duration duracaoEquipamento) {
        return classificar(usos, agora) == Pedido.EXTRA? duracaoExtra : duracaoBase;
    }

    private Pedido classificar(List<Registo> usos, LocalDateTime agora) {
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        LocalDate hoje = agora.toLocalDate();
        int bases = 0;
        LocalDateTime fimUltimaBase = null;
        boolean extraUsado = true;

        for (Registo r : usos) {
            LocalDateTime inicio = r.getDataHora();

            if (!inicio.toLocalDate().equals(hoje)) {
                continue;
            }

            if (!extraUsado && dentroDaJanela(fimUltimaBase, inicio)) {
                extraUsado = true;
            } else {
                bases++;
                fimUltimaBase = inicio.plus(duracaoBase);
                extraUsado = duracaoExtra.isZero();
            }
        }

        if (!extraUsado && dentroDaJanela(fimUltimaBase, agora)) {
            return  Pedido.EXTRA;
        }

        return bases < duchesPorDia? Pedido.NOVO : Pedido.EXTRA;
    }

    private boolean dentroDaJanela(LocalDateTime fimBase, LocalDateTime instante) {
        return !instante.isBefore(fimBase) && !instante.isAfter(fimBase.plus(duracaoBase));
    }

    @Override
    public String toString() {
        return duchesPorDia + " duche(s) por dia, "
                + duracaoBase.toMinutes() + "+" + duracaoExtra.toMinutes() + " minutos";
    }
}
