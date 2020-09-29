package tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	static int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
	
	static int transfira(int capacidade, int capturados, ArrayList<Integer> doces, ArrayList<Integer> pesos) {
		if (capturados == 0 || capacidade == 0) {
			return 0;
		}
		if (pesos.get(capturados - 1) > capacidade) 
			return transfira(capacidade, capturados - 1, doces, pesos);
		else
			return max(doces.get(capturados - 1) + transfira(capacidade - pesos.get(capturados - 1), capturados - 1,
					doces, pesos), transfira(capacidade, capturados - 1, doces, pesos));	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int capturados = 0, capacidade = 0, c = 0;
		
		ArrayList<Integer> doces = new ArrayList<Integer>();
        ArrayList<Integer> pesos = new ArrayList<Integer>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;
        
        while ((linha = br.readLine()).length() > 0) {
        	String[] str = linha.split(" ");
        	capturados = Integer.parseInt(str[0]);
    		capacidade = Integer.parseInt(str[1]);
        	
    		String[] d = br.readLine().split(" ");
    		String[] p = br.readLine().split(" ");
    		
    		while(c < capturados) {
    			doces.add(Integer.parseInt(d[c]));
    			pesos.add(Integer.parseInt(p[c]));
    			c += 1;
    		}
    		System.out.println(transfira(capacidade, capturados, doces, pesos));
    		
        }        
        br.close();		 
	}
}
