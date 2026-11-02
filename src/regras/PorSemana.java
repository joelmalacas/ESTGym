package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PorSemana implements RegraAcesso {

    private final int vezes;

    public PorSemana(int vezes) {
        this.vezes = Validator.requirePositiveOrZero(vezes);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        LocalDate segunda = agora.toLocalDate().with(DayOfWeek.MONDAY);

        return usosDesde(usos, segunda) < vezes;
    }

    private int usosDesde(List<Registo> usos, LocalDate inicioSemana) {
        int total = 0;

        for (int i = usos.size() - 1; i >= 0; i--) {
            if (usos.get(i).getDataHora().toLocalDate().isBefore(inicioSemana)) {
                break;
            }

            total++;
        }
        return total;
    }

    @Override
    public String toString() {
        return vezes + (vezes == 1 ? " vez" : " vezes") + " por semana";
    }
}
