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

    private final Duration duracao;
    private final int dias;

    public SessaoDiaria(Duration duracao, int dias) {
        Objects.requireNonNull(duracao);
        if (duracao.isNegative()) {
            throw new IllegalArgumentException("A duração não pode ser negativa");
        }
        this.duracao = duracao;
        this.dias = Validator.requirePositiveOrZero(dias);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        LocalDate hoje = agora.toLocalDate();
        LocalDate segunda = hoje.with(DayOfWeek.MONDAY);

        List<LocalDate> diasUsados = usos.stream()
                .map(r -> r.getDataHora().toLocalDate())
                .filter(dia -> !dia.isBefore(segunda))
                .distinct()
                .toList();

        return !diasUsados.contains(hoje) && diasUsados.size() < dias;
    }

    @Override
    public Duration duracao(List<Registo> usos, LocalDateTime agora, Duration duracaoEquipamento) {
        return duracao;
    }

    @Override
    public String toString() {
        long minutos = duracao.toMinutes();
        String sessao = (minutos % 60 == 0 && minutos > 0)
                ? (minutos / 60) + (minutos == 60 ? " hora" : " horas")
                : minutos + " minutos";
        return sessao + " por dia, " + dias + (dias == 1 ? " dia" : " dias") + " por semana";
    }
}