package lista4;

/**
 * Para melhorar a complexidade de retornar o tamanho, a sugestão é a lista
 * possuir um atributo tamanho que é incrementado e decrementado conforme os elementos
 * entram e saem da lista. Desta forma a complexidade do metodo tamanho() seria reduzida para O(1)
 * 
 * @author Beto
 *
 */

public class ListaEncadeadaTamanho extends Lista {
	
	protected int tamanho;
	
	public ListaEncadeadaTamanho() {
		super();
		this.tamanho = 0;
	}
	
	@Override
	public int tamanho() {
		return this.tamanho;
	}
	
	@Override
	public void insere(int novo) {
		Elo p = new Elo(novo);
		p.prox = prim;
		this.prim = p;
		this.tamanho++; //incrementa o tamanho da lista
	}
	
	@Override
	public boolean remove(int elem) {
		Elo p;
		Elo ant = null; /* Referência para anterior. */

		for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;

		/* Se p é null, então não encontrou elemento. */
		if (p == null)
			return false;

		if (p == prim)
			prim = prim.prox; /* Remove elemento do início. */
		else
			ant.prox = p.prox; /* Remove elemento do meio. */

		/*
		 * Remove a última referência para o elo a ser removido. Dessa forma, o Garbage
		 * Collector irá liberar essa memória.
		 */
		p = null;
		
		this.tamanho--; //decrementa o tamanho da lista

		return true;
	}
	
	
}
