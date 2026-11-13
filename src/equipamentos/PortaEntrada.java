package equipamentos;

import ginasio.Servico;

import java.time.Duration;

public class PortaEntrada extends Porta{

    public PortaEntrada(String nome, Servico servico, Duration duracao) {
        super(nome, servico, false, duracao);
    }
}
