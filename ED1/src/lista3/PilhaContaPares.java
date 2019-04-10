/**
 * 
 */
package lista3;

import pilha.PilhaGenerica;

/**
 * Implemente um método com a melhor complexidade possível, melhor
tempo possível, para conseguir a quantidade de inteiros pares de uma
pilha. Considere que a pilha em questão possui os métodos pop e push
padrões e atributos padrões. Você possui liberdade para criar novos
métodos e/ou atributos e alterar os métodos pop e push já existentes.
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
			// Impressï¿½o para fins didï¿½ticos
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
			// Impressï¿½o para fins didï¿½ticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}
	
	public int numPares() {
		return this.qtdPares;
	}

}
