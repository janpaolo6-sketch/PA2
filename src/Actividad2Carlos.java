
public class Actividad2Carlos {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    Nodo cabeza;

    // Punto 1: Recorrer toda la lista enlazada
    public void recorrerLista() {
        Nodo actual = cabeza;

        while (actual != null) {
            System.out.println("Solicitud: " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // Punto 2: Insertar un nodo al inicio
    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public static void main(String[] args) {
        Actividad2Carlos lista = new Actividad2Carlos();

        lista.insertarAlInicio(103);
        lista.insertarAlInicio(102);
        lista.insertarAlInicio(101);

        System.out.println("Lista inicial:");
        lista.recorrerLista();

        lista.insertarAlInicio(100);

        System.out.println("\nLista después de insertar al inicio:");
        lista.recorrerLista();
    }
}
