package grafo;

import java.util.ArrayList;

public class adyacencia {
    Arco first, last;

    public adyacencia() {
        this.first = null;
        this.last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public boolean adyacente(Nodo destino){
        Arco actual = first;
        while (actual != null && destino.getValue() != actual.destino.getValue()){
            actual = actual.next;
        }
        return actual != null;
    }
    
    public void newAdyancense(Nodo destino, int Peso){
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino, Peso);
            insert(nodo,destino);
        }
    }
    
    public void insert(Arco nodo, Nodo destino){
        if (isEmpty()) {
            first = nodo;
            last = nodo;
        }
        else if (destino.getValue() < first.destino.getValue()) {
            nodo.next = first;
            first = nodo;
        }else if(destino.getValue() > first.destino.getValue()){
            last.next = nodo;
            last = nodo;            
        }else{
            Arco position = first;
            while(destino.getValue() < position.destino.getValue()){
                position = position.next;
            }
            nodo.next = position.next;
            position.next = nodo;
        }
    }
    public String mostrar(Nodo primero){
        String valores = "";
        Arco temp = first;
        Nodo nodo = primero;
        while (temp != null){
            while(nodo != null){
                if (adyacente(nodo)) {
                    valores += 1 +" ";
                }else{
                    valores += 0 +" ";
                }
                nodo = nodo.next;
            }
            
            temp = temp.next;
        }
        return valores;
    }
    public String mostrarP(){
        String valores = "";
        Arco temp = first;
        while (temp != null){
            valores += "-"+temp.peso+"->";
            valores += temp.destino.getValue()+",";
            temp = temp.next;
        }
        return valores;
    }

    public ArrayList getArcos(){
        ArrayList<Arco> arcos =  new ArrayList<Arco>();
        Arco temp =  first;
        while(temp != null){
            arcos.add(temp);
            temp = temp.next;
        }
        return arcos;
    }
}
