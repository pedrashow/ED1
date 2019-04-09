package lista2;

import pilha.PilhaGenerica;

public class FilaDuplaUsandoPilha<T> extends FilaUsandoPilha <T> {
	
	public FilaDuplaUsandoPilha (int tamanho) {
		super(tamanho);
	}
	
	public boolean insereInicio (T elemento) {
		if (!this.cheia()) {
			pilhaInsercao.transfereInvertendo(pilhaRemocao);
			pilhaRemocao.push(elemento);
			return true;
		} else {
			System.out.println("Filha cheia, n�o � poss�vel inserir");
			return false;
		}
	}
	
	public T removeFim () {
		T elemento;
		
		if (!this.vazia()) {
			pilhaRemocao.transfereInvertendo(pilhaInsercao);
			elemento = pilhaInsercao.pop();
			return elemento;
		}
		
		System.out.println("Fila vazia, n�o � poss�vel remover");
		
		return null;
	}
	
	
}
