package ginasio;

import pds.util.Validator;
import java.util.*;

public class Plano {

    private String nome;
    private Map<Servico, Contrato> contratos = new LinkedHashMap<>();

    public Plano(String n) {
        this.nome = Validator.requireNonBlankTrimmed(n);
    }

    public void AdicionarContratos(Contrato contrato) {
        Objects.requireNonNull(contrato);
        contratos.put(contrato.getServico(), contrato);
    }

    public String getNome() {
        return nome;
    }
    public Collection<Contrato> getContratos() {
        return Collections.unmodifiableCollection(contratos.values());
    }

    @Override
    public String toString() {
        return "Plano{" +
                "nome='" + nome + '\'' +
                ", contratos=" + contratos +
                '}';
    }
}
