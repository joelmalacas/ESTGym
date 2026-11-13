package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class CadeiraMassagem extends Equipamento {

    public CadeiraMassagem(String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(nome, servico, exigeEntrada, duracao);
    }
}
