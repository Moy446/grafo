
package grafo;

import java.util.LinkedList;
import java.util.List;

public class Nodo {
    int value;
    adyacencia lista;
    Nodo next;
    int costo;
    List<Nodo> shortPath = new LinkedList<>();

    public Nodo(int value) {
        this.value = value;
        costo = Integer.MAX_VALUE;
        lista = new adyacencia();
        next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public adyacencia getLista() {
        return lista;
    }

    public void setLista(adyacencia lista) {
        this.lista = lista;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public List<Nodo> getShortPath() {
        return shortPath;
    }

    public void setShortPath(List<Nodo> shortPath) {
        this.shortPath = shortPath;
    }
    
    
}
