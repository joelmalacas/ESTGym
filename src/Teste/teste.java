package Teste;

import equipamentos.*;
import ginasio.*;
import pds.util.RelogioSimulado;
import regras.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class teste {

    public static void main(String[] args) {
        executar();
    }

    public static void executar() {
        RelogioSimulado relogio = RelogioSimulado.getRelogioSimulado();
        relogio.setTempoAtual(LocalDateTime.now());

        // ---------------------------------------------------------------
        // 1. SERVIÇOS
        // ---------------------------------------------------------------
        Servico entrada   = new Servico("Entrada");
        Servico saida     = new Servico("Saída");
        Servico aula1     = new Servico("Aula_1");
        Servico aula2     = new Servico("Aula_2");
        Servico piscina   = new Servico("Piscina");
        Servico duche     = new Servico("Duche");
        Servico bebida    = new Servico("Bebida vitaminada");
        Servico personal  = new Servico("Personal Trainer");
        Servico nutricao  = new Servico("Consulta nutrição");
        Servico avaliacao = new Servico("Avaliação física");
        Servico massagem  = new Servico("Cadeira de massagem");

        // ---------------------------------------------------------------
        // 2. EQUIPAMENTOS (exigem entrada prévia, exceto a porta de entrada)
        // ---------------------------------------------------------------
        PortaEntrada portaEntrada = new PortaEntrada("Porta de entrada", entrada, Duration.ofSeconds(3));
        PortaSaida portaSaida = new PortaSaida("Porta de saída", saida, Duration.ofSeconds(3));
        PortaPiscina portaPiscina = new PortaPiscina("Entrada da piscina", piscina, true, Duration.ofSeconds(3));

        // (nome, servico, exigeEntrada, duração, capacidade)
        Aula step       = new Aula("Step",        aula1, true, Duration.ofMinutes(30), 30); // nível 1
        Aula cycling    = new Aula("Cycling",     aula1, true, Duration.ofMinutes(50), 25); // nível 1
        Aula bodyCombat = new Aula("Body combat", aula2, true, Duration.ofMinutes(30), 20); // nível 2
        Aula ioga       = new Aula("Ioga",        aula2, true, Duration.ofMinutes(60), 15); // nível 2

        DispensadorBebida dispensador = new DispensadorBebida("Dispensador de bebida", bebida, true, Duration.ofSeconds(20));

        // Duches: a duração vem do plano
        Duche duche1 = new Duche("Duche 1", duche, true);
        Duche duche2 = new Duche("Duche 2", duche, true);
        Duche duche3 = new Duche("Duche 3", duche, true);

        // Pessoas tratadas como equipamentos: a duração vem do plano
        PersonalTrainer manel = new PersonalTrainer("Manel Mandão", personal, true, Duration.ZERO);
        PersonalTrainer rita  = new PersonalTrainer("Rita Rígida",  personal, true, Duration.ZERO);

        Nutricionista carlos = new Nutricionista("Carlos Comilão", nutricao, true, Duration.ofMinutes(30));
        Nutricionista marta  = new Nutricionista("Marta Magra",    nutricao, true, Duration.ofMinutes(30));

        SalaAvaliacao salaAvaliacao = new SalaAvaliacao("Sala de avaliação", avaliacao, true, Duration.ofMinutes(20));

        CadeiraMassagem cadeira1 = new CadeiraMassagem("Cadeira de massagem 1", massagem, true, Duration.ofMinutes(10));
        CadeiraMassagem cadeira2 = new CadeiraMassagem("Cadeira de massagem 2", massagem, true, Duration.ofMinutes(10));

        // ---------------------------------------------------------------
        // 3. MEMBROS E PLANOS (valores inventados, regras da secção 6)
        // ---------------------------------------------------------------

        // 1 - Vítor Virtual: completo, sem cadeira de massagem
        Plano p1 = new Plano("Premium");
        p1.AdicionarContratos(new Contrato(entrada,   new PorSemana(3, Duration.ofHours(1))));
        p1.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p1.AdicionarContratos(new Contrato(aula1,     new PorSemana(1)));
        p1.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(3), Duration.ofMinutes(2))));
        p1.AdicionarContratos(new Contrato(bebida,    new PorDia(1, Duration.ZERO)));
        p1.AdicionarContratos(new Contrato(nutricao,  new Periodica(6)));
        p1.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));
        Membro m1 = new Membro(1, "Vítor Virtual");
        m1.adicionarPlano(p1);

        // 2 - Iris Irreal: sem piscina, personal nem cadeira
        Plano p2 = new Plano("Standard");
        p2.AdicionarContratos(new Contrato(entrada,   new PorSemana(3, Duration.ofMinutes(60))));
        p2.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p2.AdicionarContratos(new Contrato(piscina,   new PorSemana(2, Duration.ofMinutes(45))));
        p2.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(5), Duration.ofMinutes(2))));
        p2.AdicionarContratos(new Contrato(bebida,    new PorDia(2, Duration.ofMinutes(30))));
        p2.AdicionarContratos(new Contrato(personal,  new PorSemana(3, Duration.ofMinutes(45))));
        p2.AdicionarContratos(new Contrato(nutricao,  new Periodica(6)));
        p2.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));
        Membro m2 = new Membro(2, "Iris Irreal");
        m2.adicionarPlano(p2);

        // 3 - Inês Inexistente: piscina, sem personal nem cadeira
        Plano p3 = new Plano("Aquático");
        p3.AdicionarContratos(new Contrato(entrada,   new Sempre()));
        p3.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p3.AdicionarContratos(new Contrato(aula1,     new PorSemana(1)));
        p3.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(5), Duration.ofMinutes(2))));
        p3.AdicionarContratos(new Contrato(bebida,    new PorDia(2, Duration.ofMinutes(30))));
        p3.AdicionarContratos(new Contrato(nutricao,  new Periodica(1)));
        p3.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));
        Membro m3 = new Membro(3, "Inês Inexistente");
        m3.adicionarPlano(p3);

        // 4 - Filipe Fictício: personal trainer + cadeira, sem piscina
        Plano p4 = new Plano("Performance");
        p4.AdicionarContratos(new Contrato(entrada,   new PorSemana(3)));
        p4.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p4.AdicionarContratos(new Contrato(aula1,     new PorSemana(2)));
        p4.AdicionarContratos(new Contrato(aula2,     new PorSemana(1)));
        p4.AdicionarContratos(new Contrato(piscina,   new PorSemana(2, Duration.ofMinutes(45))));
        p4.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(5), Duration.ofMinutes(2))));
        p4.AdicionarContratos(new Contrato(bebida,    new PorDia(2, Duration.ofMinutes(30))));
        p4.AdicionarContratos(new Contrato(personal,  new PorSemana(3, Duration.ofMinutes(45))));
        p4.AdicionarContratos(new Contrato(nutricao,  new Periodica(6)));
        p4.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));

        p4.AdicionarContratos(new Contrato(massagem,  new PorSemana(3)));
        p4.AdicionarContratos(new Contrato(massagem,  new PorDia(1, Duration.ofMinutes(10))));

        Membro m4 = new Membro(4, "Filipe Fictício");
        m4.adicionarPlano(p4);

        // 5 - Diogo Digital: básico, sem piscina nem personal
        Plano p5 = new Plano("Básico");
        p5.AdicionarContratos(new Contrato(entrada,  new Sempre()));
        p5.AdicionarContratos(new Contrato(saida,    new Sempre()));
        p5.AdicionarContratos(new Contrato(aula1,    new Sempre()));
        p5.AdicionarContratos(new Contrato(aula2,    new PorSemana(3)));
        p5.AdicionarContratos(new Contrato(piscina,  new PorSemana(5, Duration.ofMinutes(60))));
        p5.AdicionarContratos(new Contrato(duche,    new DuchePlano(2, Duration.ofMinutes(6), Duration.ofMinutes(3))));
        p5.AdicionarContratos(new Contrato(bebida,   new PorDia(4, Duration.ofMinutes(20))));
        p5.AdicionarContratos(new Contrato(nutricao, new Periodica(3)));
        p5.AdicionarContratos(new Contrato(avaliacao,new Periodica(3)));

        p5.AdicionarContratos(new Contrato(massagem, new PorSemana(7)));
        p5.AdicionarContratos(new Contrato(massagem, new PorDia(1, Duration.ofMinutes(10))));

        Membro m5 = new Membro(5, "Diogo Digital");
        m5.adicionarPlano(p5);

        // 6 - Beatriz Bytes
        Plano p6 = new Plano("VIP");
        p6.AdicionarContratos(new Contrato(entrada,   new Sempre()));
        p6.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p6.AdicionarContratos(new Contrato(aula1,     new Sempre()));
        p6.AdicionarContratos(new Contrato(aula2,     new Sempre()));
        p6.AdicionarContratos(new Contrato(duche,     new DuchePlano(2, Duration.ofMinutes(6), Duration.ofMinutes(3))));
        p6.AdicionarContratos(new Contrato(bebida,    new PorDia(4, Duration.ofMinutes(20))));
        p6.AdicionarContratos(new Contrato(personal,  new PorDia(5, Duration.ofMinutes(60))));
        p6.AdicionarContratos(new Contrato(nutricao,  new Periodica(1)));
        p6.AdicionarContratos(new Contrato(avaliacao, new Periodica(1)));

        p6.AdicionarContratos(new Contrato(massagem,  new PorSemana(3)));
        p6.AdicionarContratos(new Contrato(massagem,  new PorDia(1, Duration.ofMinutes(10))));

        Membro m6 = new Membro(6, "Beatriz Bytes");
        m6.adicionarPlano(p6);

        //======OUTPUT======
        Membro[] membros = {m1, m2, m3, m4, m5, m6};
        Servico[] servicos = {entrada, saida, aula1, aula2, piscina, duche, bebida,
                personal, nutricao, avaliacao, massagem};
        LocalDateTime agora = relogio.getTempoAtual();

        for (Membro m : membros) {
            System.out.println("== " + m.getNome() + " (dentro: " + m.estaDentro() + ") ==");
            for (Servico s : servicos) {
                String resultado;
                if (!m.temContrato(s)) {
                    resultado = "SEM CONTRATO";
                } else {
                    // SUPOSIÇÃO: Contrato.getRegra() devolve a RegraAcesso
                    boolean permite = m.getContrato(s).get().getRegra()
                            .permite(m.getRegistos(s), agora);
                    resultado = permite ? "PERMITIDO" : "RECUSADO (regra)";
                }
                System.out.printf("  %-22s %s%n", s.getNome(), resultado);
            }
            System.out.println();
        }
    }
}