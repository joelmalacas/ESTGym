package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PorSemana implements RegraAcesso {

    private final int vezes;
    private final Duration duracao;

    public PorSemana(int vezes, Duration d) {
        this.vezes = Validator.requirePositiveOrZero(vezes);
        this.duracao = Objects.requireNonNull(d);
        if (d.isNegative()) {
            throw new IllegalArgumentException("A duração não pode ser negativa");
        }
    }

    public PorSemana(int vezes) {
        this.vezes = Validator.requirePositiveOrZero(vezes);
        this.duracao = null;
    }

    @Override
    public Duration duracao(List<Registo> usos, LocalDateTime agora, Duration duracaoEquipamento) {
        return duracao != null ? duracao : duracaoEquipamento;
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        LocalDate hoje = agora.toLocalDate();
        LocalDate segunda = hoje.with(DayOfWeek.MONDAY);

        int total = 0;
        for (int i = usos.size() - 1; i >= 0; i--) {
            LocalDate dia = usos.get(i).getDataHora().toLocalDate();
            if (dia.isBefore(segunda)) {
                break;
            }
            if (dia.equals(hoje)) {
                return false;
            }
            total++;
        }
        return total < vezes;
    }

    @Override
    public String toString() {
        String base = vezes + (vezes == 1 ? " vez" : " vezes") + " por semana";
        return duracao == null ? base : base + ", máx. " + duracao.toMinutes() + " min";
    }
}