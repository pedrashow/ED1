package filaGenerica;


import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kinoplex
 */
public class FilaGenerica<T> {
    protected int inicio; //primeiro da fila
    protected int num; //qtd elementos
    protected int tamanho; //tamanho da fila
    protected Vector<T> vetor;
    
    public FilaGenerica(int tamanho){
        vetor = new Vector<>(tamanho);
        inicio= 0;
        num= 0;
        this.tamanho= tamanho;
        
        /* o codigo abaixo não deveria existir. Contudo, como o Vector é alocado dinamicamente
         * em java, é necessário garantir uma alocação de memória física desde a construção,
         * para que a lógica demonstrada em sala para inserir um elemento no inicio seja funcional.
         */
        
        for (int i = 0; i < tamanho; i++)
        	vetor.add(null);
                
    }
    
    public boolean vazia(){
        
        return num == 0 ? true:false;
    }
    
    public boolean cheia(){
        
        return num == tamanho ? true:false;
    }
    
    public T remove(){
        T elemento= null;
        
        if(!this.vazia()){
            elemento= vetor.get(inicio);
            inicio= (inicio + 1) % tamanho;
            num--;
                                    
        }
        return elemento;
                
    }

    public boolean insere(T elemento){
        int fim= 0;
        
        if(!this.cheia()){
            fim= (inicio + num) % tamanho;
            vetor.set(fim, elemento);
            num++;
            
            return true;
            
        }
        
        return false;
    }
    
    public T verPrimeiro() {
    	if (this.vazia())
    		return null;
    	return vetor.get(inicio);
    }
 
    public int getTamanho() {
    	return this.tamanho;
    }
    
    public void transfereFila(FilaGenerica<T> f) {
    	while (!this.vazia())
    		f.insere(this.remove());
    }
    
    public static <T> FilaDuplaGenerica<T> converteEmDupla(FilaGenerica<T> filaSimples) {
    	FilaDuplaGenerica<T> filaDupla = new FilaDuplaGenerica<>(filaSimples.getTamanho());
    	while (!filaSimples.vazia())
    		filaDupla.insere(filaSimples.remove());
    	return filaDupla;
    	
    }
      
}
