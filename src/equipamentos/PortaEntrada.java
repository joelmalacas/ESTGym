package equipamentos;

import ginasio.Membro;
import ginasio.Servico;

import java.time.Duration;
import java.time.LocalDateTime;

public class PortaEntrada extends Porta{

    public PortaEntrada(int id, String nome, Servico servico, Duration duracao) {
        super(id, nome, servico, false, duracao);
    }

    @Override
    public void usar(Membro m) {
        super.usar(m);
        m.entrar();
    }

    @Override
    protected Duration duracaoServico(Membro m, LocalDateTime agora) {
        return getDuracao();
    }

    @Override
    public boolean podeUsar(Membro m) {
        return !m.estaDentro() && super.podeUsar(m);
    }
}
