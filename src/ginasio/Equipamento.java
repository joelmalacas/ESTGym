package ginasio;

import pds.util.Validator;

import java.time.Duration;
import java.util.Objects;

public abstract class Equipamento {
    private final String nome;
    private final Servico servico;
    private final boolean exigeEntrada;
    private boolean ocupado;
    private final Duration duracao;

    protected Equipamento(String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        this.nome = Validator.requireNonBlank(nome);
        this.servico = Objects.requireNonNull(servico);
        this.exigeEntrada = exigeEntrada;
        this.duracao = Objects.requireNonNull(duracao);
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
        return ocupado;
    }
    public Duration getDuracao() {
        return duracao;
    }

    protected void ocupar() {ocupado = true;}
    protected void libertar() {ocupado = false;}
}
