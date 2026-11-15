package ginasio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Contrato {

    private Servico servico;
    private RegraAcesso regra;

    public Contrato(Servico s, RegraAcesso rg) {
        this.servico = Objects.requireNonNull(s);
        this.regra = Objects.requireNonNull(rg);
    }

    public boolean permite(Membro membro, LocalDateTime agora) {
        Objects.requireNonNull(membro);
        Objects.requireNonNull(agora);

        return regra.permite(membro.getRegistos(servico), agora);
    }

    public Servico getServico() {
        return servico;
    }
    public RegraAcesso getRegra() {
        return regra;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public void setRegra(RegraAcesso regra) {
        this.regra = regra;
    }

    @Override
    public String toString() {
        return regra.toString();
    }
}
