package tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
	
	static int transfira(int capacidade, int capturados, int [] doces, int [] pesos) {
		int[][] qtd_doces = new int[capturados + 1][capacidade + 1];
		
		for (int i = 0; i <= capturados; i++) { 
            for (int j = 0; j <= capacidade; j++) { 
                if (i == 0 || j == 0) 
                    qtd_doces[i][j] = 0; 
                else if (pesos[i - 1] <= j) 
                    qtd_doces[i][j] = max(doces[i - 1] + qtd_doces[i - 1][j - pesos[i - 1]], qtd_doces[i - 1][j]); 
                else
                    qtd_doces[i][j] = qtd_doces[i - 1][j]; 
            } 
        } 
		
		return qtd_doces[capturados][capacidade];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int capturados = 0, capacidade = 0, c = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;
        
        while ((linha = br.readLine()) != null) {
        	String[] str = linha.split(" ");
        	capturados = Integer.parseInt(str[0]);
    		capacidade = Integer.parseInt(str[1]);
        	
    		int[] doces = new int[capturados];
    		int[] pesos = new int[capturados];
    		
    		String[] d = br.readLine().split(" ");
    		String[] p = br.readLine().split(" ");
    		
    		c = 0;
    		while(c < capturados) {
    			doces[c] = Integer.parseInt(d[c]);
    			pesos[c] = Integer.parseInt(p[c]);
    			c += 1;
    		}
    		
    		System.out.println(transfira(capacidade, capturados, doces, pesos));    		
        }        
        br.close();		 
	}
}
