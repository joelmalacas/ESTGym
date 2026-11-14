package equipamentos;

import ginasio.Servico;
import java.time.Duration;

public class PortaSaida extends Porta{

    public PortaSaida(int id,String nome, Servico servico, Duration duracao){
        super(id, nome, servico, true, duracao);
    }
}
