package wordlcup;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.print.DocFlavor.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.sun.prism.Image;
import com.sun.tracing.dtrace.ArgsAttributes;

import java.awt.Font;

public class tela2 extends JFrame {

	public tela2() {
		setTitle("World Cup Russia 2018");
		setSize(1000, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JComboBox<String> comboOrigem = new JComboBox<String>();
		comboOrigem.setMaximumRowCount(11);
		comboOrigem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboOrigem.setBounds(840, 332, 130, 24);
		getContentPane().add(comboOrigem);

		JComboBox<String> comboDestino = new JComboBox<String>();
		comboDestino.setMaximumRowCount(11);
		comboDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboDestino.setBounds(840, 373, 130, 24);		
		getContentPane().add(comboDestino);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciar.setBounds(846, 430, 124, 30);
		getContentPane().add(btnIniciar);

		comboOrigem.addItem("Kalingrado");
		comboOrigem.addItem("Saint Petersburgo");
		comboOrigem.addItem("Moscow");
		comboOrigem.addItem("Saransk");
		comboOrigem.addItem("Nijni Novgorod");
		comboOrigem.addItem("Kazan");
		comboOrigem.addItem("Ecaterimburgo");
		comboOrigem.addItem("Samara");
		comboOrigem.addItem("Volgogrado");
		comboOrigem.addItem("Rostov");
		comboOrigem.addItem("Sochi");

		comboDestino.addItem("Kalingrado");
		comboDestino.addItem("Saint Petersburgo");
		comboDestino.addItem("Moscow");
		comboDestino.addItem("Saransk");
		comboDestino.addItem("Nijni Novgorod");
		comboDestino.addItem("Kazan");
		comboDestino.addItem("Ecaterimburgo");
		comboDestino.addItem("Samara");
		comboDestino.addItem("Volgogrado");
		comboDestino.addItem("Rostov");
		comboDestino.addItem("Sochi");
		
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Guia-da-Copa-do-Mundo-2018\\wordlcup\\src\\imagens\\telaIA2.png"));
		lblNewLabel.setBounds(0, 0, 994, 691);
		getContentPane().add(lblNewLabel);
		
		setVisible(true);	
	}

	public static void main(String[] args) {
		tela2 t = new tela2();
	}
}
