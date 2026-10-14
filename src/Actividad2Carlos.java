

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

    // PUNTO 1: Recorrer toda la lista
    public void recorrerLista() {
        Nodo actual = cabeza;

        if (actual == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        while (actual != null) {
            System.out.println("Solicitud: " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // PUNTO 2: Insertar al inicio
    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // PUNTO 3: Insertar al final
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // PUNTO 4: Insertar despues de un nodo dado
    public void insertarDespuesDe(int datoBuscado, int nuevoDato) {
        Nodo actual = cabeza;

        while (actual != null && actual.dato != datoBuscado) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("No se encontro la solicitud: " + datoBuscado);
            return;
        }

        Nodo nuevo = new Nodo(nuevoDato);
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }

    public static void main(String[] args) {
        Actividad2Carlos lista = new Actividad2Carlos();

        // Crear lista inicial
        lista.insertarAlInicio(103);
        lista.insertarAlInicio(102);
        lista.insertarAlInicio(101);

        System.out.println("LISTA INICIAL:");
        lista.recorrerLista();

        // Punto 2: Insertar al inicio
        lista.insertarAlInicio(100);
        System.out.println("\nDESPUES DE INSERTAR AL INICIO:");
        lista.recorrerLista();

        // Punto 3: Insertar al final
        lista.insertarAlFinal(104);
        System.out.println("\nDESPUES DE INSERTAR AL FINAL:");
        lista.recorrerLista();

        // Punto 4: Insertar despues del nodo 102
        lista.insertarDespuesDe(102, 105);
        System.out.println("\nDESPUES DE INSERTAR 105 TRAS 102:");
        lista.recorrerLista();
    }
}
