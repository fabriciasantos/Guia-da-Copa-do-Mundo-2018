
public class Cidade implements Comparable<Cidade>{
    private Cidade pai;
    private String cidade;
    private boolean wasVisited;
    private boolean isFinal;
    private double custNode;
    private int position;

    public Cidade(String cidade, int position) {
        this.pai = null;
        this.cidade = cidade;
        this.wasVisited = false;
        this.isFinal = false;
        this.custNode = 0.0;
        this.position = position;
    }

    public Cidade(){}

    /**
     * @return the pai
     */
    public Cidade getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(Cidade pai) {
        this.pai = pai;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param wasVisited the wasVisited to set
     */
    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
    
    /**
     * @return the cidade wasVisited
     */
    public boolean wasVisited() {
        return wasVisited;
    }
    
    /**
     * @param isFinal the isFinal to set
     */
    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    /**
     * @return the isFinal
     */
    public boolean isFinal() {
        return isFinal;
    }

    /**
     * @param custNode the custNode to set
     */
    public void setCustNode(double custNode) {
        this.custNode = custNode;
    }
    
    /**
     * @return the custNode
     */
    public double getCustNode() {
        return custNode;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Cidade cidade) {
        if (this.getCustNode() < cidade.getCustNode()) return -1;
        if (this.getCustNode() > cidade.getCustNode()) return 1;
        return 0;
    }
}
