package ginasio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Registo {

    private Servico servico;
    private Equipamento equipamento;
    private LocalDateTime dataHora;

    public Registo(Servico s, Equipamento eq, LocalDateTime dh) {
        this.servico = Objects.requireNonNull(s);
        this.equipamento = Objects.requireNonNull(eq);
        this.dataHora = Objects.requireNonNull(dh);
    }

    public Servico getServico() {
        return servico;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "Registo{" +
                "servico=" + servico +
                ", equipamento=" + equipamento +
                ", dataHora=" + dataHora +
                '}';
    }
}
