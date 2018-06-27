import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rotas extends JPanel{

    private static final long serialVersionUID = 1L;
    
	private final String PASTA_IMG = "/imagens-PNG/";
    
	private JLabel ecaterimburgo, sao_petersburgo, rostov, samara, volgogrado,
            sochi, kazan, saransk, kalinigrado, moscou, nijni_novgorod;
    private boolean showPath;

	public Rotas(){
        super();
    }

    public void init(){
        setLayout(null);

        add(ecaterimburgo = carregarLabel("ECATERIMBURGO.png", 510, 500, 240, 35));
		add(sao_petersburgo = carregarLabel("SAINT PETERSBURGO.png", 180, 230, 255, 55));
        add(rostov = carregarLabel("ROSTOV.png", 60, 530, 100, 40));
        add(samara = carregarLabel("SAMARA.png", 310, 550, 100, 40));
        add(volgogrado = carregarLabel("VOLVOGRADO.png", 140, 560, 150, 43));
        add(sochi = carregarLabel("SOCHI.png", 6, 625, 80, 50));
        add(kazan = carregarLabel("KAZAN.png",435, 400, 80, 50));
        add(saransk = carregarLabel("SARANSK.png", 250, 405, 110, 50));
        add(kalinigrado = carregarLabel("KALINIGRADO.png", 52, 205, 170, 50));
        add(moscou = carregarLabel("MOSCOW.png", 196, 360, 100, 50));
        add(nijni_novgorod = carregarLabel("NIJNI.png", 317, 365, 210, 50));

		add(carregarLabel("TelaInicial.png", 0, 0, 990, 720));
    }

    
	public void clearPath() {
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
        showPath = false;
    }
    
    public void showPath(Cidade caminho){
        while (true) {
			switch (caminho.getPosition()) {
                case Data.Kaliningrado: kalinigrado.setVisible(true); break;
                case Data.Sao_Petersburgo: sao_petersburgo.setVisible(true); break;
                case Data.Moscou: moscou.setVisible(true); break;
                case Data.Saransk: saransk.setVisible(true); break;
                case Data.Nijni_Novgorod: nijni_novgorod.setVisible(true); break;
                case Data.Kazan: kazan.setVisible(true); break;
                case Data.Ecaterimburgo: ecaterimburgo.setVisible(true); break;
                case Data.Samara: samara.setVisible(true); break;
                case Data.Volgogrado: volgogrado.setVisible(true); break;
                case Data.Rostov: rostov.setVisible(true); break;
                case Data.Sochi: sochi.setVisible(true); break;
			}
			if (caminho.getPai() == null)
				break;
			caminho = caminho.getPai();
        }
        showPath = true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(showPath){
            
            ((Graphics2D) g).drawLine(10, 10, 500, 600);
        }
    }

	private JLabel carregarLabel(String imagem, int x, int y, int largura, int altura){
        JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getResource(PASTA_IMG + imagem)));
		label.setBounds(x, y, largura, altura);
		return label;
	}
}