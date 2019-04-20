package lista4;

/**
 * Implanta��o de lista Generica para usar nos exercicios 2 e 4 da lista
 * @author Beto
 *
 */

public class ListaGenerica<T> {
	
	protected Elo primeiro;
	
	protected int tamanho;
	
	protected class Elo {
		
		protected T dado;
		protected Elo proximo;
		
		public Elo() {
			this.proximo = null;
		}
		
		public Elo(T elemento) {
			this.dado = elemento;
			this.proximo = null;
		}
		
		public Elo(T elemento, Elo proxElemento) {
			this.dado = elemento;
			this.proximo = proxElemento;
		}
	}
	
	public ListaGenerica() {
		this.primeiro = null;
	}
	
	public boolean vazia() {
		return (primeiro == null);
	}
	
	public void insere(T elemento) {
		Elo novo = new Elo(elemento);
		novo.proximo = this.primeiro;
		this.primeiro = novo;
		this.tamanho++;
	}
	
	public boolean busca(T elemento) {
		if (this.vazia())
			return false;
		
		return busca(elemento, this.primeiro);
	}
	
	private boolean busca(T elemento, Elo e) {
		if (e == null)
			return false;
		
		if (e.dado.equals(elemento))
			return true;
		
		return busca(elemento, e.proximo);
	}
	
	
	public boolean remove(T elemento) {
		if (this.vazia())
			return false;
		
		Elo corrente = this.primeiro;
		Elo anterior = null;
		
		while (!(corrente == null || corrente.dado.equals(elemento))) {
			anterior = corrente;
			corrente = corrente.proximo;
		}
		
		if (corrente == null) //nao encontrou o elemento
			return false;
		
		if (corrente == primeiro) { //se o elemento a excluir � o primeiro, aponto o primeiro para o segundo.
			this.primeiro = primeiro.proximo;
		} else { //se o elemento est� no meio, aponto o anterior para onde o corrente est� apontando
			anterior.proximo = corrente.proximo; 
		}
		this.tamanho--;
		
		return true;
	}
	
	public void imprimeLista() {
		if (this.vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		imprimeLista(this.primeiro);
		System.out.println();
	}
	
	private void imprimeLista(Elo corrente) {
		if (corrente == null)
			return;
		System.out.print(corrente.dado.toString() + " ");
		imprimeLista(corrente.proximo);
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
}
