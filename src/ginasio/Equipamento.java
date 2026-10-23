package ginasio;

import pds.util.Validator;
import java.util.Objects;

public abstract class Equipamento {
    private final String nome;
    private final Servico servico;
    private final boolean exigeEntrada;
    private boolean ocupado;
    private final int duracao;

    protected Equipamento(String nome, Servico servico, boolean exigeEntrada, int duracao) {
        this.nome = Validator.requireNonBlank(nome);
        this.servico = Objects.requireNonNull(servico);
        this.exigeEntrada = exigeEntrada;
        this.duracao = Validator.requirePositiveOrZero(duracao);
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
    public int getDuracao() {
        return duracao;
    }

    protected void ocupar() {ocupado = true;}
    protected void libertar() {ocupado = false;}
}
