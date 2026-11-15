package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PorDia implements RegraAcesso {

    private final int vezes;
    private final Duration intervalo;

    public PorDia(int vezes, Duration intervalo) {
        this.vezes = Validator.requirePositiveOrZero(vezes);
        this.intervalo = Objects.requireNonNull(intervalo);

    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        return usosHoje(usos, agora.toLocalDate()) < vezes && respeitaIntervalo(usos, agora);
    }

    private int usosHoje(List<Registo> usos, LocalDate hoje) {
        int total = 0;

        for (int i = usos.size() - 1; i >= 0; i--) {
            if (!usos.get(i).getDataHora().toLocalDate().equals(hoje)) {
                break;
            }

            total++;
        }
        return total;
    }

    private boolean respeitaIntervalo(List<Registo> usos, LocalDateTime agora) {
        if (intervalo.isZero() || usos.isEmpty()) {
            return true;
        }

        LocalDateTime ultimoUso = usos.get(usos.size() - 1).getDataHora();

        return !agora.isBefore(ultimoUso.plus(intervalo));
    }

    @Override
    public String toString() {
        String texto = vezes + (vezes == 1 ? " vez" : " vezes") + " por dia";
        return intervalo.isZero() ? texto : texto + ", " + intervalo.toMinutes() + " minutos entre elas";
    }
}
