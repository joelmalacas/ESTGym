package equipamentos;

import ginasio.Equipamento;
import ginasio.Membro;
import ginasio.Servico;
import pds.util.Validator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Aula extends Equipamento {

    private final int capacidade;
    private final Set<Membro> inscritos = new HashSet<>();
    private LocalDateTime inicio;

    public Aula(String nome, Servico servico, boolean exigeEntrada, Duration duracao, int capacidade) {
        super(nome, servico, exigeEntrada, duracao);
        this.capacidade = Validator.requirePositive(capacidade);
    }

    public boolean isCheio(LocalDateTime agora) {
        atualizar(agora);
        return inscritos.size() >= capacidade;
    }

    public boolean podeInscrever(Membro membro, LocalDateTime agora) {
        atualizar(agora);
        return !isCheio(agora) && !inscritos.contains(membro);
    }

    public Duration inscrever(Membro membro, LocalDateTime agora) {
        if (!podeInscrever(membro, agora))
            throw new IllegalArgumentException("Nao e possível inscrever " + membro.getNome());
        Objects.requireNonNull(inicio);

        inscritos.add(membro);
        return Duration.between(agora, inicio.plus(getDuracao()));
    }

    private void atualizar(LocalDateTime agora) {
        if (inicio != null && !agora.isBefore(inicio.plus(getDuracao()))) {
            inicio = null;
            inscritos.clear();
        }
    }

    //Getters
    public int getCapacidade() {
        return capacidade;
    }
    public int getNumeroInscritos(LocalDateTime agora) {
        atualizar(agora);
        return inscritos.size();
    }
}
