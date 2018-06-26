public class Data {

	private static final int Kaliningrado = 0;
	private static final int Sao_Petersburgo = 1;
	private static final int Moscou = 2;
	private static final int Saransk = 3;
	private static final int Nijni_Novgorod = 4;
	private static final int Kazan = 5;
	private static final int Ecaterimburgo = 6;
	private static final int Samara = 7;
	private static final int Volgogrado = 8;
	private static final int Rostov = 9;
	private static final int Sochi = 10;

	public Data(Cidade[] cidades, double[][] matriz_adjacente) {
		initCidades(cidades);
		initMatriz(matriz_adjacente);
	}

	public void initCidades(Cidade[] cidades) {
		cidades[0] = new Cidade("Kaliningrado", 0);
		cidades[1] = new Cidade("São Petersburgo", 1);
		cidades[2] = new Cidade("Moscou", 2);
		cidades[3] = new Cidade("Saransk", 3);
		cidades[4] = new Cidade("Nijni Novgorod", 4);
		cidades[5] = new Cidade("Kazan", 5);
		cidades[6] = new Cidade("Ecaterimburgo", 6);
		cidades[7] = new Cidade("Samara", 7);
		cidades[8] = new Cidade("Volgogrado", 8);
		cidades[9] = new Cidade("Rostov", 9);
		cidades[10] = new Cidade("Sochi", 10);
	}

	public void initMatriz(double[][] matriz_adjacente) {
		//kalinigrado
    	insertData(matriz_adjacente, Kaliningrado, Sao_Petersburgo, 0.413754968);
    	insertData(matriz_adjacente, Kaliningrado, Ecaterimburgo, 0.666666667);
    	insertData(matriz_adjacente, Kaliningrado, Rostov, 0.667940849);
    	insertData(matriz_adjacente, Kaliningrado, Sochi , 0.911513138);
    	//São Petersburgo
    	insertData(matriz_adjacente, Sao_Petersburgo, Moscou, 0.262267046);
    	insertData(matriz_adjacente, Sao_Petersburgo, Kazan, 0.625774918);
    	insertData(matriz_adjacente, Sao_Petersburgo, Ecaterimburgo, 0.49021401);
    	insertData(matriz_adjacente, Sao_Petersburgo, Kaliningrado, 0.413754968);
    	//Moscou
    	insertData(matriz_adjacente, Moscou, Nijni_Novgorod, 0.033246423);
    	insertData(matriz_adjacente, Moscou, Ecaterimburgo, 0.448169035);
    	insertData(matriz_adjacente, Moscou, Volgogrado, 0.233483442);
    	insertData(matriz_adjacente, Moscou, Rostov, 0.430545894);
    	insertData(matriz_adjacente, Moscou, Sao_Petersburgo, 0.262267046);
    	//Saransk
    	insertData(matriz_adjacente, Saransk, Nijni_Novgorod, 0); 
    	insertData(matriz_adjacente, Saransk, Ecaterimburgo, 0.398388776);
    	insertData(matriz_adjacente, Saransk, Volgogrado, 0.096128336);
    	//Nijni Novgorod
    	insertData(matriz_adjacente, Nijni_Novgorod, Kazan, 0.023609526);
    	insertData(matriz_adjacente, Nijni_Novgorod, Sochi, 0.389579015);
    	insertData(matriz_adjacente, Nijni_Novgorod, Saransk, 0); 
    	insertData(matriz_adjacente, Nijni_Novgorod, Moscou, 0.033246423);
    	//Kazan
    	insertData(matriz_adjacente, Kazan, Samara,  0.019257331);
    	insertData(matriz_adjacente, Kazan, Nijni_Novgorod, 0.023609526);
    	insertData(matriz_adjacente, Kazan, Sao_Petersburgo, 0.625774918);
    	//Ecaterimburgo
    	insertData(matriz_adjacente, Ecaterimburgo, Samara, 0.159950343);
    	insertData(matriz_adjacente, Ecaterimburgo, Saransk, 0.398388776);
    	insertData(matriz_adjacente, Ecaterimburgo, Moscou, 0.448169035);
    	insertData(matriz_adjacente, Ecaterimburgo, Sao_Petersburgo, 0.49021401);
    	insertData(matriz_adjacente, Ecaterimburgo, Kaliningrado, 0.666666667);
    	//Samara
    	insertData(matriz_adjacente, Samara, Volgogrado, 0.137240397);
    	insertData(matriz_adjacente, Samara, Sochi, 0.384539962);
    	insertData(matriz_adjacente, Samara, Ecaterimburgo, 0.159950343);
    	insertData(matriz_adjacente, Samara, Kazan, 0.019257331);
    	//Volgogrado
    	insertData(matriz_adjacente, Volgogrado, Rostov, 0.046401782);
    	insertData(matriz_adjacente, Volgogrado, Sochi, 0.177114178);
    	insertData(matriz_adjacente, Volgogrado, Samara, 0.137240397);
    	insertData(matriz_adjacente, Volgogrado, Saransk, 0.096128336);
    	insertData(matriz_adjacente, Volgogrado, Moscou,  0.233483442);
    	//Rostov
    	insertData(matriz_adjacente, Rostov, Sochi, 0.078235262);
    	insertData(matriz_adjacente, Rostov, Volgogrado, 0.046401782);
    	insertData(matriz_adjacente, Rostov, Moscou, 0.430545894);
    	insertData(matriz_adjacente, Rostov, Kaliningrado, 0.667940849);
    	//Sochi
    	insertData(matriz_adjacente, Sochi, Rostov, 0.078235262);
    	insertData(matriz_adjacente, Sochi, Samara, 0.384539962);
    	insertData(matriz_adjacente, Sochi, Volgogrado, 0.177114178);
    	insertData(matriz_adjacente, Sochi, Nijni_Novgorod, 0.389579015);
    	insertData(matriz_adjacente, Sochi, Kaliningrado , 0.911513138);   
    }

	public void insertData(double[][] matriz_adjacente, int origem, int destino, double valor) {
		matriz_adjacente[origem][destino] = valor;
		matriz_adjacente[destino][origem] = valor;
	}
}