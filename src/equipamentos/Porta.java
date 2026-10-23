package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

public abstract class Porta extends Equipamento {

    protected Porta(String nome, Servico servico, boolean exigeEntrada, int duracao) {
        super(nome, servico, exigeEntrada, duracao);
    }
}
