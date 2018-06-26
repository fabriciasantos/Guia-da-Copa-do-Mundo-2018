import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class Interface extends JFrame {

	protected static JButton btnIniciar = new JButton("Iniciar");
	protected static JComboBox<String> comboOrigem = new JComboBox<>();
	protected static JComboBox<String> comboDestino = new JComboBox<>();
	protected static JLabel ecaterimburgo = new JLabel("ecaterimburgo;");
	protected static JLabel sao_petersburgo = new JLabel("sao_petersburgo;");
	protected static JLabel rostov = new JLabel("rostov;");
	protected static JLabel samara = new JLabel("samara;");
	protected static JLabel volgogrado = new JLabel("volgogrado;");
	protected static JLabel sochi = new JLabel("sochi;");
	protected static JLabel kazan = new JLabel("kazan;");
	protected static JLabel saransk = new JLabel("saransk;");
	protected static JLabel kalinigrado = new JLabel("kalinigrado;");
	protected static JLabel moscou = new JLabel("moscou;");
	protected static JLabel nijni_novgorod = new JLabel("nijni_novgorod;");

	public Interface() {
		setTitle("World Cup Russia 2018");
		setSize(994, 735);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		ecaterimburgo.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/ECATERIMBURGO.png")));
		ecaterimburgo.setBounds(510, 500, 240, 35);
		getContentPane().add(ecaterimburgo);

		sao_petersburgo.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/SAINT PETERSBURGO.png")));
		sao_petersburgo.setBounds(180, 230, 255, 55);
		getContentPane().add(sao_petersburgo);

		rostov.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/ROSTOV.png")));
		rostov.setBounds(60, 530, 100, 40);
		getContentPane().add(rostov);

		samara.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/SAMARA.png")));
		samara.setBounds(310, 550, 100, 40);
		getContentPane().add(samara);

		volgogrado.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/VOLVOGRADO.png")));
		volgogrado.setBounds(140, 560, 150, 43);
		getContentPane().add(volgogrado);

		sochi.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/SOCHI.png")));
		sochi.setBounds(6, 625, 80, 50);
		getContentPane().add(sochi);

		kazan.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/KAZAN.png")));
		kazan.setBounds(435, 400, 80, 50);
		getContentPane().add(kazan);

		saransk.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/SARANSK.png")));
		saransk.setBounds(250, 405, 110, 50);
		getContentPane().add(saransk);

		kalinigrado.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/KALINIGRADO.png")));
		kalinigrado.setBounds(52, 205, 170, 50);
		getContentPane().add(kalinigrado);

		moscou.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/MOSCOW.png")));
		moscou.setBounds(196, 360, 100, 50);
		getContentPane().add(moscou);

		nijni_novgorod.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/NIJNI.png")));
		nijni_novgorod.setBounds(317, 365, 210, 50);
		getContentPane().add(nijni_novgorod);

		comboOrigem.setMaximumRowCount(11);
		comboOrigem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboOrigem.setBounds(840, 367, 130, 24);
		getContentPane().add(comboOrigem);

		comboDestino.setMaximumRowCount(11);
		comboDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboDestino.setBounds(840, 408, 130, 24);
		getContentPane().add(comboDestino);

		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciar.setBounds(846, 465, 124, 30);
		getContentPane().add(btnIniciar);

		comboOrigem.addItem("Kaliningrado");
		comboOrigem.addItem("Sao Petersburgo");
		comboOrigem.addItem("Moscou");
		comboOrigem.addItem("Saransk");
		comboOrigem.addItem("Nijni Novgorod");
		comboOrigem.addItem("Kazan");
		comboOrigem.addItem("Ecaterimburgo");
		comboOrigem.addItem("Samara");
		comboOrigem.addItem("Volgogrado");
		comboOrigem.addItem("Rostov");
		comboOrigem.addItem("Sochi");

		comboDestino.addItem("Kaliningrado");
		comboDestino.addItem("Sao Petersburgo");
		comboDestino.addItem("Moscou");
		comboDestino.addItem("Saransk");
		comboDestino.addItem("Nijni Novgorod");
		comboDestino.addItem("Kazan");
		comboDestino.addItem("Ecaterimburgo");
		comboDestino.addItem("Samara");
		comboDestino.addItem("Volgogrado");
		comboDestino.addItem("Rostov");
		comboDestino.addItem("Sochi");

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Russia Cup Map");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/imagens-PNG/TelaInicial.png")));
		lblNewLabel.setBounds(0, 0, 990, 720);
		getContentPane().add(lblNewLabel);

		setVisible(true);
	}

	/* public void clearPath() {
		ecaterimburgo.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/ECATERIMBURGO.png")));
		sao_petersburgo.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/SAINT PETERSBURGO.png")));
		rostov.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/ROSTOV.png")));
		samara.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/SAMARA.png")));
		volgogrado.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/VOLVOGRADO.png")));
		sochi.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/SOCHI.png")));
		kazan.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/KAZAN.png")));
		saransk.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/SARANSK.png")));
		kalinigrado.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/KALINIGRADO.png")));
		moscou.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/MOSCOW.png")));
		nijni_novgorod.setIcon(new
		ImageIcon(getClass().getResource("/imagens-PNG/NIJNI.png")));
	 }
	*/
	public void clearPaht() {
		ecaterimburgo.setVisible(false);
		sao_petersburgo.setVisible(false);
		rostov.setVisible(false);
		samara.setVisible(false);
		volgogrado.setVisible(false);
		sochi.setVisible(false);
		kazan.setVisible(false);
		saransk.setVisible(false);
		kalinigrado.setVisible(false);
		moscou.setVisible(false);
		nijni_novgorod.setVisible(false);
	}

	public void showPath(Cidade caminho) {
		clearPaht();
		while (true) {
			switch (caminho.getPosition()) {
			case 0:
				kalinigrado.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/KALINIGRADO.png")));
				kalinigrado.setVisible(true);
				break;
			case 1:
				sao_petersburgo
						.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/SAINT PETERSBURGO.png")));
				sao_petersburgo.setVisible(true);
				break;
			case 2:
				moscou.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/MOSCOW.png")));
				moscou.setVisible(true);
				break;
			case 3:
				saransk.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/SARANSK.png")));
				saransk.setVisible(true);
				break;
			case 4:
				nijni_novgorod.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/NIJNI.png")));
				nijni_novgorod.setVisible(true);
				break;
			case 5:
				kazan.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/KAZAN.png")));
				kazan.setVisible(true);
				break;
			case 6:
				ecaterimburgo.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/ECATERIMBURGO.png")));
				ecaterimburgo.setVisible(true);
				break;
			case 7:
				samara.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/SAMARA.png")));
				samara.setVisible(true);
				break;
			case 8:
				volgogrado.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/VOLVOGRADO.png")));
				volgogrado.setVisible(true);
				break;
			case 9:
				rostov.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/ROSTOV.png")));
				rostov.setVisible(true);
				break;
			case 10:
				sochi.setIcon(new ImageIcon(Interface.class.getResource("/imagens-PNG/SOCHI.png")));
				sochi.setVisible(true);
				break;
			}
			if (caminho.getPai() == null)
				break;
			caminho = caminho.getPai();
		}

	}

	public static void main(String[] args) {

		// Inicializando interface
		Interface tela = new Interface();

		btnIniciar.addActionListener(e -> {
			// tela.clearPath();
			tela.showPath(new UniformCustSearch().uniformCustSearch(comboOrigem.getSelectedIndex(),
					comboDestino.getSelectedIndex()));
		});
	}
}
