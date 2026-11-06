package equipamentos;

import ginasio.Equipamento;
import ginasio.Membro;
import ginasio.Servico;

import java.time.Duration;
import java.time.LocalDateTime;

public class Duche  extends Equipamento {

    public Duche(String nome, Servico servico, boolean exigeEntrada) {
        super(nome, servico, exigeEntrada, Duration.ZERO);
    }

    public Duration duracaoPara(Membro membro, LocalDateTime agora) {
        return membro.getContrato(getServico())
                .orElseThrow(() -> new IllegalStateException(membro.getNome() + " não tem duche no servico"))
                .getRegra()
                .duracao(membro.getRegistos(getServico()), agora, getDuracao());
    }
}
