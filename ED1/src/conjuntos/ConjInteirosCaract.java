package conjuntos;

public class ConjInteirosCaract {
	
	private boolean[] vetor;
	private int qtdElementos;
	
	ConjInteirosCaract() {
		int TAMANHO = 100; //alterar para o tamanho desejado
		vetor = new boolean[TAMANHO];
		qtdElementos = 0;
	}
	
	ConjInteirosCaract(int... numeros) { //inclui todos os elementos passados por parametro no conjunto
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
		if (this.vazio())
			return Integer.MIN_VALUE;
		boolean x = false;
		int i = this.vetor.length+1;
		while (!x) {
			i--;
			x = this.vetor[i];
		}
		return i;
	}
	
	public int menorELemento() {
		if (this.vazio())
			return Integer.MAX_VALUE;
		boolean x = false;
		int i = -1;
		while (!x) {
			i++;
			x = this.vetor[i];
		}
		return i;
	}
	
	public boolean ehSubconjunto(ConjInteirosCaract c) {
		if (this.vetor.length != c.vetor.length) {
			System.err.println("Conjuntos com especificacoes diferentes");
			return false;
		}
		for (int i = 0; i < this.vetor.length; i++) {
			if ( !this.vetor[i] || c.vetor[i] )
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
		System.out.println("A " + a);
		System.out.println("B " + b);
		System.out.println("C " + c);
		System.out.println("D " + d);
		System.out.println(d.ehSubconjunto(a));
		}
	
}
