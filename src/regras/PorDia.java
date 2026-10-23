package regras;

import ginasio.Registo;
import pds.util.Validator;

import java.time.LocalDateTime;
import java.util.List;

public class PorDia implements RegraAcesso{

    private final int vezes, intervalo;

    public PorDia(int vezes, int intervalo) {
        this.vezes = Validator.requirePositiveOrZero(vezes);
        this.intervalo = Validator.requirePositiveOrZero(intervalo);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        return false;
    }
}
