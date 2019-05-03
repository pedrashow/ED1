package lista5;

public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	
	protected int tamanho;
	
	protected class Elo
	{
		protected int dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(int elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(int elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
		tamanho = 0;
	}
	
	/* Testa se a lista está vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no início da lista. */
	public void insere(int novo)
	{
		Elo p;
		
		p = new Elo(novo);
		
		p.prox = prim;
		
		p.ant = null;
		
		if (prim != null)
			prim.ant = p;
		
		prim = p;
		
		this.tamanho++;
	}
	
	/* Método auxiliar para busca. */
	private Elo busca(int elem)
	{
		Elo p = null;

		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;      
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;
		p = busca(elem);

		if (p == null) return false;

		/* Retira primeiro elemento */
		if (p == prim) 
			prim = prim.prox;
		else 
			/* Retira elemento do meio */
			p.ant.prox = p.prox;

		/* Testa se é ultimo elemento */  
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;
		
		this.tamanho--;

		return true;
	}

	public Elo buscaPorIndice(int indice) {
		Elo buscado = this.prim;
		
		int i = 0;
		
		while (!(buscado == null || i == indice)) {
			buscado = buscado.prox;
			i++;
		}
		
		if (buscado == null)
			throw new IndexOutOfBoundsException("Índice não existe");
		return buscado;
	}

	public void trocaElos(int indiceElo1, int indiceElo2) {
		if (indiceElo1 == indiceElo2)
			return;
		
		int temp;
		
		Elo um = buscaPorIndice(indiceElo1);
		
		Elo dois = buscaPorIndice(indiceElo2);
		
		temp = um.dado;
		um.dado = dois.dado;
		dois.dado = temp;
		
			
	}
	
	public void imprime() {
		Elo p;

		System.out.println("Elementos da lista");

		for (p = prim; p != null; p = p.prox) {
			System.out.print(p.dado + " ");
		}

		System.out.println();
	}
	
	public boolean igual(ListaDuplamente lista) {
		return igual(this.prim, lista.prim);
	}
	
	private boolean igual(Elo x, Elo y) {
		if (x == null && y == null) //quando as duas chegam ao fim
			return true;
		
		if (x != null && y != null) //comparo os dados e chamo os proximos nós
			return (x.dado == y.dado && igual(x.prox, y.prox) );
		
		return false; //se uma lista chegou no fim e a outra nao
	}
	
	
	
	
	
	public static void main(String[] args) {
		ListaDuplamente lista = new ListaDuplamente();
		for (int i = 10; i>=0; i--)
			lista.insere(i);
		lista.imprime();
		lista.trocaElos(0, 1);
		lista.imprime();
	}

}