package worldcup;

import java.util.ArrayList;

public class Node {
    public int city;
    public ArrayList<Node> adjNodes;
    private ArrayList<Edge> adjEdges;
    private float tempCost = 0F;

    public Node(int value) {
        this.city = value;
    }

    // update the value of the cost
    public void updateCost(float cost) {
        tempCost += cost;
    }

    // get the value of the cost
    public float getCost() {
        return this.tempCost;
    }

    // reset the cost to zero
    @SuppressWarnings("unused")
    public void resetCost() {
        tempCost = 0F;
    }

    // expand the node and find its children
    public void expandNode(ArrayList<Node> adjNodes, ArrayList<Edge> adjEdges) {
        this.adjNodes = adjNodes;
        this.adjEdges = adjEdges;

    }
}
