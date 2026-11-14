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

        List<Registo> registosDoServico = membro.getRegistos(servico);
        return regra.permite(registosDoServico, agora);
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
