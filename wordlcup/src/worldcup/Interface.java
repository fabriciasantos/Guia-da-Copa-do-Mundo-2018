package worldcup;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface extends JFrame {

    private static JButton btnIniciar = new JButton("Iniciar");
    private static JComboBox<String> comboOrigem = new JComboBox<>();
    private static JComboBox<String> comboDestino = new JComboBox<>();

    private static JLabel ecterimburgo = new JLabel("ecterimburgo;");
    private static JLabel sao_petersburgo = new JLabel("sao_petersburgo;");
    private static JLabel rostov = new JLabel("rostov;");
    private static JLabel samara = new JLabel("samara;");
    private static JLabel volgogrado = new JLabel("volgogrado;");
    private static JLabel sochi = new JLabel("sochi;");
    private static JLabel kazan = new JLabel("kazan;");
    private static JLabel saransk = new JLabel("saransk;");
    private static JLabel kalingrado = new JLabel("kalingrado;");
    private static JLabel moscou = new JLabel("moscou;");
    private static JLabel nijni_novgorod = new JLabel("nijni_novgorod;");

    public Interface() {
        setTitle("World Cup Russia 2018");
        setSize(994, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        ecterimburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        ecterimburgo.setBounds(510, 513, 20, 27);
        getContentPane().add(ecterimburgo);

        sao_petersburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        sao_petersburgo.setBounds(232, 260, 20, 27);
        getContentPane().add(sao_petersburgo);

        rostov.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        rostov.setBounds(110, 541, 20, 27);
        getContentPane().add(rostov);

        samara.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        samara.setBounds(328, 530, 20, 27);
        getContentPane().add(samara);

        volgogrado.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        volgogrado.setBounds(195, 551, 20, 27);
        getContentPane().add(volgogrado);

        sochi.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        sochi.setBounds(54, 606, 20, 27);
        getContentPane().add(sochi);

        kazan.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        kazan.setBounds(421, 392, 20, 27);
        getContentPane().add(kazan);

        saransk.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        saransk.setBounds(272, 393, 20, 27);
        getContentPane().add(saransk);

        kalingrado.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        kalingrado.setBounds(52, 235, 20, 27);
        getContentPane().add(kalingrado);

        moscou.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        moscou.setBounds(219, 391, 20, 27);
        getContentPane().add(moscou);

        nijni_novgorod.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        nijni_novgorod.setBounds(317, 382, 20, 27);
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
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/telaIA2.png")));
        lblNewLabel.setBounds(0, 0, 994, 760);
        getContentPane().add(lblNewLabel);

        setVisible(true);
    }

    public static void main(String[] args) {

        new Interface();

        btnIniciar.addActionListener(e -> {
            new Interface().execute();
        });
    }

    public void execute() {
        uniformcostsearch us = new uniformcostsearch();
        Node src = (Node) us.cities.get(0);
        Node dest = (Node) us.cities.get(10);
        ArrayList<Node> ucsPath = us.ucs(src, dest);
        System.out.println("The number of nodes generated is: " + us.ucsNumOfNodesGenerated);
        System.out.println("The maximum number of nodes that existed in memory is: " + us.ucsMaxNumOfNodesInMemory);
        System.out.print("The path from source to destination is: ");
        for (int i = 0; i < ucsPath.size(); i++) {
            switch (ucsPath.get(i).city) {
                case 0:
                    System.out.print("ECATERIMBURGO ");
                    break;
                case 1:
                    System.out.print("SAO_PETERSBURGO ");
                    break;
                case 2:
                    System.out.print("ROSTOV ");
                    break;
                case 3:
                    System.out.print("SAMARA ");
                    break;
                case 4:
                    System.out.print("VOLGOGRADO ");
                    break;
                case 5:
                    System.out.print("SOCHI ");
                    break;
                case 6:
                    System.out.print("KAZAN ");
                    break;
                case 7:
                    System.out.print("SARANSK ");
                    break;
                case 8:
                    System.out.print("KALININGRADO ");
                    break;
                case 9:
                    System.out.print("MOSCOU ");
                    break;
                case 10:
                    System.out.print("NIJNI_NOVGOROD ");
                    break;
            }
            us.resetParameters();
        }
    }
}
