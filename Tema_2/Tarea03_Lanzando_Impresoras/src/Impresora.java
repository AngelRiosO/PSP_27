/**
 * Tarea que simula una impresora imprimiendo un documento página a página
 * Implementa Runnable para que su trabajo pueda ejecutarse en un hilo independiente
 */
public class Impresora implements Runnable {
    // Tiempo que tarda en imprimirse cada página (en milisegundos)
    private static final int TIEMPO_POR_PAGINA = 1000;

    // Nombre identificativo de la impresora (no cambia una vez creada)
    private final String nombre;
    // Número total de páginas que debe imprimir esta impresora
    private final int totalPaginas;

    /**
     * Crea una impresora con su nombre y el número de páginas a imprimir
     *
     * @param nombre       nombre de la impresora
     * @param totalPaginas número de páginas del trabajo de impresión
     */
    public Impresora(String nombre, int totalPaginas) {
        this.nombre = nombre;
        this.totalPaginas = totalPaginas;
    }

    /**
     * Código ejecuta el hilo imprime las páginas desde la 1 hasta el final
     */
    @Override
    public void run() {
        for (int paginaActual = 1; paginaActual <= totalPaginas; paginaActual++) {
            System.out.println(nombre + " imprimiendo página " + paginaActual + "/" + totalPaginas);
            try {
                // Simulamos el tiempo que tarda en imprimirse una página
                Thread.sleep(TIEMPO_POR_PAGINA);
            } catch (InterruptedException e) {
                // Restablecemos el estado de interrupción para no perderlo
                Thread.currentThread().interrupt();
                System.out.println(nombre + " ha sido interrumpida. Trabajo cancelado.");
                // Terminamos la tarea
                return;
            }
        }
        // Mensaje de finalización cuando se han impreso todas las páginas
        System.out.println(nombre + " ha terminado de imprimir sus " + totalPaginas + " páginas.");
    }
}