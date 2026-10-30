package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;

import java.time.LocalDateTime;
import java.util.List;

public class Sempre implements RegraAcesso {
    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        return true;
    }
}
