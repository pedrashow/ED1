package FilaPrioridade;

public class Aplicacao extends SistemaOperacional {
	Aplicacao(int i, String s) {
		super(i, s);
	}

	public int compareTo(SistemaOperacional a) {
		if (this.getClass() == a.getClass()) {
			if (this.getPrioridade() > a.getPrioridade())
				return 1;
			if (this.getPrioridade() == a.getPrioridade())
				return 0;
		}
		return -1;
	}
}
