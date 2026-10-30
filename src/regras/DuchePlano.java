package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;
import pds.util.Validator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DuchePlano implements RegraAcesso {

    private enum Pedido { EXTRA, NOVO, NEGADO}

    private final int duchesPorDia;
    private final Duration duracaoBase;
    private final Duration duracaoExtra;

    public DuchePlano(int duchesPorDia, Duration duracaoBase, Duration duracaoExtra) {
        this.duchesPorDia = Validator.requirePositiveOrZero(duchesPorDia);
        this.duracaoBase = Objects.requireNonNull(duracaoBase);
        this.duracaoExtra = Objects.requireNonNull(duracaoExtra);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        //TODO METODO (DEPOIS APAGAR FUI EU QUE ESCREVI)
        return false;
    }
}
