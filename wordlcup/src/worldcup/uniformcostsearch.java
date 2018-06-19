package worldcup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class uniformcostsearch {
    private static final int ECATERIMBURGO = 0;
    private static final int SAO_PETERSBURGO = 1;
    private static final int ROSTOV = 2;
    private static final int SAMARA = 3;
    private static final int VOLGOGRADO = 4;
    private static final int SOCHI = 5;
    private static final int KAZAN = 6;
    private static final int SARANSK = 7;
    private static final int KALININGRADO = 8;
    private static final int MOSCOU = 9;
    private static final int NIJNI_NOVGOROD = 10;
    private final int MAX_CITIES = 11;
    private Node ecterimburgo;
    private Node sao_petersburgo;
    private Node rostov;
    private Node samara;
    private Node volgogrado;
    private Node sochi;
    private Node kazan;
    private Node saransk;
    private Node kalingrado;
    private Node moscou;
    private Node nijni_novgorod;

    private float[][] map = new float[MAX_CITIES][MAX_CITIES];
    protected HashMap cities = new HashMap<Integer, Node>();

    protected int ucsNumOfNodesGenerated = 0;
    protected int ucsMaxNumOfNodesInMemory = 0;

    public uniformcostsearch() {
        matriz(this.map);
        createNodes();
        initHashMap();
    }

    private void matriz(float[][] map) {
        // KALINGRADO
        map[KALININGRADO][SOCHI] = 2.713F;
        map[KALININGRADO][SAO_PETERSBURGO] = 1.277F;
        map[KALININGRADO][ROSTOV] = 2.007F;
        map[KALININGRADO][ECATERIMBURGO] = 1.970F;
        // S�O PETERSBURGO
        map[SAO_PETERSBURGO][MOSCOU] = 0.831F;
        map[SAO_PETERSBURGO][KAZAN] = 1.895F;
        map[SAO_PETERSBURGO][KALININGRADO] = 1.277F;
        map[SAO_PETERSBURGO][ECATERIMBURGO] = 1.463F;
        // MOSCOU
        map[MOSCOU][ROSTOV] = 1.323F;
        map[MOSCOU][VOLGOGRADO] = 0.736F;
        map[MOSCOU][NIJNI_NOVGOROD] = 0.152F;
        map[MOSCOU][ECATERIMBURGO] = 1.354F;
        map[MOSCOU][SAO_PETERSBURGO] = 0.831F;
        // SARANSK
        map[SARANSK][VOLGOGRADO] = 0.332F;
        map[SARANSK][NIJNI_NOVGOROD] = 0.056F;
        map[SARANSK][ECATERIMBURGO] = 1.218F;
        // KAZAN
        map[KAZAN][SAMARA] = 0.112F;
        map[KAZAN][NIJNI_NOVGOROD] = 0.124F;
        map[KAZAN][SAO_PETERSBURGO] = 1.895F;
        // ECATERIMBURGO
        map[ECATERIMBURGO][SAMARA] = 0.516F;
        map[ECATERIMBURGO][KALININGRADO] = 1.970F;
        map[ECATERIMBURGO][MOSCOU] = 1.354F;
        map[ECATERIMBURGO][SAO_PETERSBURGO] = 1.463F;
        map[ECATERIMBURGO][KALININGRADO] = 1.970F;
        // SAMARA
        map[SAMARA][VOLGOGRADO] = 0.452F;
        map[SAMARA][SOCHI] = 1.161F;
        map[SAMARA][ECATERIMBURGO] = 0.516F;
        map[SAMARA][KAZAN] = 0.112F;
        // VOLGOGRADO
        map[VOLGOGRADO][ROSTOV] = 0.189F;
        map[VOLGOGRADO][SAMARA] = 0.452F;
        map[VOLGOGRADO][SARANSK] = 0.332F;
        map[VOLGOGRADO][MOSCOU] = 0.736F;
        map[VOLGOGRADO][SOCHI] = 0.565F;
        // ROSTOV
        map[ROSTOV][KALININGRADO] = 2.007F;
        map[ROSTOV][SOCHI] = 0.282F;
        map[ROSTOV][VOLGOGRADO] = 0.189F;
        map[ROSTOV][MOSCOU] = 1.323F;
        // SOCHI
        map[SOCHI][NIJNI_NOVGOROD] = 1.175F;
        map[SOCHI][VOLGOGRADO] = 0.565F;
        map[SOCHI][ROSTOV] = 0.282F;
        map[SOCHI][SAMARA] = 1.161F;
        map[SOCHI][KALININGRADO] = 2.713F;
    }

    private void initHashMap() {
        this.cities.put(ECATERIMBURGO, ecterimburgo);
        this.cities.put(SAO_PETERSBURGO, sao_petersburgo);
        this.cities.put(ROSTOV, rostov);
        this.cities.put(SAMARA, samara);
        this.cities.put(VOLGOGRADO, volgogrado);
        this.cities.put(SOCHI, sochi);
        this.cities.put(KAZAN, kazan);
        this.cities.put(SARANSK, saransk);
        this.cities.put(KALININGRADO, kalingrado);
        this.cities.put(MOSCOU, moscou);
        this.cities.put(NIJNI_NOVGOROD, nijni_novgorod);
    }

    private void createNodes() {
        ecterimburgo = new Node(ECATERIMBURGO);
        sao_petersburgo = new Node(SAO_PETERSBURGO);
        rostov = new Node(ROSTOV);
        samara = new Node(SAMARA);
        volgogrado = new Node(VOLGOGRADO);
        sochi = new Node(SOCHI);
        kazan = new Node(KAZAN);
        saransk = new Node(SARANSK);
        kalingrado = new Node(KALININGRADO);
        moscou = new Node(MOSCOU);
        nijni_novgorod = new Node(NIJNI_NOVGOROD);
    }

    private ArrayList<Edge> findAdjEdges(int n) {
        ArrayList<Edge> adjEdges = new ArrayList<Edge>();
        for (int i = 0; i < MAX_CITIES; i++) {
            if (map[n][i] != 0F) {
                Node child = new Node(i);
                // the edge is at the same index in the list as the corresponding child
                adjEdges.add(new Edge((Node) cities.get(n), child, map[n][i]));
            }
        }
        return adjEdges;
    }

    private ArrayList<Node> findAdjNodes(int n) {
        ArrayList<Node> adjNodes = new ArrayList<Node>();

        for (int i = 0; i < MAX_CITIES; i++) {
            if (map[n][i] != 0F) {
                // the child is at the same index in the list as the corresponding edge
                adjNodes.add((Node) cities.get(i));
            }
        }
        return adjNodes;
    }

    protected void resetParameters() {
        ucsNumOfNodesGenerated = 0;
        ucsMaxNumOfNodesInMemory = 0;
    }

    public ArrayList<Node> ucs(Node src, Node dest) {

        Comparator<Node> comparator = new NodeComparator();
        // a queue to hold the nodes that are to be visited in order
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(MAX_CITIES, comparator);

        frontier.add(src);

        // a list to keep track of the visited nodes
        ArrayList<Node> visited = new ArrayList<Node>();

        while (!frontier.isEmpty()) {
            Node elem = frontier.remove();

            visited.add(elem);

            // if destination has been reached
            if (elem.city == dest.city)
                break;

            elem.expandNode(findAdjNodes(elem.city), findAdjEdges(elem.city));
            ucsMaxNumOfNodesInMemory++;

            ArrayList<Node> childNodes = elem.adjNodes;
            if (!childNodes.isEmpty()) {
                for (int i = 0; i < childNodes.size(); i++) {
                    Node child = childNodes.get(i);
                    if (!visited.contains(child) && !frontier.contains(child)) {
                        child.updateCost(elem.getCost() + map[elem.city][child.city]);
                        System.out.println("Custo do n�: " + child.city + " �: " + child.getCost());
                        frontier.add(child);
                    }
                }
            }
        }
        ucsNumOfNodesGenerated = visited.size();
        return visited;
    }


}
