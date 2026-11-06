package equipamentos;

import ginasio.Equipamento;
import ginasio.Servico;

import java.time.Duration;

public class Nutricionista extends Equipamento {

    public Nutricionista(String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        //TODO TENHO QUE VERIFICAR
        super(nome, servico, exigeEntrada,duracao);
    }
}
