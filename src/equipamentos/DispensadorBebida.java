package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class DispensadorBebida extends Equipamento {

    public DispensadorBebida(String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(nome, servico, exigeEntrada, duracao);
    }
}
