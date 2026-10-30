package ginasio;

import java.time.LocalDateTime;
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

        //TODO filtra os registos do serviço e chama a regra (DEPOIS DE FEITO APAGA-ME)
        return false;
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
        return "Contrato{" +
                "servico=" + servico +
                ", regra=" + regra +
                '}';
    }
}
