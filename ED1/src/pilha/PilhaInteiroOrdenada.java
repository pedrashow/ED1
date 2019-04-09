package pilha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beto
 */
public class PilhaInteiroOrdenada extends PilhaGenerica<Integer> {
    
    private int[] vetor;
    
    public PilhaInteiroOrdenada(int tamanho) {
        super(tamanho);
        vetor = new int[tamanho];
    }
    
    @Override
    public Integer pop() {
        
        Integer x = null;
        
        if (this.vazia()) {
            System.out.println("Pilha vazia");
        } else {
            x = vetor[topo];
            topo--;
        }
        
       // if (topo > 0 && topo == n/4)
       //     alteraTamanho(n/2);
        
        return x;
    }
    
    public Integer retornaTopo() {
        Integer x = null;        
        if (!this.vazia())
            x = vetor[topo];
        return x;
    }
    
    public void alteraTamanho(int novoTamanho) {
        int[] copia = new int[novoTamanho];
        for (int i = 0; i <= topo; i++)
            copia[i] = this.vetor[i];
        this.vetor = copia;
        this.n = novoTamanho;
        System.out.println("alterou" + this.n);
    }
        
    @Override
    public boolean push(Integer x) {
        /**
         * Se a pilha estiver cheia, dobrar o tamanho
         * Enquanto o número a entrar for menor que o topo
         * retirar da pilha principal, armazenando em uma temporaria
         * colocar o numero em questão.
         * retornar a pilha temporária de volta à principal
         */
       
        if (this.cheia())
            this.alteraTamanho(this.n * 2);
        Integer y = x;
        PilhaGenerica<Integer> pilhaTemp = new PilhaGenerica<>(this.topo+1);
        while (!this.vazia() || x > y) {
            y = this.retornaTopo();
            if (x < y)
                pilhaTemp.push(this.pop());
        }
        this.vetor[++topo] = x;
        while (!pilhaTemp.vazia()) {
            this.vetor[++topo] = pilhaTemp.pop();
        }
        return true;
    }
       
    @Override
    public String imprimePilha() { //para debug apenas
        String s = "";
        for (int i=0;i<=topo-1;i++)
            s += (this.vetor[i] + ", ");
        s+= this.vetor[topo];
        return s;
    }       
    
    public static void main(String[] args) {
        PilhaInteiroOrdenada pilha = new PilhaInteiroOrdenada(5);
        for (int i = 30; i > 0; i--) {
            pilha.push(i);
            System.out.println(pilha.imprimePilha() + " topo:" + pilha.topo );
        }
    }
}
