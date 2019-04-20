package lista4;

public abstract class ItemArmazenado {
	
	private Diretorio pai;
	private String nome;
	
	public Diretorio getPai() {
		return this.pai;
	}
	
	public String toString() {
		return this.nome;
	}

}
