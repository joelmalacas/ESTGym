package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class SalaAvaliacao extends Equipamento {

    public SalaAvaliacao(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(id, nome, servico, true, duracao);
    }
}
