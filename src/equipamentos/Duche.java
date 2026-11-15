package equipamentos;

import ginasio.Equipamento;
import ginasio.Membro;
import ginasio.Servico;

import java.time.Duration;
import java.time.LocalDateTime;

public class Duche  extends Equipamento {

    public Duche(int id, String nome, Servico servico, boolean exigeEntrada) {
        super(id, nome, servico, exigeEntrada, Duration.ZERO);
    }
}