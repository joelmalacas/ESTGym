package equipamentos;

import ginasio.Servico;
import java.time.Duration;

public class PortaSaida extends Porta{

    public PortaSaida(String nome, Servico servico, Duration duracao){
        super(nome, servico, true, duracao);
    }
}
