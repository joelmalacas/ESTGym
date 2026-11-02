package regras;

import ginasio.Registo;
import ginasio.RegraAcesso;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Sempre implements RegraAcesso {
    private final String descricao;

    public Sempre() {
        this("Sempre");
    }

    public  Sempre(String descricao) {
        this.descricao = Objects.requireNonNull(descricao);
    }

    @Override
    public boolean permite(List<Registo> usos, LocalDateTime agora) {
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
