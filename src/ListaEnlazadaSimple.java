public class ListaEnlazadaSimple {

    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Clase ListaEnlazada
    static class ListaEnlazada {
        Nodo cabeza;

        // --- METODO DE BUSQUEDA ---
        public Nodo buscar(int valor) {
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.dato == valor) {
                    return actual; // Retorna el nodo encontrado
                }
                actual = actual.siguiente;
            }
            return null; // No encontrado
        }

        // --- METODO DE MODIFICACION ---
        public void modificar(int valorBuscado, int nuevoValor) {
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.dato == valorBuscado) {
                    actual.dato = nuevoValor; // Modifica el dato
                    System.out.println("Nodo modificado: " + valorBuscado + " -> " + nuevoValor);
                    return;
                }
                actual = actual.siguiente;
            }
            System.out.println("Valor " + valorBuscado + " no encontrado para modificar.");
        }

        // --- METODO DE ELIMINACION ---
        public void eliminar(int valor) {
            Nodo actual = cabeza;
            Nodo anterior = null;

            while (actual != null) {
                if (actual.dato == valor) {
                    if (anterior == null) {
                        // Caso 1: Es la cabeza
                        cabeza = actual.siguiente;
                    } else {
                        // Caso 2: Es intermedio o final
                        anterior.siguiente = actual.siguiente;
                    }
                    System.out.println("Nodo eliminado: " + valor);
                    return;
                }
                anterior = actual;
                actual = actual.siguiente;
            }
            System.out.println("Valor " + valor + " no encontrado para eliminar.");
        }

        // --- METODO AUXILIAR PARA MOSTRAR LA LISTA ---
        public void mostrar() {
            Nodo actual = cabeza;
            System.out.print("Lista: ");
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }

    // --- METODO MAIN PARA PRUEBAS ---
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        // Insertamos datos de ejemplo (Solicitudes de atencion)
        // Insertamos al inicio para simular carga rápida
        lista.cabeza = new Nodo(10);
        lista.cabeza.siguiente = new Nodo(20);
        lista.cabeza.siguiente.siguiente = new Nodo(30);
        lista.cabeza.siguiente.siguiente.siguiente = new Nodo(40);

        System.out.println("--- Lista Original ---");
        lista.mostrar();

        // 1. Probando Busqueda
        System.out.println("\n--- Buscando el 30 ---");
        Nodo encontrado = lista.buscar(30);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.dato);
        } else {
            System.out.println("No encontrado.");
        }

        // 2. Probando Modificacion
        System.out.println("\n--- Modificando el 20 por 99 ---");
        lista.modificar(20, 99);
        lista.mostrar();

        // 3. Probando Eliminacion (Caso Intermedio)
        System.out.println("\n--- Eliminando el 30 (Intermedio) ---");
        lista.eliminar(30);
        lista.mostrar();

        // 4. Probando Eliminacion (Caso Cabeza)
        System.out.println("\n--- Eliminando el 10 (Cabeza) ---");
        lista.eliminar(10);
        lista.mostrar();

        // 5. Probando Eliminacion (Caso Final)
        System.out.println("\n--- Eliminando el 40 (Final) ---");
        lista.eliminar(40);
        lista.mostrar();
    }

}
