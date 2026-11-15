package ginasio;

import pds.util.RelogioSimulado;
import pds.util.Validator;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public abstract class Equipamento {
    private final int id;
    private final String nome;
    private final Servico servico;
    private final boolean exigeEntrada;
    private boolean ocupado;
    private final Duration duracao;
    private LocalDateTime fimUso;

    protected Equipamento(int id, String nome, Servico servico, boolean exigeEntrada, Duration duracao) {
        this.id = Validator.requirePositive(id);
        this.nome = Validator.requireNonBlank(nome);
        this.servico = Objects.requireNonNull(servico);
        this.exigeEntrada = exigeEntrada;
        this.duracao = Objects.requireNonNull(duracao);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Servico getServico() {
        return servico;
    }
    public boolean isExigeEntrada() {
        return exigeEntrada;
    }
    public boolean isOcupado() {
        if (ocupado && !RelogioSimulado.getTempoAtual().isBefore(fimUso)) {
            ocupado = false;
        }
        return ocupado;
    }
    public Duration getDuracao() {
        return duracao;
    }
    public boolean podeUsar(Membro m) {
        Objects.requireNonNull(m);
        LocalDateTime agora = RelogioSimulado.getTempoAtual();

        if (isOcupado() || m.estaOcupado(agora))
            return false;
        if (exigeEntrada && !m.estaDentro())
            return false;

        Contrato contrato = m.getContratos().get(servico);
        if (contrato == null)
            return false;
        return contrato.permite(m, agora);
    }
    public void usar(Membro m) {
        LocalDateTime agora = RelogioSimulado.getTempoAtual();
        Duration duracaoServico = duracaoServico(m, agora);

        m.registarUso(new Registo(servico, this, agora));
        m.ocuparAte(agora.plus(duracaoServico));

        ocupar();
        fimUso = agora.plus(duracaoOcupacao(duracaoServico));
    }

    protected Duration duracaoServico(Membro m, LocalDateTime agora) {
        Contrato contrato = m.getContratos().get(servico);
        if (contrato == null) {
            throw new IllegalStateException(m.getNome() + " não tem contrato para " + servico);
        }

        RegraAcesso regra = contrato.getRegra();
        List<Registo> usos = m.getRegistos(servico);
        return regra.duracao(usos, agora, duracao);
    }

    protected Duration duracaoOcupacao(Duration duracaoServico) {
        return duracaoServico;
    }

    protected void ocupar() {ocupado = true;}
    protected void libertar() {ocupado = false;}
}
