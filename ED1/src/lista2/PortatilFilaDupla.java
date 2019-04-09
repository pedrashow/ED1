package lista2;

import filaGenerica.FilaDuplaGenerica;

public class PortatilFilaDupla {
	
	private FilaDuplaGenerica<Portatil> filaDupla;
	
	public PortatilFilaDupla(int quantidade) {
		this.filaDupla = new FilaDuplaGenerica<>(quantidade);
	}
	
	/**
	 * Qualquer Smartphone deve ficar antes de todo Tablet
	 * Quem tem preço menor sai primeiro
	 * 
	 */
	
	
	public boolean insere (Portatil p) {
		if (!this.filaDupla.cheia()) {
			if (p instanceof Smartphone) {
				this.insereSmart((Smartphone)p);
				return true;
			} else {
				this.insereTablet((Tablet)p);
				return true;
			}
		}
		System.out.println("Armazenamento cheio");
		return false;
		
	}
	
	public Portatil remove () { //remove do inicio se for Smart, do fim se for tablet
		if (!this.filaDupla.vazia()) {
			if (filaDupla.verPrimeiro() instanceof Smartphone)
				return filaDupla.remove();
			return filaDupla.removeFim();
		}
		System.out.println("Nenhum portatil armazenado");
		return null;
	}
	
	private void insereSmart (Smartphone s) {
		//empilhar recursivamente os smartphones, tirando e inserindo no inicio até encontrar a posicao correta do item a inserir
		
		if (this.filaDupla.vazia() || 
				this.filaDupla.verPrimeiro() instanceof Tablet || 
					this.filaDupla.verPrimeiro().getPreco() > s.getPreco()) {
			this.filaDupla.insereInicio(s);
			return;
		}
			
		Portatil elemento = this.filaDupla.remove();
		this.insereSmart(s);
		filaDupla.insereInicio(elemento);
	}
	
	private void insereTablet (Tablet t) {
		//empilhar recursivamente os tablets, tirando e inserindo no fim até encontrar a posicao correta do item a inserir
		if (this.filaDupla.vazia() || 
				this.filaDupla.verUltimo() instanceof Smartphone || 
					this.filaDupla.verUltimo().getPreco() > t.getPreco()) {
			this.filaDupla.insere(t);
			return;
		}	
		Portatil elemento = this.filaDupla.removeFim();
		this.insereTablet(t);
		filaDupla.insere(elemento);
	}
	
	public void imprimeFila() {
		if (this.filaDupla.vazia())
			return;
		Portatil elemento = this.remove();
		System.out.println(elemento.toString());
		this.imprimeFila();
		this.insere(elemento);
	}
	
}
