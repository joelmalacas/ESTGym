package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class Nutricionista extends Equipamento {

    public Nutricionista(int id,String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(id, nome, servico, exigeEntrada,duracao);
    }
}