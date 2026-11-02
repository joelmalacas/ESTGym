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

public class SessaoDiaria implements RegraAcesso {

    private final int minutos, dias;

    public SessaoDiaria(int minutos, int dias) {
        this.minutos = Validator.requirePositiveOrZero(minutos);
        this.dias = Validator.requirePositiveOrZero(dias);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        LocalDate hoje = agora.toLocalDate();
        LocalDate segunda = hoje.with(DayOfWeek.MONDAY);
        int diasUsados = 0;
        LocalDate ultimoDia = null;

        for (int i = usos.size() - 1; i >= 0; i--) {
            LocalDate dia = usos.get(i).getDataHora().toLocalDate();
            if (dia.isBefore(segunda)) {
                break;
            }

            if (dia.equals(hoje)) {
                return false;
            }

            if (!dia.equals(ultimoDia)) {
                diasUsados++;
                ultimoDia = dia;
            }
        }

        return diasUsados < dias;
    }

    @Override
    public Duration duracao(List<Registo> usos, LocalDateTime agora, Duration duracaoEquipamento) {
        return Duration.ofMinutes(minutos);
    }

    @Override
    public String toString() {
        String sessao = (minutos % 60 == 0 && minutos > 0)
                ? (minutos / 60) + (minutos == 60 ? " hora" : " horas")
                : minutos + " minutos";
        return sessao + " por dia, " + dias + (dias == 1 ? " dia" : " dias") + " por semana";
    }
}
