package menu;

import java.awt.Point;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import equipamentos.*;
import ginasio.Contrato;
import ginasio.Membro;
import ginasio.Plano;
import ginasio.Servico;
import pds.util.RelogioSimulado;
import regras.*;

public class Arranque {

	public static void main(String[] args) {
		// Criar o relógio simulado e "acertá-lo" para a hora atual
		RelogioSimulado relogio = RelogioSimulado.getRelogioSimulado();
		relogio.setTempoAtual(LocalDateTime.now());

		// TODO criar os serviços
		Servico entrada = new Servico("Entrada");
		Servico saida = new Servico("Saída");
		Servico aula1 = new Servico("Aula Nível 1");
		Servico aula2 = new Servico("Aula Nível 2");
		Servico piscina = new Servico("Piscina");
		Servico duche = new Servico("Duche");
		Servico bebida = new Servico("Bebida Vitaminada");
		Servico personal = new Servico("Personal Trainer");
		Servico nutricao = new Servico("Consulta Nutrição");
		Servico avaliacao = new Servico("Avaliação Física");
		Servico massagem = new Servico("Cadeira de massagem");

		// TODO criar os equipamentos
		PortaEntrada portaEntrada = new PortaEntrada("Porta Entrada", entrada, Duration.ofSeconds(3));
		PortaSaida portaSaida = new PortaSaida("Porta Saída", saida, Duration.ofSeconds(3));
		PortaPiscina portaPiscina = new PortaPiscina("Porta Piscina", piscina, true, Duration.ofSeconds(3));

		Aula step = new Aula("Aula de Step", aula1, true, Duration.ofMinutes(30), 30);
		Aula cycling = new Aula("Aula de Cycling", aula1, true, Duration.ofMinutes(50), 25);
		Aula bodyCombat = new Aula("Aula de Body Combat", aula2, true, Duration.ofMinutes(30), 20);
		Aula ioga = new Aula("Aula de Ioga", aula2,true, Duration.ofMinutes(60), 15);

		DispensadorBebida dispensador = new DispensadorBebida("Dispensador de Bebida", bebida, true, Duration.ofSeconds(20));

		Duche duche1 = new Duche("Duche 1", duche, true);
		Duche duche2 = new Duche("Duche 2", duche, true);
		Duche duche3 = new Duche("Duche 3", duche, true);

		PersonalTrainer manel = new PersonalTrainer("Manel Mandão", personal, true, Duration.ZERO);
        PersonalTrainer rita  = new PersonalTrainer("Rita Rígida",  personal, true, Duration.ZERO);

		Nutricionista carlos = new Nutricionista("Carlos Comilão", nutricao, true, Duration.ofMinutes(30));
        Nutricionista marta  = new Nutricionista("Marta Magra",    nutricao, true, Duration.ofMinutes(30));

		SalaAvaliacao salaAvaliacao = new SalaAvaliacao("Sala de avaliação", avaliacao, true, Duration.ofMinutes(20));

        CadeiraMassagem cadeira1 = new CadeiraMassagem("Cadeira de massagem 1", massagem, true, Duration.ofMinutes(10));
        CadeiraMassagem cadeira2 = new CadeiraMassagem("Cadeira de massagem 2", massagem, true, Duration.ofMinutes(10));


		// TODO criar os membros

		Membro m1 = new Membro(1, "Vítor Virtual");
		Membro m2 = new Membro(2, "Iris Irreal");
		Membro m3 = new Membro(3, "Inês Inexistente");
		Membro m4 = new Membro(4, "Filipe Fictício");
		Membro m5 = new Membro(5, "Diogo Digital");
		Membro m6 = new Membro(6, "Beatriz Bytes");

		// TODO criar os planos para cada membro

		Plano p1 = new Plano("vítor");
		p1.AdicionarContratos(new Contrato(entrada,   new PorSemana(3, Duration.ofHours(1))));
		p1.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p1.AdicionarContratos(new Contrato(aula1,     new PorSemana(1)));
        p1.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(3), Duration.ofMinutes(2))));
        p1.AdicionarContratos(new Contrato(bebida,    new PorDia(1, Duration.ZERO)));
        p1.AdicionarContratos(new Contrato(nutricao,  new Periodica(6)));
        p1.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));
		m1.adicionarPlano(p1);


		Plano p2 = new Plano("iris");
		p2.AdicionarContratos(new Contrato(entrada,   new PorSemana(3, Duration.ofMinutes(60))));
        p2.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p2.AdicionarContratos(new Contrato(piscina,   new PorSemana(2, Duration.ofMinutes(45))));
        p2.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(5), Duration.ofMinutes(2))));
        p2.AdicionarContratos(new Contrato(bebida,    new PorDia(2, Duration.ofMinutes(30))));
        p2.AdicionarContratos(new Contrato(personal,  new PorSemana(3, Duration.ofMinutes(45))));
        p2.AdicionarContratos(new Contrato(nutricao,  new Periodica(6)));
        p2.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));
		m2.adicionarPlano(p2);


		Plano p3 = new Plano("ines");
		p3.AdicionarContratos(new Contrato(entrada,   new Sempre()));
        p3.AdicionarContratos(new Contrato(saida,     new Sempre()));
        p3.AdicionarContratos(new Contrato(aula1,     new PorSemana(1)));
        p3.AdicionarContratos(new Contrato(duche,     new DuchePlano(1, Duration.ofMinutes(5), Duration.ofMinutes(2))));
        p3.AdicionarContratos(new Contrato(bebida,    new PorDia(2, Duration.ofMinutes(30))));
        p3.AdicionarContratos(new Contrato(nutricao,  new Periodica(1)));
        p3.AdicionarContratos(new Contrato(avaliacao, new Periodica(3)));
		m3.adicionarPlano(p3);


		Plano p4 = new Plano("filipe");
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
		m4.adicionarPlano(p4);


		Plano p5 = new Plano("diogo");
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
		m5.adicionarPlano(p5);


		Plano p6 = new Plano("beatriz");
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
		m6.adicionarPlano(p6);


		SwingUtilities.invokeLater(() -> {
			JanelaGinasio main = new JanelaGinasio();

			// TODO adicionar os equipamentos ao simulador (ids apenas exemplificativos)
			main.addEquipamento(10, getIcons("porta"));
			main.addEquipamento(11, getIcons("bebida"));
			main.addEquipamento(12, getIcons("duche"));
			main.addEquipamento(13, getIcons("pt"));
			main.addEquipamento(14, getIcons("nutricionista"));
			main.addEquipamento(15, getIcons("poltrona"));
			main.addEquipamento(16, getIcons("aula"));
			main.addEquipamento(17, getIcons("fisica"));
			main.addEquipamento(18, getIcons("porta_piscina"));

			main.setVisible(true);
			RelogioDialog relog = new RelogioDialog(main, new Point(200, 20));
			relog.setVisible(true);

		});
	}

	/**
	 * Lê os ficheiros com os icons para um dado equipamento
	 * 
	 * @param nome nome da imagem representativa do equipamento
	 * @return os icones com a imagem livre e ocupado
	 */
	private static ImageIcon[] getIcons(String nome) {
		String pasta = "/home/joelmalacas/Documents/ESTGym/art/";
		ImageIcon icons[] = { new ImageIcon(pasta + nome + "_livre.png"),
				new ImageIcon(pasta + nome + "_ocupado.png") };
		return icons;
	}
}
