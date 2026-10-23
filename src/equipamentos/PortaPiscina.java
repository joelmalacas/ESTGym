package equipamentos;

import ginasio.Servico;

public class PortaPiscina extends Porta{

    public PortaPiscina(String nome, Servico servico, boolean exigeEntrada ,int duracao) {
        super(nome, servico, exigeEntrada, duracao);
    }
}
