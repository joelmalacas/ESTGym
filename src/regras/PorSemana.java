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
    private final Duration duracao; // null = sem limite de tempo

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
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        LocalDate segunda = agora.toLocalDate().with(DayOfWeek.MONDAY);

        int total = 0;
        Duration tempoTotal = Duration.ZERO;

        for (int i = usos.size() - 1; i >= 0; i--) {
            Registo r = usos.get(i);

            if (r.getDataHora().toLocalDate().isBefore(segunda)) {
                break;
            }

            total++;
            if (duracao != null) {
                tempoTotal = tempoTotal.plus(r.getServico().getDuracao());
            }
        }

        if (total >= vezes) {
            return false;
        }

        return duracao == null || tempoTotal.compareTo(duracao) < 0;
    }

    @Override
    public String toString() {
        String base = vezes + (vezes == 1 ? " vez" : " vezes") + " por semana";
        return duracao == null ? base : base + ", máx. " + duracao.toMinutes() + " min";
    }
}