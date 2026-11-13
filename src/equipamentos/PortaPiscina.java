package equipamentos;

import ginasio.Servico;

import java.time.Duration;

public class PortaPiscina extends Porta{

    public PortaPiscina(String nome, Servico servico, boolean exigeEntrada , Duration duracao) {
        super(nome, servico, exigeEntrada, duracao);
    }
}
