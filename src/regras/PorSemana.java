package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.LocalDateTime;
import java.util.List;

public class PorSemana implements RegraAcesso {

    private final int vezes;

    public PorSemana(int vezes) {
        this.vezes = Validator.requirePositiveOrZero(vezes);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        return false;
    }
}
