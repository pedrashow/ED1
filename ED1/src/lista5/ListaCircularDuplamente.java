package lista5;

public class ListaCircularDuplamente extends ListaDuplamente {
	/* Imprime todos os elementos da lista invertida */
	public void imprimeInvertido() {
		Elo p;
		System.out.println("Elementos da lista");

		if (prim == null)
			return;

		p = prim.ant;

		do {
			System.out.print(p.dado + " ");
			p = p.ant;

		} while (p != prim.ant);

		System.out.println();
	}

	/*
	 * Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se
	 * removeu.
	 */
	public boolean remove(int elem) {
		Elo p = null;

		if (prim == null)
			return false;

		for (p = prim; ((p.prox != prim) && (p.dado != elem)); p = p.prox)
			;

		/* Achou */
		if (p.dado == elem) {
			/* É o primeiro */
			if (p == prim) {
				/* É o único */
				if (prim == prim.prox) {
					prim = null;
				} else {
					p.ant.prox = p.prox;
					prim = prim.prox;
					p.prox.ant = p.ant;
				}
			} else {
				/* No meio */
				p.ant.prox = p.prox;
				p.prox.ant = p.ant;
			}

			/*
			 * Remove a última referência para o elo a ser removido. Dessa forma, o Garbage
			 * Collector irá liberar essa memória.
			 */
			p = null;
			this.tamanho--;
			return true;
		} else
			return false;
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo) {
		Elo q, ult;
		q = new Elo(novo);

		if (prim != null) {
			ult = prim.ant;
			ult.prox = q;
			q.ant = ult;
			q.prox = prim;
			prim.ant = q;
		} else {
			prim = q;
			prim.prox = q;
			prim.ant = q;
		}
		
		this.tamanho++;
	}

	public void ordena() {
		
		Elo corrente = prim;
		Elo proximo = prim.prox;
		
		if (corrente == null || proximo == prim)
			return;
		
		int temp;
		do {
			do {
				if (corrente.dado > proximo.dado) {
					temp = corrente.dado;
					corrente.dado = proximo.dado;
					proximo.dado = temp;
				}
				proximo = proximo.prox;
			} while (proximo != prim);
			corrente = corrente.prox;
			proximo = corrente.prox;
		} while (corrente.prox != prim);
		
	}

	public void imprime() {
		
		System.out.println("Elementos:");
		if (this.prim == null)
			return;
		Elo corrente = this.prim;
		do {
			System.out.print(corrente.dado + " ");
			corrente = corrente.prox;
		} while (corrente!= this.prim);
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListaCircularDuplamente teste = new ListaCircularDuplamente();
		teste.insere(4);
		/*
		 * teste.insere(2); teste.insere(19); teste.insere(23); teste.insere(7);
		 */
		teste.imprime();
		teste.ordena();
		teste.imprime();
				
	}
}
