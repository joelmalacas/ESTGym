package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.LocalDateTime;
import java.util.List;

public class Periodica implements RegraAcesso {

    private final int meses;

    public Periodica(int meses) {
        this.meses = Validator.requirePositiveOrZero(meses);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        return false;
    }
}
