package grafo;

public class main {
    static grafo grafo = new grafo();
    public static void main(String[] args) {

        
        Nodo nodo0 = new Nodo(0);
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        Nodo nodo4 = new Nodo(4);
        Nodo nodo5 = new Nodo(5);
        Nodo nodo6 = new Nodo(6);
        Nodo nodo7 = new Nodo(7);
        Nodo nodo8 = new Nodo(8);
        
        grafo.newNodo(nodo0);
        grafo.newNodo(nodo1);
        grafo.newNodo(nodo2);
        grafo.newNodo(nodo3);
        grafo.newNodo(nodo4);
        grafo.newNodo(nodo5);
        grafo.newNodo(nodo6);
        grafo.newNodo(nodo7);
        grafo.newNodo(nodo8);
        
        // direcciones 0
        origenDestino(nodo0, nodo1, 4);
        origenDestino(nodo0, nodo7, 8);
        // direcciones 1
        origenDestino(nodo1, nodo2, 8);
        origenDestino(nodo1, nodo7, 11);
        // direcciones 2 
        origenDestino(nodo2, nodo3, 7);
        origenDestino(nodo2, nodo8, 2);
        origenDestino(nodo2, nodo5, 4);
        // direcciones 3
        origenDestino(nodo3, nodo4, 9);
        origenDestino(nodo3, nodo5, 14);
        // direcciones 4
        origenDestino(nodo4, nodo5, 10);
        // direcciones 5
        origenDestino(nodo5, nodo6, 2);
        // direcciones 6
        origenDestino(nodo6, nodo8, 6);
        origenDestino(nodo6, nodo7, 1);
        // direcciones 7
        origenDestino(nodo7, nodo8, 7);
        
        
        System.out.println(grafo.mostrar());
        System.out.println(grafo.mostrarP());
        
        System.out.println(grafo.buscar(grafo, nodo0, nodo4));
    }
    
    public static void origenDestino (Nodo origen, Nodo destino, int Peso){
        if (grafo.existeVertice(origen) && grafo.existeVertice(destino)) {
            grafo.newArista(origen, destino, Peso);
            grafo.newArista(destino, origen, Peso);
        }
    }
}
