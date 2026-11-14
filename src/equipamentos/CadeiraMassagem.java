package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class CadeiraMassagem extends Equipamento {

    public CadeiraMassagem(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(id, nome, servico, exigeEntrada, duracao);
    }
}
