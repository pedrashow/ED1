package lista4;

public class Dir extends ItemArmazenado {

	private ItemArmazenado filhoEsquerdo = null;

	public Dir(Dir pai, String s) {
		super(pai, s);
	}

	public void adicionaFilho(ItemArmazenado item) {
		if (this.filhoEsquerdo == null) {
			this.filhoEsquerdo = item;
			return;
		}
		ItemArmazenado anterior = null;
		ItemArmazenado corrente = this.filhoEsquerdo;
		while (!(corrente == null)) {
			anterior = corrente;
			corrente = corrente.getIrmaoDireito();
		}
		anterior.setIrmaoDireito(item);
	}

	public ItemArmazenado getFilhoEsquerdo() {
		return this.filhoEsquerdo;
	}

	public String toString() { //adicionar pasta vazia se este for o caso
		String s = super.toString();
		if (this.filhoEsquerdo == null) {
			ItemArmazenado pai = this.getPai();
			while (pai != null) {
				s += "   ";
				pai = pai.getPai();
			}
			s += "   (Pasta Vazia)";
		}
		return s;
	}

	public boolean fim() {
		return this.filhoEsquerdo == null;
	}

}
