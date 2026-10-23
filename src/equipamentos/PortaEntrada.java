package equipamentos;

import ginasio.Servico;

public class PortaEntrada extends Porta{

    public PortaEntrada(String nome, Servico servico, int duracao) {
        super(nome, servico, false, duracao);
    }
}
