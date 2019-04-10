package pilha;

import java.util.Vector;

public class PilhaGenerica<T> {
	protected int n;
	protected Vector<T> vetor;
	protected int topo;

	public PilhaGenerica(int tamanho) {
		n = tamanho;
		vetor = new Vector<T>(tamanho);
		topo = -1;
	}

	public boolean vazia() {
		return topo == -1 ? true : false;
	}

	public boolean cheia() {
		return topo == n - 1 ? true : false;
	}

	public T pop() {
		T elemento;

		if (!this.vazia()) {
			elemento = vetor.get(topo--);
			return elemento;
		} else {
			// Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop nao funcionou.");
			return null;
		}
	}

	public boolean push(T elemento) {
		if (!this.cheia()) {
			vetor.add(++topo, elemento);
			return true;
		} else {
			// Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}

	public boolean retornaTopo(T elemento) {
		if (!this.vazia()) {
			elemento = vetor.get(topo);
			return true;
		} else
			return false;
	}

	public void transfereInvertendo(PilhaGenerica<T> p) {
		while (!this.vazia())
			p.push(this.pop());
	}

	public void transferePilha(PilhaGenerica<T> p) {
		PilhaGenerica<T> pilhaTemp = new PilhaGenerica<>(this.topo + 1);
		this.transfereInvertendo(pilhaTemp);
		pilhaTemp.transfereInvertendo(p);
	}

	public void transferePilhaRecursivo(PilhaGenerica<T> p) {
		T elemento;
		if (this.vazia())
			return;
		elemento = this.pop();
		this.transferePilhaRecursivo(p);
		p.push(elemento);
	}

	public void revertePilha() {
		PilhaGenerica<T> pilhaTemp1 = new PilhaGenerica<>(this.topo + 1);
		PilhaGenerica<T> pilhaTemp2 = new PilhaGenerica<>(this.topo + 1);
		this.transfereInvertendo(pilhaTemp1);
		pilhaTemp1.transfereInvertendo(pilhaTemp2);
		pilhaTemp2.transfereInvertendo(this);
	}

	public String imprimePilha() { // para debug apenas
		String s = "";
		for (int i = 0; i <= topo - 1; i++)
			s += (this.vetor.get(i) + " ,");
		s += this.vetor.get(topo);
		return s;
	}

	public int getTopo() {
		return this.topo;
	}

}