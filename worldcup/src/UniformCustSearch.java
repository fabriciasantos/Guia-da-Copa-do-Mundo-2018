import java.util.PriorityQueue;

/**
 * UniformCustSearch
 */
public class UniformCustSearch extends Cidade implements Comparable<Cidade>{

    protected static double[][] matriz_adjacente = new double[11][11];
    protected static Cidade[] cidades = new Cidade[11];

    public UniformCustSearch() {
        new Data(cidades, matriz_adjacente);
    }

    public Cidade uniformCustSearch(int origem, int destino) {

        PriorityQueue<Cidade> fila = new PriorityQueue<Cidade>();
        cidades[destino].setIsFinal(true);
        cidades[origem] .setWasVisited(true);
        fila.add(cidades[origem]);

        while (!fila.isEmpty()) {

            Cidade cidadePai = fila.remove();

            if (cidadePai.isFinal() == cidades[destino].isFinal())
                return cidadePai;

            for (int cidadeAtual = 0; cidadeAtual < matriz_adjacente.length; cidadeAtual++) {
                if ((matriz_adjacente[cidadePai.getPosition()][cidadeAtual] != 0) && (cidades[cidadeAtual].wasVisited() == false)) {
                    cidades[cidadeAtual].setCustNode(cidadePai.getCustNode() + matriz_adjacente[cidadePai.getPosition()][cidadeAtual]);
                    cidades[cidadeAtual].setPai(cidades[cidadePai.getPosition()]);
                    cidades[cidadeAtual].setWasVisited(true);
                    fila.add(cidades[cidadeAtual]);
                }
            }
        }
        return null;
    }
}