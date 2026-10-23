package equipamentos;

import ginasio.Servico;

public class PortaSaida extends Porta{

    public PortaSaida(String nome, Servico servico, int duracao){
        super(nome, servico, true, duracao);
    }
}
