package conjunto;

/**
 * 
 * Classe para representar conjunto de inteiros usando um vetor caracteristico
 * Cada indice armazena um booleano que informa se este numero(indice) pertence ao conjunto
 * 
 * @author Beto
 *
 */

public class ConjInteirosCaract {
	
	private boolean[] vetor;
	private int qtdElementos;
	private int menor;
	private int maior;
	
	ConjInteirosCaract() {
		int TAMANHO = 100; //alterar para o tamanho desejado
		vetor = new boolean[TAMANHO];
		qtdElementos = 0;
		menor = Integer.MAX_VALUE;
		maior = Integer.MIN_VALUE;
	}
	
	ConjInteirosCaract(int... numeros) { //inclui no conjunto todos os elementos passados por parametro
		this();
		for (int y:numeros) {
			this.adicionarElemento(y);
		}
	}
	
	public void adicionarElemento(int x) {
		if (x<0 || x>this.vetor.length)
			throw new IllegalArgumentException("Elemento fora do escopo");
		this.vetor[x] = true;
		this.qtdElementos++;
		if (x< menor)
			menor = x;
		if (x > maior)
			maior = x;
	}
	
	public void removerElemento(int x) {
		if (x<0 || x>this.vetor.length)
			throw new IllegalArgumentException("Elemento fora do escopo");
		this.vetor[x] = false;
		this.qtdElementos--;
	}
	
	public boolean pertence(int x) {
		return this.vetor[x];
	}
	
	public int cardinalidade() {
		return this.qtdElementos;
	}
	
	public boolean vazio() {
		return this.qtdElementos == 0;
	}
	
	public boolean universo() {
		return this.qtdElementos == this.vetor.length;
	}
	
	public void tornarVazio() {
		for (int i = 0; i < this.vetor.length; i-- ) {
			this.vetor[i] = false;
		}
	}
	
	public int maiorELemento() {
		/*
		 * if (this.vazio()) return Integer.MIN_VALUE; boolean x = false; int i =
		 * this.vetor.length; while (!x) { i--; x = this.vetor[i]; } return i;
		 */
		return this.maior;
	}
	
	public int menorELemento() {
		/*
		 * if (this.vazio()) return Integer.MAX_VALUE; boolean x = false; int i = -1;
		 * while (!x) { i++; x = this.vetor[i]; } return i;
		 */
		return this.menor;
	}
	
	public boolean ehSubconjunto(ConjInteirosCaract c) {
		if (this.vetor.length != c.vetor.length) {
			System.err.println("Conjuntos com especificacoes diferentes");
			return false;
		}
		for (int i = 0; i < this.vetor.length; i++) {			
			if (!c.vetor[i] && this.vetor[i])
				return false;
		}
		return true;
	}
	
	public boolean ehSubconjuntoProprio(ConjInteirosCaract c) {
		return (this.ehSubconjunto(c) && this.cardinalidade() != c.cardinalidade() );
	}
	
	public static ConjInteirosCaract uniao (ConjInteirosCaract a, ConjInteirosCaract b) {
		if (a.vetor.length != b.vetor.length)
			throw new IllegalArgumentException("Conjuntos com tamanhos diferentes");
		ConjInteirosCaract c = new ConjInteirosCaract();
		for (int i = 0; i < c.vetor.length; i++) {
			if (a.vetor[i] || b.vetor[i])
				c.adicionarElemento(i);;
		}
		return c;
	}
	
	public static ConjInteirosCaract intersecao (ConjInteirosCaract a, ConjInteirosCaract b) {
		if (a.vetor.length != b.vetor.length)
			throw new IllegalArgumentException("Conjuntos com tamanhos diferentes");
		ConjInteirosCaract c = new ConjInteirosCaract();
		for (int i = 0; i < c.vetor.length; i++) {
			if (a.vetor[i] && b.vetor[i])
				c.adicionarElemento(i);;
		}
		return c;
	}
	
	public String toString() {
		if (this.vazio())
			return "Conjunto vazio";
		String retorno = "";
		for (int i = 0; i < this.vetor.length; i++)
			if (this.vetor[i])
				retorno += i + " ";
		return retorno;
	}
	
	public static void main(String[] args) {
		ConjInteirosCaract a = new ConjInteirosCaract(3, 5, 8, 10, 6, 1);
		ConjInteirosCaract b = new ConjInteirosCaract(1, 6, 9, 10, 2);
		ConjInteirosCaract c = uniao(a,b);
		ConjInteirosCaract d = intersecao(a,b);
		ConjInteirosCaract e = new ConjInteirosCaract();
		System.out.println("A (" + a.cardinalidade() + " elementos): " + a);
		System.out.println("B (" + b.cardinalidade() + " elementos): " + b);
		System.out.println("C (" + c.cardinalidade() + " elementos): " + c);
		System.out.println("D (" + d.cardinalidade() + " elementos): " + d);
		System.out.println("E (" + e.cardinalidade() + " elementos): " + e);
		System.out.println(a.ehSubconjunto(a));
		System.out.println(a.ehSubconjunto(c));
		System.out.println(a.ehSubconjuntoProprio(a));
		System.out.println(a.maiorELemento());
		System.out.println(b.maiorELemento());
		System.out.println(c.menorELemento());
		System.out.println(d.menorELemento());
		System.out.println(e.maiorELemento());
	}
	
}
