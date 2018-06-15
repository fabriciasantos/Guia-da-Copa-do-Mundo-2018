package wordlcup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class uniformcostsearch {
	private final int MAX_CITIES = 11;

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
	private HashMap<Integer, Node> cities = new HashMap<Integer, uniformcostsearch.Node>();

	private int ucsNumOfNodesGenerated = 0;
	private int ucsMaxNumOfNodesInMemory = 0;

	private void matriz(float[][] map) {
		// KALINGRADO
		map[KALININGRADO][SOCHI] = 2.713F;
		map[KALININGRADO][SAO_PETERSBURGO] = 1.277F;
		map[KALININGRADO][ROSTOV] = 2.007F;
		map[KALININGRADO][ECATERIMBURGO] = 1.970F;
		// SÃO PETERSBURGO
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

	public uniformcostsearch() {
		matriz(this.map);
		createNodes();
		initHashMap();
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
		ArrayList<Edge> adjEdges = new ArrayList<uniformcostsearch.Edge>();
		for (int i = 0; i < MAX_CITIES; i++) {
			if (map[n][i] != 0F) {
				Node child = new Node(i);
				// the edge is at the same index in the list as the corresponding child
				adjEdges.add(new Edge(cities.get(n), child, map[n][i]));
			}
		}
		return adjEdges;
	}

	private ArrayList<Node> findAdjNodes(int n) {
		ArrayList<Node> adjNodes = new ArrayList<uniformcostsearch.Node>();

		for (int i = 0; i < MAX_CITIES; i++) {
			if (map[n][i] != 0F) {
				// the child is at the same index in the list as the corresponding edge
				adjNodes.add(cities.get(i));
			}
		}
		return adjNodes;
	}

	private void resetParameters() {
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
						System.out.println("Custo do nó: " + child.city + " é: " + child.getCost());
						frontier.add(child);
					}
				}
			}
		}
		ucsNumOfNodesGenerated = visited.size();
		return visited;
	}

	private class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node x, Node y) {
			if (x.getCost() < y.getCost()) {
				return -1;
			}
			if (x.getCost() > y.getCost()) {
				return 1;
			}
			return 0;
		}
	}

	private class Node {
		private int city;
		private ArrayList<Node> adjNodes;
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

		// Print the node: value, children and cost of edges
		@SuppressWarnings("unused")
		public void print() {
			String s = "";
			s = s + ("Node: " + this.city);
			if (adjNodes != null) {
				s = s + " --> Children --> ";
				for (int i = 0; i < adjNodes.size(); i++) {
					s = s + "Node " + adjNodes.get(i).city + ": ";
					s = s + adjEdges.get(i).cost + ", ";
				}
			}

			System.out.println(s);
		}
	}

	private class Edge {
		@SuppressWarnings("unused")
		private Node src;
		@SuppressWarnings("unused")
		private Node dest;
		private float cost;

		public Edge(Node src, Node dest, float cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		uniformcostsearch us = new uniformcostsearch();
		Node src = us.cities.get(0);
		Node dest = us.cities.get(3);
		ArrayList<Node> ucsPath = us.ucs(src, dest);
		System.out.println("The number of nodes generated is: " + us.ucsNumOfNodesGenerated);
		System.out.println("The maximum number of nodes that existed in memory is: " + us.ucsMaxNumOfNodesInMemory);
		System.out.print("The path from source to destination is: ");
		for (int i = 0; i < ucsPath.size(); i++) {
			switch (ucsPath.get(i).city) {
			case ECATERIMBURGO:
				System.out.print("ECATERIMBURGO ");
				break;
			case SAO_PETERSBURGO:
				System.out.print("SAO_PETERSBURGO ");
				break;
			case ROSTOV:
				System.out.print("ROSTOV ");
				break;
			case SAMARA:
				System.out.print("SAMARA ");
				break;
			case VOLGOGRADO:
				System.out.print("VOLGOGRADO ");
				break;
			case SOCHI:
				System.out.print("SOCHI ");
				break;
			case KAZAN:
				System.out.print("KAZAN ");
				break;
			case SARANSK:
				System.out.print("SARANSK ");
				break;
			case KALININGRADO:
				System.out.print("KALININGRADO ");
				break;
			case MOSCOU:
				System.out.print("MOSCOU ");
				break;
			case NIJNI_NOVGOROD:
				System.out.print("NIJNI_NOVGOROD ");
				break;
			}
			us.resetParameters();
		}

	}
}
