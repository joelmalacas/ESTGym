package equipamentos;

import ginasio.Equipamento;
import ginasio.Membro;
import ginasio.Servico;

import java.time.Duration;
import java.util.Objects;

public class PersonalTrainer extends Equipamento {

    public PersonalTrainer(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        super(id, nome, servico, exigeEntrada, duracao);
    }
}