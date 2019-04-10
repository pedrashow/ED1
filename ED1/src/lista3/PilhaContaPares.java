/**
 * 
 */
package lista3;

import pilha.PilhaGenerica;

/**
 * Implemente um m�todo com a melhor complexidade poss�vel, melhor
tempo poss�vel, para conseguir a quantidade de inteiros pares de uma
pilha. Considere que a pilha em quest�o possui os m�todos pop e push
padr�es e atributos padr�es. Voc� possui liberdade para criar novos
m�todos e/ou atributos e alterar os m�todos pop e push j� existentes.
 *
 * @author Beto
 */

public class PilhaContaPares extends PilhaGenerica<Integer> {
	
	private int qtdPares;
	
	public PilhaContaPares(int tamanho) {
		super (tamanho);
		this.qtdPares = 0;
	}
	
	public Integer pop() {
		Integer elemento;

		if (!this.vazia()) {
			elemento = vetor.get(topo--);
			if (elemento % 2 == 0)
				this.qtdPares--;
			return elemento;
		} else {
			// Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop nao funcionou.");
			return null;
		}
	}

	public boolean push(Integer elemento) {
		if (!this.cheia()) {
			vetor.add(++topo, elemento);
			if (elemento % 2 == 0)
				this.qtdPares++;
			return true;
		} else {
			// Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}
	
	public int numPares() {
		return this.qtdPares;
	}

}
