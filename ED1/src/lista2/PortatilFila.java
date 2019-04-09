package lista2;

import filaGenerica.FilaGenerica;

/**
 * mantem as regras de negocio da classe PortatilFilaDupla
 * @author Beto
 *
 */

public class PortatilFila {
	
	private FilaGenerica<Portatil> filaPortatil;
	
	public PortatilFila (int quantidade) {
		this.filaPortatil = new FilaGenerica<>(quantidade);
	}
	
	public void insere (Portatil p) {
		if (this.filaPortatil.cheia()) {
			System.out.println("Armazenamento Cheio");
			return;
		}
		
		if (this.filaPortatil.vazia()) {
			this.filaPortatil.insere(p);
			return;
		}
		
		FilaGenerica<Portatil> filaAux = new FilaGenerica<>(this.filaPortatil.getTamanho());
		boolean inserido = false;
		
		while (!this.filaPortatil.vazia() ) {
			if (!inserido && comparaPortateis(p, this.filaPortatil.verPrimeiro())) {
				filaAux.insere(p);
				inserido = true;
			} else {
				filaAux.insere(this.filaPortatil.remove());
			}
		}
		filaAux.transfereFila(this.filaPortatil);
		
	}
	
	public Portatil remove() {
		return this.filaPortatil.remove();
	}
	
	private static boolean comparaPortateis(Portatil p1, Portatil p2) { //compara prioridade segundo a regra de negocio
		if (p1.getClass().equals(p2.getClass()))
			return (p1.getPreco() <= p2.getPreco());
		if (p1 instanceof Smartphone)
			return true;
		return false;
	}
	
	public void imprimeFila() {
		if (this.filaPortatil.vazia())
			return;
		Portatil elemento = this.remove();
		System.out.println(elemento.toString());
		this.imprimeFila();
		this.insere(elemento);
	}


}
