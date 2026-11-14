package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class SalaAvaliacao extends Equipamento {

    public SalaAvaliacao(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        //TODO FALTA VERIFICAR O CONSTRUTOR
        super(id, nome, servico, true, duracao);
    }
}
