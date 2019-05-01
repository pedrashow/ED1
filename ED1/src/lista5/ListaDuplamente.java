package lista5;

public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	
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
		if (indiceElo1 > indiceElo2) { //garantir que o elo 1 é o menor
			trocaElos(indiceElo2,indiceElo1);
			return;
		}
		Elo elo1 = buscaPorIndice(indiceElo1);
		Elo elo2 = buscaPorIndice(indiceElo2);
		Elo ant1 = elo1.ant;
		Elo ant2 = elo2.ant;
		Elo post1 = elo1.prox;
		Elo post2 = elo2.prox;
		
		if (ant1 != null)
			ant1.prox = elo2;
		else
			prim = elo2;
		post1.ant = elo2;
		elo2.ant = ant1;
		elo2.prox = post1;
		
		ant2.prox = elo1;
		if (post2 != null) 
			post2.ant = elo1;
		elo1.ant = ant2;
		elo1.prox = post2;
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
		lista.trocaElos(5, 0);
		lista.imprime();
	}

}