package equipamentos;

import ginasio.Equipamento;
import ginasio.Membro;
import ginasio.Servico;

import java.time.Duration;
import java.util.Objects;

public class PersonalTrainer extends Equipamento {

    public PersonalTrainer(String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        //TODO TENHO QUE VERIFICAR ESTE CONSTRUTOR
        super(nome, servico, exigeEntrada, duracao);
    }
}
