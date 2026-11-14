package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public abstract class Porta extends Equipamento {

    protected Porta(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(id, nome, servico, exigeEntrada, duracao);
    }
}
