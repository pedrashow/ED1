package conjunto;
public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;  /* Referência para primeiro elemento. */

	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo{                 
		T dado;
		Elo prox;

		public Elo(){ 
			prox = null;
		}

		public Elo(T elem)
		{
			dado = elem;
			prox = null;
		}

		public Elo(T elem, Elo prox_elem){ 
			dado = elem;
			prox = prox_elem;
		}
	}

	public ConjGenerico(){
		prim = null;
	}

	/* Função privada para realizar uma cópia de um outro conjunto. */
	private void copia(ConjGenerico<T> cj2){
		Elo ult = null, q;

		prim = null;
		for (Elo p = cj2.prim; p != null; p = p.prox)
		{
			q = new Elo(p.dado);
			if (ult == null)
				prim = q;
			else
				ult.prox = q;
			ult = q;
		}
	}

	/* Função privada para realizar uma cópia de um outro conjunto. */
	public void apaga(){
		for (Elo p = prim; p != null; p = prim){
			prim = prim.prox;
		}
	}

	/* Simula uma sobrecarga do operador de atribuição. */
	public ConjGenerico<T> atribui(ConjGenerico<T> cj2){
		if (this != cj2)
		{
			apaga();
			copia(cj2);
		}
		return this;
	}

	/* Testa se o conjunto está vazio. */
	public boolean vazio(){
		return prim == null;
	}

	/* Teste de pertinência. Usa fato de estar ordenado */
	public boolean pertence(T valor){
		Elo p;

		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;	  

		return true;
	}

	/* Inserção de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento já estava lá. */
	public boolean insere(T valor){
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox){
			if (p.dado.compareTo(valor) == 0) return false;	  
			if (p.dado.compareTo(valor) > 0) break;
			ant = p;
		}
		Elo q = new Elo(valor);
		if (p == prim) 
			prim = q;
		else
			ant.prox = q;
		q.prox = p;
		return true;
	}

	/* Remoção de elemento do conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento não estava lá. */
	public boolean remove(T valor){
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox){
			if (p.dado.compareTo(valor) > 0) return false;
			if (p.dado.compareTo(valor) == 0) break;	  
			ant = p;
		}
		if (p == null) return false;
		if (p == prim) 
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;
		return true;
	}

	/* Método para união de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a união. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> uniao(ConjGenerico<T> cj2)
	{
		Elo q, p1 = prim, p2 = cj2.prim, ult = null;
		ConjGenerico<T> uniao = new ConjGenerico<T>(); 
		
		while ( (p1 != null) || (p2 != null) )
		{
			if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0)))
			{
				q = new Elo(p1.dado);
				p1 = p1.prox;
			}
			else 
			{
				q = new Elo(p2.dado);
				if ((p1 != null) && (p1.dado == p2.dado))
					p1 = p1.prox;
				p2 = p2.prox;
			} 

			if (ult == null) 
				uniao.prim = q;
			else
				ult.prox = q;

			ult = q;
		}

		return uniao;
	}
	
	/* Método para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> intersecao(ConjGenerico<T> cj2)
	{
		Elo q, p1 = prim, p2 = cj2.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<T>();

		while ( (p1 != null) && (p2 != null) )
		{
			if (p1.dado.compareTo(p2.dado) < 0)
			{
				p1 = p1.prox;
			}
			else if(p2.dado.compareTo(p1.dado) < 0)
			{
				p2 = p2.prox;
			}
			else
			{
				q = new Elo(p1.dado);
				p1 = p1.prox;
				p2 = p2.prox;
				
				if (ult == null) 
					inter.prim = q;
				else
					ult.prox = q;

				ult = q;
			}
		}

		return inter;
	}

	/* Retorna cardinalidade do conjunto */
	public int tamanho() {
		int tam = 0;
		Elo p;

		for(p = prim; p != null; p = p.prox)
			tam++;
		return tam;
	}

	/* Imprime todos os elementos do conjunto */
	public void imprime() {
		Elo p;
		System.out.println("Elementos do conjunto");
		for(p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");
		System.out.println();
	}
}