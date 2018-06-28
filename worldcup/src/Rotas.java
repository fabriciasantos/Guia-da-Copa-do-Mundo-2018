import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rotas extends JPanel{

    private static final long serialVersionUID = 1L;
    
	private final String PASTA_IMG = "/imagens-PNG/";
    
	private JLabel ecaterimburgo, sao_petersburgo, rostov, samara, volgogrado,
            sochi, kazan, saransk, kalinigrado, moscou, nijni_novgorod;
    private ArrayList<Dimension> posicoes;

	public Rotas(){
        super();
        posicoes = new ArrayList<>();
    }

    public void init(){
        setLayout(null);

        add(ecaterimburgo = carregarLabel("ECATERIMBURGO.png", 510, 500, 240, 35));
		add(sao_petersburgo = carregarLabel("SAINT PETERSBURGO.png", 180, 230, 255, 55));
        add(rostov = carregarLabel("ROSTOV.png", 60, 530, 100, 40));
        add(samara = carregarLabel("SAMARA.png", 310, 550, 100, 40));
        add(volgogrado = carregarLabel("VOLVOGRADO.png", 140, 560, 150, 43));
        add(sochi = carregarLabel("SOCHI.png", 6, 625, 80, 50));
        add(kazan = carregarLabel("KAZAN.png",435, 405, 80, 50));
        add(saransk = carregarLabel("SARANSK.png", 250, 405, 110, 50));
        add(kalinigrado = carregarLabel("KALINIGRADO.png", 52, 205, 170, 50));
        add(moscou = carregarLabel("MOSCOW.png", 196, 360, 100, 50));
        add(nijni_novgorod = carregarLabel("NIJNI.png", 315, 355, 210, 50));

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
    }
    
    public void showPath(Cidade caminho){
        
        posicoes.clear();
        
        while (true) {
			switch (caminho.getPosition()) {
                case Data.Kaliningrado: posicoes.add(showLabel(kalinigrado, 6, 35)); break;
                case Data.Sao_Petersburgo: posicoes.add(showLabel(sao_petersburgo, 76, 40)); break;
                case Data.Moscou: posicoes.add(showLabel(moscou, 39, 40)); break;
                case Data.Saransk: posicoes.add(showLabel(saransk, 53, 6)); break;
                case Data.Nijni_Novgorod: posicoes.add(showLabel(nijni_novgorod, 24, 38)); break;
                case Data.Kazan: posicoes.add(showLabel(kazan, 8, 5)); break;
                case Data.Ecaterimburgo: posicoes.add(showLabel(ecaterimburgo, 4, 24)); break;
                case Data.Samara: posicoes.add(showLabel(samara, 33, 5)); break;
                case Data.Volgogrado: posicoes.add(showLabel(volgogrado, 71, 5)); break;
                case Data.Rostov: posicoes.add(showLabel(rostov, 61, 33)); break;
                case Data.Sochi: posicoes.add(showLabel(sochi, 60, 5)); break;
			}
			if (caminho.getPai() == null)
				break;
			caminho = caminho.getPai();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(posicoes.size() > 0){
            Painter.paint(posicoes, (Graphics2D) g);
        }
    }

    private Dimension showLabel(JLabel label, int x, int y){
        label.setVisible(true);
        return new Dimension(label.getX() + x, label.getY() + y);
    }

	private JLabel carregarLabel(String imagem, int x, int y, int largura, int altura){
        JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getResource(PASTA_IMG + imagem)));
		label.setBounds(x, y, largura, altura);
		return label;
    }
    
    private static class Painter {
        private static final int raio = 8;

        static void paint(ArrayList<Dimension> posicoes, Graphics2D g2d){
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            final int size = posicoes.size();

            Dimension cOrigem = null, cDestino = null;

            if (size == 1){
                circulo(g2d, posicoes.get(size -1), Color.RED, Color.RED);

            } else if(size > 1){
                for(int i = size; i > 1; i--){
                    
                    g2d.setStroke(new BasicStroke(4));
                    cOrigem = posicoes.get(i - 1);
                    cDestino = posicoes.get(i - 2);
                    
                    //g2d.setColor(Color.PINK);
                    //g2d.drawLine(cOrigem.width, cOrigem.height, cDestino.width, cDestino.height);

                    g2d.setColor(Color.DARK_GRAY);
                    QuadCurve2D curva = new QuadCurve2D.Float();
                    Dimension angulo = angulo(cOrigem, cDestino);
                    curva.setCurve(cOrigem.width, cOrigem.height, angulo.width, angulo.height, cDestino.width, cDestino.height);
                    g2d.draw(curva);

                    circulo(g2d, cOrigem, Color.BLUE, Color.WHITE);
                }
                if (cDestino != null){
                    circulo(g2d, cDestino, Color.RED, Color.RED);
                }
            }
        }

        static void circulo(Graphics2D g2d, Dimension coord, Color borda, Color centro){

            g2d.setColor(centro);
            int x = coord.width - (raio / 2) - 2;
            int y = coord.height - (raio / 2) - 2;
            g2d.fillOval(x, y, raio * 2, raio * 2);

            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(borda);
            g2d.drawOval(x, y, raio * 2, raio * 2);
        }

        private static Dimension angulo (Dimension origem, Dimension destino){
            int largura = origem.width == destino.width 
                ? ((origem.height + destino.height) / 2) - origem.width 
                : destino.width;
            int altura = origem.height == destino.height
                ? ((origem.width + destino.width) / 2) - origem.height 
                : origem.height;

            //largura += largura * 0.2;
            //altura += altura * 0.2;

            return new Dimension((int) (largura),(int) (altura));
        }
    }
}