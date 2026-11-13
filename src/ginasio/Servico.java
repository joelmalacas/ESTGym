package ginasio;

import pds.util.Validator;

import java.time.Duration;
import java.util.Objects;

public class Servico {

    private String nome;
    private Duration duracao;

    public Servico(String n){
        this.nome = Validator.requireNonBlank(n);
    }

    public String getNome() {
        return nome;
    }
    public Duration getDuracao() {
        return duracao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                '}';
    }
}
