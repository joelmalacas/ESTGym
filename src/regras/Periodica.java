package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Periodica implements RegraAcesso {

    private final int meses;

    public Periodica(int meses) {
        this.meses = Validator.requirePositiveOrZero(meses);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        Objects.requireNonNull(usos);
        Objects.requireNonNull(agora);

        if (usos.isEmpty()) {
            return true;
        }

        LocalDateTime ultimoUso = usos.get(usos.size() - 1).getDataHora();

        return !agora.isBefore(ultimoUso.plusMonths(meses));
    }

    @Override
    public String toString() {
        return meses == 1 ? "1 por mês" : "1 de " + meses + " em " + meses + " meses";
    }
}
