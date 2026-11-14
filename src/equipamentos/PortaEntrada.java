package equipamentos;

import ginasio.Servico;

import java.time.Duration;

public class PortaEntrada extends Porta{

    public PortaEntrada(int id, String nome, Servico servico, Duration duracao) {
        super(id, nome, servico, false, duracao);
    }
}
