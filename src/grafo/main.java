package grafo;

public class main {
    static grafo grafo = new grafo();
    public static void main(String[] args) {

        
        Nodo nodoA = new Nodo(11);
        Nodo nodoB = new Nodo(12);
        Nodo nodoC = new Nodo(13);
        Nodo nodoD = new Nodo(14);
        Nodo nodoE = new Nodo(15);
        Nodo nodoF = new Nodo(16);
        
        grafo.newNodo(nodoA);
        grafo.newNodo(nodoB);
        grafo.newNodo(nodoC);
        grafo.newNodo(nodoD);
        grafo.newNodo(nodoE);
        grafo.newNodo(nodoF);
        
        origenDestino(nodoA, nodoB, 2);
        
        origenDestino(nodoB, nodoC, 7);
        origenDestino(nodoB, nodoD, 6);
        origenDestino(nodoB, nodoE, 10);
        origenDestino(nodoB, nodoF, 2);
        
        origenDestino(nodoC, nodoD, 4);
        origenDestino(nodoC, nodoF, 1);
        
        origenDestino(nodoD, nodoE, 3);
        
        origenDestino(nodoE, nodoF, 5);
        
        System.out.println(grafo.mostrar());
        System.out.println(grafo.mostrarP());
        
        System.out.println(grafo.buscar(grafo, nodoD, nodoF));
    }
    
    public static void origenDestino (Nodo origen, Nodo destino, int Peso){
        if (grafo.existeVertice(origen) && grafo.existeVertice(destino)) {
            grafo.newArista(origen, destino, Peso);
            grafo.newArista(destino, origen, Peso);
        }
    }
}
