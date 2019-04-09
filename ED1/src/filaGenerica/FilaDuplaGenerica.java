package filaGenerica;

public class FilaDuplaGenerica <T> extends FilaGenerica <T> {
	
	public FilaDuplaGenerica(int tamanho) {
		super(tamanho);
	}
	
	public boolean insereInicio (T elemento) {
		
		int prec;
		
		if (!this.cheia()) {
			prec = (this.inicio - 1 + this.tamanho) % this.tamanho;
			this.vetor.set(prec, elemento);
			this.inicio = prec;
			this.num ++;
			return true;
		} else
			return false; 
		
		
	}
	
	public T removeFim() {
		
		T elemento = null;
		int ult;

		if (!this.vazia()) {
			ult = (this.inicio + this.num - 1) % this.tamanho;
			elemento = this.vetor.get(ult);
			this.num--;
		}

		return elemento;
	}
	
    public T verUltimo() {
    	if (this.vazia())
    		return null;
    	return this.vetor.get((this.inicio + this.num - 1) % this.tamanho);
    }
	
	
}
