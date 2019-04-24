package lista4;

public class Arquivo extends ItemArmazenado {
	public Arquivo(Dir pai, String s) {
		super(pai,s);
	}
	
	public boolean fim() {
		return true;
	}
	
	public ItemArmazenado getFilhoEsquerdo() {
		return null;
	}
}
