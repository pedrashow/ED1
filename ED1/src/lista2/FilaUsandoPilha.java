package lista2;

import pilha.PilhaGenerica;

/**
 * questao 2 da lista
 * 
 * @author beto
 */

public class FilaUsandoPilha<T> {
	
	protected PilhaGenerica<T> pilhaInsercao; //topo � o �ltimo da fila, usa para inserir
	protected PilhaGenerica<T> pilhaRemocao; // topo � o primeiro da fila, usa para remover

	
	FilaUsandoPilha(int tamanho) {
		pilhaInsercao = new PilhaGenerica<>(tamanho);
		pilhaRemocao = new PilhaGenerica<>(tamanho);
	}
	
	public boolean cheia() {
		return (pilhaInsercao.cheia() || pilhaRemocao.cheia());
	}
	
	public boolean vazia() {
		return (pilhaInsercao.vazia() && pilhaRemocao.vazia());
	}
	
	public T remove() {
		
		T elemento;
		
		if (!this.vazia()) {
			pilhaInsercao.transfereInvertendo(pilhaRemocao);
			elemento = pilhaRemocao.pop();
			return elemento;
		}
		
		System.out.println("Fila vazia, n�o � poss�vel remover");
		
		return null;
			
	}
	
	public void insere (T elemento) {
		
		if (!this.cheia()) {
			pilhaRemocao.transfereInvertendo(pilhaInsercao);
			pilhaInsercao.push(elemento);
		} else {
			System.out.println("Filha cheia, n�o � poss�vel inserir");
		}
	}
	
}
