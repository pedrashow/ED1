package listaEncadeada;
public class ListaOrdenada extends Lista
{
	public void insere(int novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null; /* referência para anterior */
		
		for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
			ant = p;
		
		/* Se p é null ou p.dado != elem, então não encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do início. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a última referência para o elo a ser removido. Dessa forma,
		 * o Garbage Collector irá liberar essa memória. */
		p = null;
		
		return true;
	}
	
	public void merge(ListaOrdenada l2) {
		if (this.prim == null) {
			this.prim = l2.prim;
			return;
		}
		if (l2.prim == null) return;
		
		Elo lista1 = this.prim, lista2 = l2.prim, anterior = null;
		while (!(lista1 == null || lista2 == null)) {
			if (lista2.dado < lista1.dado) {
				Elo insere = new Elo(lista2.dado);
				insere.prox = lista1;
				if (anterior == null) {
					this.prim = insere;
					lista1 = insere;
				} else {
					anterior.prox = insere; //faltou essa <<
					anterior = insere;
				}
				lista2 = lista2.prox;
			} else {
				anterior = lista1;
				lista1 = lista1.prox;
			}
		}
		if (lista1 == null)
			anterior.prox = lista2;
	}
	
	public static void main(String[] args) {
		ListaOrdenada l1 = new ListaOrdenada();
		ListaOrdenada l2 = new ListaOrdenada();
		l1.insere(2);l1.insere(6);l1.insere(10);l1.insere(12);
		l2.insere(0);l2.insere(1);l2.insere(5);l2.insere(8);l2.insere(9);l2.insere(15);
		l1.imprime();
		l2.imprime();
		l1.merge(l2);
		l1.imprime();
		l2.imprime();
		
	}
}