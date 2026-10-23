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

    public boolean isDentro() {
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

    //TODO FALTA IMPLEMENTAR PLANO
    public void adicionarPlano(Plano plano) {

    }
    public Optional<Contrato> getContrato(Servico servico) {
        return Optional.empty();
    }
    public boolean temContrato(Servico servico) {
        return false;
    }
    public Map<Servico, Contrato> getContratos() {
        return Collections.unmodifiableMap(contratos);
    }

    //TODO FALTA IMPLEMENTAR REGISTOS
    public void registarUso() {}
    public List<Registo> getRegistos() {
        return Collections.unmodifiableList(registos);
    }
    public List<Registo> getRegistos(Servico servico) {
        return List.of();
    }
}