package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class grafo {
    Nodo first, last;
    int cantAristas=0;

    public grafo() {
        first = last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public boolean existeVertice(Nodo nodo){
        boolean existe = false;
        if (!isEmpty()) {
            Nodo temp = first;
            while(temp != null && !existe){
                if (temp.value == nodo.getValue()) {
                    existe =true;
                }
                temp = temp.next;
            }
        }
        return existe;
    }
    
    public void newArista(Nodo origen, Nodo destino, int Peso){
        Nodo position= first;
        while(position.value != origen.getValue()){
            position = position.next;
        }
        position.lista.newAdyancense(destino, Peso);
        cantAristas++;
    }
    
    public void newNodo (Nodo nodo){
        if (!existeVertice(nodo)) {
            
            if (isEmpty()) {
                first = last = nodo;
            }else if(nodo.getValue() < first.value){
                nodo.next =  first;
                first = nodo;
            }else if(nodo.getValue() > first.value){
                last.next = nodo;
                last = nodo;            
            }else{
                Nodo temp = first;
                while(nodo.getValue() < temp.value){
                    temp = temp.next;
                }
                nodo.next = temp.next;
                temp.next = nodo;
            }
        }
    }
    
    public String mostrar(){
        String valores = "   ";
        Nodo temp = first;
        while(temp != null){
            valores += temp.value+" ";
            temp = temp.next;
        }
        valores+= "\n";
        temp =first;
        while (temp != null){            
            valores += temp.value +"->"+ temp.lista.mostrar(first)+"\n";
            temp = temp.next;
        }
        return valores;
    }
    
    public String mostrarP(){
        String valores = "";
        Nodo temp = first;
        while (temp != null){
            valores += temp.value +" "+temp.lista.mostrarP()+"\n";
            temp = temp.next;
        }
        return valores;
    }
   
    public String buscar (grafo grafo, Nodo origen, Nodo destino){
        String valores = "";
        Nodo temp = first;
        grafo = calulatedShorthestPath(grafo, origen);
        valores += "ruta mas corta del nodo "+origen.value+" hasta -> "+destino.value+"\n"; 
        while(temp!=null){
            if(temp.getValue() == destino.getValue()){
                for (Nodo nodo :temp.getShortPath() ) {
                    valores += nodo.getValue()+"->";
                }
            }
            
            temp = temp.next;
        }
        valores += destino.getValue()+"\n";
        return valores;
    }
    
    public grafo calulatedShorthestPath(grafo grafo, Nodo origen){
        origen.setCosto(0);
        Set<Nodo> visitados = new HashSet<>();
        Set<Nodo> noVisitados = new HashSet<>();
        
        noVisitados.add(origen);
        
        while (noVisitados.size() != 0) {
            Nodo currentNode = getLowestDistanceNode(noVisitados);
            noVisitados.remove(currentNode);
            ArrayList<Arco> arcos = currentNode.getLista().getArcos();
            for (Arco arco : arcos) {
                Nodo adjacentNode = arco.getDestino();
                int costoConexion =  arco.getPeso();
                if (!visitados.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, costoConexion, currentNode);
                    noVisitados.add(adjacentNode);
                }
            }
            visitados.add(  currentNode);
        }
        
        
        return grafo;
    }
    
    private Nodo getLowestDistanceNode(Set < Nodo > noVisitados) {
        Nodo lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        
        for (Nodo node: noVisitados) {
            int nodeDistance = node.getCosto();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
    return lowestDistanceNode;
    }
    
    private void CalculateMinimumDistance(Nodo destino, int costo, Nodo origen) {
        int distanciaCosto = origen.getCosto();
        if (distanciaCosto + costo < destino.getCosto()) {
            destino.setCosto(distanciaCosto + costo);
            LinkedList<Nodo> shortestPath = new LinkedList<>(origen.getShortPath());
            shortestPath.add(origen);
            destino.setShortPath(shortestPath);
        }
    }

}
