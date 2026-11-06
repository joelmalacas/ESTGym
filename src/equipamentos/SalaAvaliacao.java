package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class SalaAvaliacao extends Equipamento {

    public SalaAvaliacao(String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        //TODO FALTA VERIFICAR O CONSTRUTOR
        super(nome, servico, exigeEntrada, duracao);
    }
}
