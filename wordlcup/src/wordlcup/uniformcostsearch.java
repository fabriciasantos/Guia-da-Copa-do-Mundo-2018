package wordlcup;

import java.util.ArrayList;
import java.util.HashMap;

public class uniformcostsearch {
	private final int MAX_CITIES = 11;
	
	private final int ECATERIMBURGO = 0;
	private final int SAO_PETERSBURGO = 1;
	private final int ROSTOV = 2;
	private final int SAMARA = 3;
	private final int VOLGOGRADO = 4;
	private final int SOCHI = 5;
	private final int KAZAN = 6;
	private final int SARANSK = 7;
	private final int KALININGRADO = 8;
	private final int MOSCOU = 9;
	private final int NIJNI_NOVGOROD = 10;
	
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
	
	private Integer[][] map = new Integer[MAX_CITIES][MAX_CITIES];
	private HashMap<Integer, Node> cities = new HashMap<Integer, uniformcostsearch.Node>(); 
	
	private int ucsNumOfNodesGenerated = 0;
	private int ucsMaxNumOfNodesInMemory = 0;
	
	private void matriz(int [][] map) {
		map[KALININGRADO][SOCHI]= 2422;
		map[KALININGRADO][ROSTOV] = 1935;
		map[KALININGRADO][SAO_PETERSBURGO] = 946;
		map[KALININGRADO][ECATERIMBURGO] = 2953;
		map[SAO_PETERSBURGO][MOSCOU] = 687;
		map[SAO_PETERSBURGO][KAZAN] = 1493;
		map[SAO_PETERSBURGO][ECATERIMBURGO] = 2288;
		map[MOSCOU][ROSTOV] = 1094;
		map[MOSCOU][VOLGOGRADO] = 941;
		map[MOSCOU][SAO_PETERSBURGO] = 687;
		map[MOSCOU][NIJNI_NOVGOROD] = 425;
		map[MOSCOU][ECATERIMBURGO] = 1755;
		map[SARANSK][VOLGOGRADO] = 701;
		map[SARANSK][NIJNI_NOVGOROD] = 307;
		map[SARANSK][ECATERIMBURGO] = 1339;
		map[NIJNI_NOVGOROD][SOCHI] = 1857;
		map[NIJNI_NOVGOROD][SARANSK] = 307;
		map[NIJNI_NOVGOROD][MOSCOU] = 425;
		map[NIJNI_NOVGOROD][KAZAN] = 400;
		map[KAZAN][SAMARA] = 363;
		map[KAZAN][SAO_PETERSBURGO] = 1493;
		map[KAZAN][NIJNI_NOVGOROD] = 400;
		map[ECATERIMBURGO][SARANSK] = 1339;
		map[ECATERIMBURGO][SAMARA] = 944;
		map[ECATERIMBURGO][MOSCOU] = 1755;
		map[ECATERIMBURGO][KALININGRADO] = 2953;
		map[ECATERIMBURGO][SAO_PETERSBURGO] = 2288;
		map[SAMARA][VOLGOGRADO] = 814;
		map[SAMARA][SOCHI] = 1817;
		map[SAMARA][ECATERIMBURGO] = 944;
		map[SAMARA][KAZAN] = 363;
		map[VOLGOGRADO][SOCHI] = 1003;
		map[VOLGOGRADO][SAMARA] = 814;
		map[VOLGOGRADO][ROSTOV] = 500;
		map[VOLGOGRADO][MOSCOU] = 941;
		map[VOLGOGRADO][SARANSK] = 701;
		map[ROSTOV][SOCHI] = 570;
		map[ROSTOV][VOLGOGRADO] = 500;
		map[ROSTOV][MOSCOU] = 1094;
		map[ROSTOV][KALININGRADO] = 1935;
		map[SOCHI][NIJNI_NOVGOROD] = 1857;
		map[SOCHI][KALININGRADO] = 2422;
		map[SOCHI][VOLGOGRADO] = 1003;
		map[SOCHI][SAMARA] = 1817;
		map[SOCHI][ROSTOV] = 570;
	}
	
	private class Node{
		private int city;
		private ArrayList<Node> adjNodes;
		private ArrayList<Edge> adjEdges;
		private int tempCost = 0;

		public Node(int value){
			this.city = value;
		}
		
		// update the value of the cost
		public void updateCost(int cost){
			tempCost += cost;
		}
		
		// get the value of the cost
		public int getCost(){
			return this.tempCost;
		}
		
		// reset the cost to zero
		@SuppressWarnings("unused")
		public void resetCost(){
			tempCost = 0;
		}

		// expand the node and find its children
		public void expandNode(ArrayList<Node> adjNodes, 
				ArrayList<Edge> adjEdges){
			this.adjNodes = adjNodes;
			this.adjEdges = adjEdges;

		}
		
		// Print the node: value, children and cost of edges
		@SuppressWarnings("unused")
		public void print(){
			String s = "";
			s = s + ("Node: "+this.city);
			if(adjNodes != null){
				s = s + " --> Children --> ";
				for(int i = 0; i < adjNodes.size(); i++){
					s = s + "Node "+adjNodes.get(i).city + ": ";
					s = s + adjEdges.get(i).cost + ", ";
				}
			}

			System.out.println(s);
		}
	}
	
	private class Edge{
		@SuppressWarnings("unused")
		private Node src;
		@SuppressWarnings("unused")
		private Node dest;
		private int cost;

		public Edge(Node src, Node dest, int cost){
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
	}

}
