package lista4;

public abstract class ItemArmazenado {
	
	private Dir pai;
	private String nome;
	private ItemArmazenado irmaoDireito = null;
	
	public ItemArmazenado(Dir dirPai, String nome) {
		this.pai = dirPai;
		this.nome = nome;
		if (pai != null)
			pai.adicionaFilho(this);
	}
	
	public Dir getPai() {
		return this.pai;
	}
	
	public String toString() { // imprimir com as tabulacoes corretas
		String s = "";
		ItemArmazenado pai = this.pai;
		while(pai != null) {
			s+= "   ";
			pai = pai.getPai();
		}
		s += this.nome;
		s += "\n";
		return s;
	}
	
	public abstract ItemArmazenado getFilhoEsquerdo();
	
	public ItemArmazenado getIrmaoDireito() {
		return this.irmaoDireito;
	}
	
	public void setIrmaoDireito(ItemArmazenado item) {
		this.irmaoDireito = item;
	}
	
	public abstract boolean fim();

}
