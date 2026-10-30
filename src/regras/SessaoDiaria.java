package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.LocalDateTime;
import java.util.List;

public class SessaoDiaria implements RegraAcesso {

    private final int minutos, dias;

    public SessaoDiaria(int minutos, int dias) {
        this.minutos = Validator.requirePositiveOrZero(minutos);
        this.dias = Validator.requirePositiveOrZero(dias);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        return false;
    }
}
