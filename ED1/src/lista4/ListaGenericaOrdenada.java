package lista4;

/**
 * Questao 4
 * 
 * @author Beto
 *
 * O tipo T precisa ser comparável, caso contrário não é possível ordena-lo
 */

public class ListaGenericaOrdenada<T extends Comparable<T>> extends ListaGenerica<T> {
	
	public ListaGenericaOrdenada() {
		super();
	}
	
	public ListaGenericaOrdenada(ListaGenerica<T> l) {
		super();
		Elo corrente = l.primeiro;
		while (!(corrente == null)) {
			this.insere(corrente.dado);
			corrente = corrente.proximo;
		}
	}
	
	@Override
	public void insere(T elemento) {
		Elo corrente = this.primeiro;
		Elo anterior = null;
		
		Elo novo = new Elo(elemento);
		
		while (!(corrente == null || corrente.dado.compareTo(elemento)>-1)) {
			anterior = corrente;
			corrente = corrente.proximo;
		}
		
		if (anterior == null)
			this.primeiro = novo;
		else
			anterior.proximo = novo;
		
		novo.proximo = corrente;
		
		this.tamanho++;
	}
	
}
