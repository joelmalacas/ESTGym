package ginasio;

import pds.util.Validator;

import java.util.*;

public class Membro {

    private final int id;
    private final String nome;
    private boolean dentro;
    private final Map<Servico, Contrato> contratos = new LinkedHashMap<>();
    private final List<Registo> registos = new ArrayList<>();

    public Membro(int id, String nome) {
        this.id = Validator.requirePositiveOrZero(id);
        this.nome = Validator.requireNonBlank(nome);
    }

    public boolean estaDentro() {
        return dentro;
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    public void entrar() {
        dentro = true;
    }
    public void sair() {
        dentro = false;
    }

    public void adicionarPlano(Plano plano) {
        Objects.requireNonNull(plano);

        for (Contrato contrato : plano.getContratos()) {
            adicionarContrato(contrato);
        }
    }
    public void adicionarContrato(Contrato contrato) {
        Objects.requireNonNull(contrato);
        contratos.put(contrato.getServico(), contrato);
    }
    public boolean temContrato(Servico servico) {
        return contratos.containsKey(servico);
    }
    public Optional<Contrato> getContrato(Servico servico) {
        return Optional.ofNullable(contratos.get(servico));
    }
    public Map<Servico, Contrato> getContratos() {
        return Collections.unmodifiableMap(contratos);
    }
    public void registarUso(Registo registo) {
        registos.add(Objects.requireNonNull(registo));
    }
    public List<Registo> getRegistos() {
        return Collections.unmodifiableList(registos);
    }
    public List<Registo> getRegistos(Servico servico) {
        List<Registo> res = new ArrayList<>();
        for (Registo registo : registos) {
            if (registo.getServico().equals(servico)) {
                res.add(registo);
            }
        }
        return res;
    }
}