package ginasio;

import pds.util.Validator;

public class Servico {

    private String nome;

    public Servico(String n){
        this.nome = Validator.requireNonBlank(n);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
