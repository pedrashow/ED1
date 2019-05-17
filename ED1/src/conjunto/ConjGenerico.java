package conjunto;

public class ConjGenerico<T extends Comparable<T>> {
	private Elo prim; /* Referência para primeiro elemento. */

	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo {
		T dado;
		Elo prox;

		public Elo() {
			prox = null;
		}

		public Elo(T elem) {
			dado = elem;
			prox = null;
		}

		public Elo(T elem, Elo prox_elem) {
			dado = elem;
			prox = prox_elem;
		}
	}

	public ConjGenerico() {
		prim = null;
	}

	/* Função privada para realizar uma cópia de um outro conjunto. */
	private void copia(ConjGenerico<T> cj2) {
		Elo ult = null, q;

		prim = null;
		for (Elo p = cj2.prim; p != null; p = p.prox) {
			q = new Elo(p.dado);
			if (ult == null)
				prim = q;
			else
				ult.prox = q;
			ult = q;
		}
	}

	/* Função privada para realizar uma cópia de um outro conjunto. */
	public void apaga() {
		for (Elo p = prim; p != null; p = prim) {
			prim = prim.prox;
		}
	}

	/* Simula uma sobrecarga do operador de atribuição. */
	public ConjGenerico<T> atribui(ConjGenerico<T> cj2) {
		if (this != cj2) {
			apaga();
			copia(cj2);
		}
		return this;
	}

	/* Testa se o conjunto está vazio. */
	public boolean vazio() {
		return prim == null;
	}

	/* Teste de pertinência. Usa fato de estar ordenado */
	public boolean pertence(T valor) {
		Elo p;

		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox)
			;

		if ((p == null) || (p.dado.compareTo(valor) > 0))
			return false;

		return true;
	}

	/*
	 * Inserção de elemento no conjunto. Usa fato de estar ordenado. Retorna false
	 * se elemento já estava lá.
	 */
	public boolean insere(T valor) {
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox) {
			if (p.dado.compareTo(valor) == 0)
				return false;
			if (p.dado.compareTo(valor) > 0)
				break;
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

	/*
	 * Remoção de elemento do conjunto. Usa fato de estar ordenado. Retorna false se
	 * elemento não estava lá.
	 */
	public boolean remove(T valor) {
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox) {
			if (p.dado.compareTo(valor) > 0)
				return false;
			if (p.dado.compareTo(valor) == 0)
				break;
			ant = p;
		}
		if (p == null)
			return false;
		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;
		return true;
	}

	/*
	 * Método para união de conjuntos. Une conjunto com cj2 e retorna novo conjunto
	 * com a união. Usa fato de conjuntos estarem ordenados e percorre as listas em
	 * paralelo.
	 */
	public ConjGenerico<T> uniao(ConjGenerico<T> cj2) {
		Elo q, p1 = prim, p2 = cj2.prim, ult = null;
		ConjGenerico<T> uniao = new ConjGenerico<T>();

		while ((p1 != null) || (p2 != null)) {
			if ((p1 != null) && ((p2 == null) || (p1.dado.compareTo(p2.dado) < 0))) {
				q = new Elo(p1.dado);
				p1 = p1.prox;
			} else {
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

	/*
	 * Método para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e
	 * retorna novo conjunto com a intersecao. Usa fato de conjuntos estarem
	 * ordenados e percorre as listas em paralelo.
	 */
	public ConjGenerico<T> intersecao(ConjGenerico<T> cj2) {
		Elo q, p1 = prim, p2 = cj2.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<T>();

		while ((p1 != null) && (p2 != null)) {
			if (p1.dado.compareTo(p2.dado) < 0) {
				p1 = p1.prox;
			} else if (p2.dado.compareTo(p1.dado) < 0) {
				p2 = p2.prox;
			} else {
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

		for (p = prim; p != null; p = p.prox)
			tam++;
		return tam;
	}

	public boolean subconjunto(ConjGenerico<T> conj2) {
		Elo corr1 = this.prim, corr2 = conj2.prim;
		boolean diferente = false; // rastreia se há elemento em conj2 que não esta em conj1

		while (corr1 != null) {
			if (corr2 == null || corr1.dado.compareTo(corr2.dado) < 0)
				return false;
			if (corr1.dado.compareTo(corr2.dado) == 0) {
				corr1 = corr1.prox;
				corr2 = corr2.prox;
			} else if ((corr1.dado.compareTo(corr2.dado) > 0)) {
				corr2 = corr2.prox;
				diferente = true;
			}
		}
		return diferente;
	}

	public ConjGenerico<T> diferencaConjunto(ConjGenerico<T> conj2) {
		Elo elemento, corr1 = this.prim, corr2 = conj2.prim, corrDif = null;
		ConjGenerico<T> diferenca = new ConjGenerico<>();
		while (corr1 != null) {
			if (corr2 == null || corr1.dado.compareTo(corr2.dado) < 0) {
				elemento = new Elo(corr1.dado);
				corr1 = corr1.prox;
				if (corrDif == null) {
					diferenca.prim = elemento;
				} else {
					corrDif.prox = elemento;
				}
				corrDif = elemento;
			} else if (corr1.dado.compareTo(corr2.dado) == 0) {
				corr1 = corr1.prox;
				corr2 = corr2.prox;
			} else {
				corr2 = corr2.prox;
			}
		}

		return diferenca;
	}

	public ConjGenerico<T> complementar(ConjGenerico<T> universo) {
		Elo elemento, corr1 = this.prim, corrU = universo.prim, corrComp = null;
		ConjGenerico<T> complemento = new ConjGenerico<>();
		while (corrU != null) {
			if (corr1 == null || corrU.dado.compareTo(corr1.dado) < 0) {
				elemento = new Elo(corrU.dado);
				corrU = corrU.prox;
				if (corrComp == null) {
					complemento.prim = elemento;
				} else {
					corrComp.prox = elemento;
				}
				corrComp = elemento;
			} else if (corr1.dado.compareTo(corrU.dado) == 0) {
				corr1 = corr1.prox;
				corrU = corrU.prox;
			} else {
				throw new UnsupportedOperationException("Conjunto universo não contém um elemento deste conjunto");
			}
		}

		return complemento;
	}

	public boolean igualdadeConjuntos(ConjGenerico<T> conj2) {
		return igual(this.prim, conj2.prim);
	}

	private boolean igual(Elo x, Elo y) {
		if (x == null && y == null) // quando as duas chegam ao fim
			return true;

		if (x != null && y != null) // comparo os dados e chamo os proximos nós
			return (x.dado.compareTo(y.dado) == 0 && igual(x.prox, y.prox));

		return false; // se um conjunto acabou e outro nao chegou no fim e a outra nao
	}

	public static <T extends Comparable<T>> ConjGenerico<T> calculaDeMorgan(ConjGenerico<T> A, ConjGenerico<T> B, ConjGenerico<T> universo) {
	/*
	 * retorna o complemento da uniao entre A e B
	 */
		ConjGenerico<T> compA = A.complementar(universo);
		ConjGenerico<T> compB = B.complementar(universo);
		return compA.intersecao(compB);
	}

	/* Imprime todos os elementos do conjunto */
	public void imprime() {
		Elo p;
		System.out.println("Elementos do conjunto");
		for (p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		ConjGenerico<Integer> teste = new ConjGenerico<>();
		for (int i = 0; i < 11; i += 2)
			teste.insere(i);
		ConjGenerico<Integer> teste2 = new ConjGenerico<>();
		for (int i = 0; i < 15; i += 3)
			teste2.insere(i);
		ConjGenerico<Integer> universal = new ConjGenerico<>();
		for (int i = 0; i < 50; i++)
			universal.insere(i);
		teste.imprime();
		teste2.imprime();
		ConjGenerico<Integer> teste3 = teste.uniao(teste2);
		teste3.imprime();
		ConjGenerico<Integer> teste4 = teste.diferencaConjunto(teste2);
		teste4.imprime();
		ConjGenerico<Integer> teste5 = teste.complementar(teste3);
		teste5.imprime();
		System.out.println(teste.igualdadeConjuntos(teste2));
		System.out.println(teste4.igualdadeConjuntos(teste4));
		universal.imprime();
		ConjGenerico<Integer> teste6 = calculaDeMorgan(teste, teste2, universal);
		teste6.imprime();
		System.out.println(teste.subconjunto(teste2));
		System.out.println(teste.subconjunto(teste3));
		System.out.println(teste.subconjunto(teste));
	}
}