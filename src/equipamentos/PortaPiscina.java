package equipamentos;

import ginasio.Servico;

import java.time.Duration;

public class PortaPiscina extends Porta{

    public PortaPiscina(int id, String nome, Servico servico, boolean exigeEntrada , Duration duracao) {
        super(id, nome, servico, exigeEntrada, duracao);
    }
}
