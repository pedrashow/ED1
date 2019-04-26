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

	public void insere(int novo) {
		super.insere(novo);
		this.tamanho++;
	}
	
	@Override
	public boolean remove(int elem) {
		boolean retorno = super.remove(elem);
		if (retorno)
			this.tamanho--; //decrementa o tamanho da lista
		return retorno;
	}
	
	
}
