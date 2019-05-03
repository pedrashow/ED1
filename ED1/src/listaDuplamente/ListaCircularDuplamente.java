package listaDuplamente;

public class ListaCircularDuplamente extends ListaDuplamente
{
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		System.out.println("Elementos da lista:");
		
		if(prim == null)
			return;
		
		p = prim;

		do
		{
			System.out.print(p.dado + " ");
			p = p.prox;

		} while (p != prim);
		
		System.out.println();
	}
	
	/* Imprime todos os elementos da lista em ordem reversa. */
	public void imprimeReversa()
	{
		Elo p;
		System.out.println("Elementos da lista em ordem reversa:");
		
		if(prim == null)
			return;
		
		p = prim.ant;

		do
		{
			System.out.print(p.dado + ' ');
			p = p.ant;

		} while (p != prim.ant);
		
		System.out.println();
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;

		if (prim == null) return false;

		for (p = prim; ((p.prox != prim ) && (p.dado!=elem)); p = p.prox);

		/* Achou */
		if (p.dado == elem )
		{
			/* É o primeiro */     
			if (p == prim)
			{
				/* É o único */
				if (prim == prim.prox)
				{
					prim = null;  
				}
				else 
				{
					p.ant.prox = p.prox; 
					prim = prim.prox; 
					p.prox.ant = p.ant;
				}     
			}   
			else
			{
				/* No meio */
				p.ant.prox = p.prox;
				p.prox.ant = p.ant;
			}

			/* Remove a última referência para o elo a ser removido. Dessa forma,
			 * o Garbage Collector irá liberar essa memória. */
			p = null;
			return true;
		} 
		else
			return false; 
	}
	
	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo q, ult;  
		q = new Elo(novo);
		
		if (prim != null)
		{
			ult = prim.ant;
			ult.prox = q;
			q.ant = ult;
			q.prox = prim;
			prim.ant = q;
		}
		else
		{
			prim = q;
			prim.prox = q;
			prim.ant  = q;
		}
	}
	
	public void ordena() {
		
	}
}
