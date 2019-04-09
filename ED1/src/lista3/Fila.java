/**
 * 
 */
package lista3;

/**
 * @author Beto
 *
 */
public class Fila {
	
	private int[] fila;
	
	//construtor
	
	public Fila (int... x) {
		this.fila = new int[x.length];
		int j = 0;
		for (int i : x) {
			this.fila[j] = i;
			j++;
		}
	}
	
	// funcao sugerida
	
	public int getPosicaoValorBinaria(int x) {
		int inicio = 0;
		int fim = this.fila.length;
		
		while (inicio <= fim) {
			int meio = (inicio + fim)/2;
			if (this.fila[meio] > x)
				fim = meio - 1;
			else if (this.fila[meio] < x)
				inicio = meio + 1;
			else if (this.fila[meio] == x)
				return meio;
		}
		
		return Integer.MIN_VALUE;
	}
	
	// funcao original

	public int getPosicaoValor(int x) {
		for (int i = 0; i <= fila.length - 1; i++) {
			if (fila[i] == x) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		Fila teste = new Fila(4,6,9,11,15,19,22,24);
		System.out.println(teste.getPosicaoValorBinaria(34));
	}
}
