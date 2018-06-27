import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

	protected static JButton btnIniciar = new JButton("Iniciar");
	protected static JComboBox<String> comboOrigem = new JComboBox<>();
	protected static JComboBox<String> comboDestino = new JComboBox<>();
	protected static Rotas rota = new Rotas();

	public Interface() {
		setTitle("World Cup Russia 2018");
		setSize(994, 735);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		final Font fonte = new Font("Tahoma", Font.PLAIN, 14);
		final String[] cidades = new String[]{
			"Kaliningrado", "Sao Petersburgo", "Moscou", "Saransk", "Nijni Novgorod",
			"Kazan", "Ecaterimburgo", "Samara", "Volgogrado", "Rostov", "Sochi"
		};

		comboOrigem = new JComboBox<>(new DefaultComboBoxModel<>(cidades));
		comboOrigem.setFont(fonte);
		comboOrigem.setBounds(840, 367, 130, 24);
		add(comboOrigem);

		comboDestino = new JComboBox<>(new DefaultComboBoxModel<>(cidades));
		comboDestino.setFont(fonte);
		comboDestino.setBounds(840, 408, 130, 24);
		add(comboDestino);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(fonte);
		btnIniciar.setBounds(846, 465, 124, 30);
		add(btnIniciar);

		rota.setBounds(0, 0, 990, 720);
		rota.init();
		getContentPane().add(rota);

		setVisible(true);
	}
	
	public void clearPaht() {
		rota.clearPath();
	}

	public void showPath(Cidade caminho) {
		rota.clearPath();
		rota.showPath(caminho);	
	}

	public static void main(String[] args) {

		Interface tela = new Interface();

		btnIniciar.addActionListener(e -> {
			tela.showPath(new UniformCustSearch().uniformCustSearch(comboOrigem.getSelectedIndex(),
					comboDestino.getSelectedIndex()));
		});
	}
}
