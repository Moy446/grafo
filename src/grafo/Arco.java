package grafo;


public class Arco {
    Nodo destino;
    int peso;
    Arco next;

    public Arco(Nodo destino, int peso) {
        this.destino = destino;
        this.peso = peso;
        this.next = null;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Arco getNext() {
        return next;
    }

    public void setNext(Arco next) {
        this.next = next;
    }
    
    
       
    
}
