package ginasio;

import pds.util.RelogioSimulado;
import pds.util.Validator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Equipamento {
    private final int id;
    private final String nome;
    private final Servico servico;
    private final boolean exigeEntrada;
    private boolean ocupado;
    private final Duration duracao;
    private LocalDateTime fimUso;

    protected Equipamento(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        this.id = Validator.requirePositive(id);
        this.nome = Validator.requireNonBlank(nome);
        this.servico = Objects.requireNonNull(servico);
        this.exigeEntrada = exigeEntrada;
        this.duracao = Objects.requireNonNull(duracao);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Servico getServico() {
        return servico;
    }
    public boolean isExigeEntrada() {
        return exigeEntrada;
    }
    public boolean isOcupado() {
        if (ocupado && !RelogioSimulado.getTempoAtual().isBefore(fimUso)) {
            ocupado = false;
        }
        return ocupado;
    }
    public Duration getDuracao() {
        return duracao;
    }
    public boolean podeUsar(Membro m) {
        if (isOcupado())
            return false;
        if (exigeEntrada && !m.estaDentro())
            return false;
        return m.temContrato(servico);
    }
    public void usar(Membro m) {
        ocupar();
        fimUso = RelogioSimulado.getTempoAtual().plus(duracao);
        m.registarUso(new Registo(servico, this, RelogioSimulado.getTempoAtual())); // ajusta ao teu Registo
    }

    protected void ocupar() {ocupado = true;}
    protected void libertar() {ocupado = false;}
}
