public class Main {
    public static void main(String[] args) {
        // Crear las tres tareas de impresión (objetos Runnable)
        Impresora impresoraA = new Impresora("Impresora A", 3);
        Impresora impresoraB = new Impresora("Impresora B", 5);
        Impresora impresoraC = new Impresora("Impresora C", 4);

        // Asociar cada tarea a su propio hilo
        Thread hiloA = new Thread(impresoraA);
        Thread hiloB = new Thread(impresoraB);
        Thread hiloC = new Thread(impresoraC);

        // Lanzar los tres hilos para que trabajen en paralelo
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}