package ArvoreBinaria;

public class Arvbin<T extends Comparable<T>> {
	private T val; /* Valor armazenado na raiz. */

	/* Referências para sub-árvores. */
	private Arvbin<T> esq, dir;

	/*
	 * Construtor de árvore sem sub-ávores (dir = esq = null). É fornecido apenas o
	 * valor da raiz.
	 */
	public Arvbin(T valor) {
		val = valor;
		esq = null;
		dir = null;
	}

	/*
	 * Construtor de árvore com sub-ávores. São fornecidos o valor da raiz e as
	 * sub-árvores, que devem ter sido construídas previamente.
	 */
	public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir) {
		val = valor;
		esq = arvEsq;
		dir = arvDir;
	}

	/* Retorna o valor armazenado na raiz. */
	public T retornaVal() {
		return val;
	}

	/*
	 * Retorna a sub-árvore esquerda (ou null se não houver).
	 */
	public Arvbin<T> retornaEsq() {
		return esq;
	}

	/*
	 * Retorna a sub-árvore direita (ou null se não houver).
	 */
	public Arvbin<T> retornaDir() {
		return dir;
	}

	/* Modifica o valor armazenado na raiz. */
	public void defineVal(T valor) {
		val = valor;
	}

	/* Redefine a sub-árvore esquerda, apagando a antiga se houver. */
	public void defineEsq(Arvbin<T> filho) {
		esq = filho;
	}

	/* Redefine a sub-árvore direita, apagando a antiga se houver. */
	public void defineDir(Arvbin<T> filho) {
		dir = filho;
	}

	/* Imprime o conteúdo da árvore em pré-ordem */
	public void mostra() {
		System.out.print("(" + val);
		if (esq != null)
			esq.mostra();
		if (dir != null)
			dir.mostra();
		System.out.print(")");
	}

	/* Calcula e retorna o número de nós na árvore. */
	public int contaNos() {
		if ((esq == null) && (dir == null))
			return 1;

		int nosEsq = 0, nosDir = 0;

		if (esq != null)
			nosEsq = esq.contaNos();

		if (dir != null)
			nosDir = dir.contaNos();

		return 1 + nosEsq + nosDir;
	}

	/* Calcula e retorna a altura da árvore. */
	public int calculaAltura() {
		if ((esq == null) && (dir == null))
			return 0;

		int altEsq = 0, altDir = 0;

		if (esq != null)
			altEsq = esq.calculaAltura();

		if (dir != null)
			altDir = dir.calculaAltura();

		return 1 + Math.max(altEsq, altDir);
	}

	/* Calcula e retorna o maior valor contido na árvore. */
	public T calculaMaximo() {
		if ((esq == null) && (dir == null))
			return val;

		T maiorFilhos, maiorEsq, maiorDir;

		if ((esq != null) && (dir == null)) {
			maiorFilhos = esq.calculaMaximo();
		} else if ((esq == null) && (dir != null)) {
			maiorFilhos = dir.calculaMaximo();
		} else {
			maiorEsq = esq.calculaMaximo();
			maiorDir = dir.calculaMaximo();

			if (maiorEsq.compareTo(maiorDir) > 0)
				maiorFilhos = maiorEsq;
			else
				maiorFilhos = maiorDir;
		}

		if (maiorFilhos.compareTo(val) > 0)
			return maiorFilhos;

		return val;
	}

	/* Calcua a soma dos valores dos nós de uma árvore de inteiros. */
	public static int calculaSoma(Arvbin<Integer> no) {
		if (no == null)
			return 0;

		int acumulado = 0;

		acumulado += calculaSoma(no.esq);

		acumulado += calculaSoma(no.dir);

		acumulado += no.val;

		return acumulado;
	}

	/*
	 * Calcula e retorna o diâmetro da árvore, isto é, o número de nós contido no
	 * maior caminho de um nó para outro nó da árvore.
	 */
	public int calculaDiametro() {
		/* Caso base, quando é uma folha. */
		if ((esq == null) && (dir == null)) {
			return 1;
		}

		/* Calcula a altura das sub-árvores esquerda e direita do nó. */
		int alturaEsq = 0, alturaDir = 0;

		if (esq != null)
			alturaEsq = esq.calculaAltura();

		if (dir != null)
			alturaDir = dir.calculaAltura();

		int maxDistanciaNo = alturaEsq + alturaDir + 1;

		/*
		 * Nesse ponto, temos a maior distância entre dois nós da árvore que passa pelo
		 * nó corrente (this). Agora devemos calcular esse valor para as sub-árvores
		 * esquerda e direita, comparando depois.
		 */

		int maxDistanciaEsq = 0, maxDistanciaDir = 0;

		if (esq != null)
			maxDistanciaEsq = esq.calculaDiametro();

		if (dir != null)
			maxDistanciaDir = dir.calculaDiametro();

		int maxDistanciaFilhos = Math.max(maxDistanciaEsq, maxDistanciaDir);

		if (maxDistanciaNo > maxDistanciaFilhos)
			return maxDistanciaNo;
		else
			return maxDistanciaFilhos;
	}

	/*
	 * Verifica se um valor está na árvore. Se estiver, retorna um ponteiro para o o
	 * nó que tem esse valor. Caso contrário, retorna null.
	 */
	public Arvbin<T> busca(T valor) {
		Arvbin<T> ret;

		/* Se é igual ao valor armazenado, não precisa procurar mais. O nó é a raiz. */
		if (valor.compareTo(val) == 0) {
			return this;
		}

		/* Senão, começa procurando na sub-árvore esquerda. */
		if (esq != null) {
			ret = esq.busca(valor);
			if (ret != null)
				return ret;
		}

		/*
		 * Se chega a esse ponto, estará na árvore se, e somente se, estiver na
		 * sub-árvore direita
		 */
		if (dir != null)
			return dir.busca(valor);
		return null;
	}

	public void delete(T valor) {
		
		
		//se chegar em uma folha e não achar o valor, retorno
		
		if (esq == null && dir == null && val.compareTo(valor) != 0)
			return;
		
		
		//se o nó do valor for uma folha eu apago a referencia a ela
		
		if (esq != null && esq.val.compareTo(valor) == 0 && esq.esq == null && esq.dir == null) {
			esq = null;
			return;
		}
			
		if (dir != null && dir.val.compareTo(valor) == 0 && dir.esq == null && dir.dir == null) {
			dir = null;
			return;
		}
		
		//se o nó do valor tiver apenas um filho, seu pai apontará para seu filho
		
		if (esq != null && esq.esq != null && esq.dir == null && esq.val.compareTo(valor) == 0) {
			esq = esq.esq;
			return;
		}
		
		if (esq != null && esq.esq == null && esq.dir != null && esq.val.compareTo(valor) == 0) {
			esq = esq.dir;
			return;
		}
		
		if (dir != null && dir.esq != null && dir.dir == null && dir.val.compareTo(valor) == 0) {
			dir = dir.esq;
			return;
		}
		
		if (dir != null && dir.esq == null && dir.dir != null && dir.val.compareTo(valor) == 0) {
			dir = dir.dir;
			return;
		}
		
		//se o nó tiver dois filhos, troco o valor com um filho até que se chegue em um caso base
		
		if (val.compareTo(valor) == 0 && dir != null && esq != null) {
			T aux = val;
			val = dir.val;
			dir.val = aux;
			dir.delete(valor);
		}
		
		// caso recursivo para esquerda se o valor é diferente
		
		if (val.compareTo(valor) != 0 && esq != null)
			esq.delete(valor);
		
		// caso recursivo para a direita se o valor é diferente
		
		if (val.compareTo(valor) != 0 && dir != null)
			dir.delete(valor);
	}

	public void imprimePreOrdem() {
		System.out.print(val + " ");
		if (esq != null)
			esq.imprimePreOrdem();
		if (dir != null)
			dir.imprimePreOrdem();
	}

	public void imprimePosOrdem() {
		if (esq != null)
			esq.imprimePosOrdem();
		if (dir != null)
			dir.imprimePosOrdem();
		System.out.print(val + " ");
	}

	public void imprimeEmOrdem() {
		if (esq != null)
			esq.imprimeEmOrdem();
		System.out.print(val + " ");
		if (dir != null)
			dir.imprimeEmOrdem();
	}

	public Arvbin<T> criaNovaArvore(T valor) {
		return busca(valor);
	}
	
	public void tornaRaiz(T valor) {
		
		for (int i = 0; i < this.calculaAltura(); i++) {
			
			
			if (esq != null && esq.val.compareTo(valor) == 0) {
				T aux = esq.val;
				esq.val = val;
				val = aux;
				return;
			} else if (esq != null) {
				esq.tornaRaiz(valor);
			}
			
			if (dir != null && dir.val.compareTo(valor) == 0) {
				T aux = dir.val;
				dir.val = val;
				val = aux;
				return;
			} else if (dir != null) {
				dir.tornaRaiz(valor);
			}
		}
	}
	
	public int contaNosIntervalo(T min, T max) {
		
		if (esq == null && dir == null) {
			if (val.compareTo(min) >= 0 && val.compareTo(max) <= 0)
				return 1;
			return 0;
		}
		
		int numNosEsq =0, numNosDir = 0;
		
		if (esq != null)
			numNosEsq = esq.contaNosIntervalo(min, max);

		if (dir != null)
			numNosDir = dir.contaNosIntervalo(min, max);
		
		if (val.compareTo(min) >= 0 && val.compareTo(max) <= 0)
			return 1 + numNosEsq + numNosDir;
		
		return numNosEsq + numNosDir;

	}
	
	public boolean eIgual(Arvbin<T> outra) {
		
		if (esq == null && dir == null && outra.esq == null && outra.dir == null)
			return (val.compareTo(outra.val) == 0); 
		
		boolean testeEsq = false, testeDir = false;
		
		if (esq == null && outra.esq == null && dir != null && outra.dir != null)
			testeEsq = dir.eIgual(outra.dir);
		
		if (dir == null && outra.dir == null && esq != null && outra.esq != null)
			testeDir = esq.eIgual(outra.esq);
		
		return (val.compareTo(outra.val) == 0 && testeEsq && testeDir);
	}
	
	public static boolean arvoreSoma(Arvbin<Integer> arvore) {
		
		if (arvore.esq == null && arvore.dir == null)
			return true;
				
		boolean testeEsq = false, testeDir = false;
		
		if (arvore.esq != null && arvore.dir == null)
			testeEsq = arvore.val == soma(arvore.esq) && arvoreSoma(arvore.esq);
		
		if (arvore.dir != null && arvore.esq == null)
			testeDir = arvore.val == soma(arvore.dir) && arvoreSoma(arvore.dir);
		
		return arvore.val == soma(arvore.dir) + soma(arvore.esq) && testeEsq && testeDir;
		
	}
	
	public static int soma(Arvbin<Integer> arv) {
		int somaDir = 0, somaEsq = 0;
		if (arv.esq == null && arv.dir == null)
			return arv.val;
		
		if (arv.dir != null)
			somaDir = soma(arv.dir);
		
		if (arv.esq != null)
			somaEsq = soma(arv.esq);
		
		return arv.val + somaDir + somaEsq;
	}
}