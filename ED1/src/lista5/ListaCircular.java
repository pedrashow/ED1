package lista5;

public class ListaCircular extends Lista {
	
	public ListaCircular() {
		super();
	}
	
	public ListaCircular(Lista l) {
		super();
		Elo eloListaL = l.prim;
		while (!(eloListaL == null)) {
			this.insere(eloListaL.dado);
			eloListaL = eloListaL.prox;
		}	
	}
	
	public Elo inverteLista() {
		if (this.prim == null) {
			System.out.println("Lista vazia, não é possível inverter");
			return null;
		}
		
		return this.inverteLista(this.prim);
	}
	
	public Elo inverteLista(Elo e) {
		if (e.prox != prim) {
			inverteLista(e.prox);
			this.remove(e.dado);
			this.insere(e.dado);
		}
		return e;
	}

	
	/* Imprime todos os elementos da lista */
	public void imprime() {
		Elo p;
		System.out.println("Elementos da lista");

		p = prim;

		if (p != null) {
			do {
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}

		System.out.println();
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo) {
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null) {
			/* Percorre até alcancar o início. */
			while (p.prox != prim) {
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		} else {
			prim = q;
			prim.prox = q;
		}
	}

	public boolean remove(int elem) {
		Elo p = null;
		Elo ant = null;

		if (prim == null)
			return false;

		for (p = prim; ((p.prox != prim) && (p.dado != elem)); p = p.prox)
			ant = p;

		/* Achou */
		if (p.dado == elem) {
			/* É o primeiro */
			if (p == prim) {
				/* É o único */
				if (prim == prim.prox) {
					prim = null;
				} else {
					/* Guarda o anterior ao primeiro */
					for (ant = prim; (ant.prox != prim); ant = ant.prox)
						;

					ant.prox = prim.prox;
					prim = prim.prox;
				}
			} else {
				/* No meio */
				ant.prox = p.prox;
			}

			/*
			 * Remove a última referência para o elo a ser removido. Dessa forma, o Garbage
			 * Collector irá liberar essa memória.
			 */
			p = null;

			return true;
		} else
			return false;
	}

	public void mergeListaCircular(ListaCircular lista1, ListaCircular lista2) {
		Elo l1 = lista1.prim;
		Elo l2 = lista2.prim;
		boolean fimLista1 = false, fimLista2 = false;
		if (l1 == null)
			fimLista1 = true;
		if (l2 == null)
			fimLista2 = true;
		do {
			if (!fimLista1) {
				this.insere(l1.dado);
				l1 = l1.prox;
			}
			if (!fimLista2) {
				this.insere(l2.dado);
				l2 = l2.prox;
			}
			if (l1 == lista1.prim)
				fimLista1 = true;
			if (l2 == lista2.prim)
				fimLista2 = true;
			
		} while (!(fimLista1 && fimLista2));
		

	}
	
	public static void main(String[] args) {
		Lista teste = new Lista();
		for (int i = 10; i>0; i -= 2)
			teste.insere(i);
		ListaCircular testeCircular = new ListaCircular(teste);
		ListaCircular teste2 = new ListaCircular();
		for (int i = 1; i<13; i+=2)
			teste2.insere(i);
		testeCircular.imprime();
		testeCircular.inverteLista();
		testeCircular.imprime();
		teste2.imprime();
		ListaCircular concatenada = new ListaCircular();
		concatenada.mergeListaCircular(testeCircular, teste2);
		concatenada.imprime();
	}


}