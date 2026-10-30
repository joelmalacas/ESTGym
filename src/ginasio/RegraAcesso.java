package ginasio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public interface RegraAcesso {
    boolean permite(List<Registo> usos, LocalDateTime agora);
    default Duration duracao(List<Registo> usos, LocalDateTime agora, Duration duracaoEquipamento) {
        return duracaoEquipamento;
    }
}
