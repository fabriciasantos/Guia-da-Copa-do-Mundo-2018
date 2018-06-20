package worldcup;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface extends JFrame {

    private static JButton btnIniciar = new JButton("Iniciar");
    private static JComboBox<String> comboOrigem = new JComboBox<>();
    private static JComboBox<String> comboDestino = new JComboBox<>();

    private static JLabel ecaterimburgo = new JLabel("ecaterimburgo;");
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

        ecaterimburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        ecaterimburgo.setBounds(510, 513, 20, 27);
        getContentPane().add(ecaterimburgo);

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

        comboOrigem.addItem("Ecterimburgo");
        comboOrigem.addItem("Sao Petersburgo");
        comboOrigem.addItem("Rostov");
        comboOrigem.addItem("Samara");
        comboOrigem.addItem("Volgogrado");
        comboOrigem.addItem("Sochi");
        comboOrigem.addItem("Kazan");
        comboOrigem.addItem("Saransk");
        comboOrigem.addItem("Kalingrado");
        comboOrigem.addItem("Moscou");
        comboOrigem.addItem("Nijni_novgorod");

        comboDestino.addItem("Ecterimburgo");
        comboDestino.addItem("Sao Petersburgo");
        comboDestino.addItem("Rostov");
        comboDestino.addItem("Samara");
        comboDestino.addItem("Volgogrado");
        comboDestino.addItem("Sochi");
        comboDestino.addItem("Kazan");
        comboDestino.addItem("Saransk");
        comboDestino.addItem("Kalingrado");
        comboDestino.addItem("Moscou");
        comboDestino.addItem("Nijni_novgorod");

        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/telaIA2.png")));
        lblNewLabel.setBounds(0, 0, 994, 760);
        getContentPane().add(lblNewLabel);

        setVisible(true);
    }

    public static void main(String[] args) {

        Interface tela = new Interface();

        btnIniciar.addActionListener(e -> {
            int origem = comboOrigem.getSelectedIndex();
            System.out.println("origem = " + origem);
            int destino = comboDestino.getSelectedIndex();
            System.out.println("destino = " + destino);
            tela.execute(origem, destino);
        });
    }

    public void clearWay(){
        ecaterimburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        sao_petersburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        rostov.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        samara.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        volgogrado.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        sochi.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        kazan.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        saransk.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        kalingrado.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        moscou.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
        nijni_novgorod.setIcon(new ImageIcon(getClass().getResource("/imagens/point-red.png")));
    }

    public void execute(int origem, int destino) {
        clearWay();
        uniformcostsearch us = new uniformcostsearch();
        Node src = (Node) us.cities.get(origem);
        Node dest = (Node) us.cities.get(destino);
        ArrayList<Node> ucsPath = us.ucs(src, dest);
        System.out.println("The number of nodes generated is: " + us.ucsNumOfNodesGenerated);
        System.out.println("The maximum number of nodes that existed in memory is: " + us.ucsMaxNumOfNodesInMemory);
        System.out.print("The path from source to destination is: ");
        for (int i = 0; i < ucsPath.size(); i++) {
            switch (ucsPath.get(i).city) {
                case 0:
                    ecaterimburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 1:
                    sao_petersburgo.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 2:
                    rostov.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 3:
                    samara.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 4:
                    volgogrado.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 5:
                    sochi.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 6:
                    kazan.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 7:
                    saransk.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 8:
                    kalingrado.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 9:
                    moscou.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
                case 10:
                    nijni_novgorod.setIcon(new ImageIcon(getClass().getResource("/imagens/point-green.png")));
                    break;
            }
            us.resetParameters();
        }
    }
}
