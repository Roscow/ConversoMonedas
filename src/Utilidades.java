public class Utilidades {

    /**
     * Imprime un texto y se pausa por la cantidad de segundos indicada.
     *
     * @param texto el texto a imprimir
     * @param segundos la cantidad de segundos a pausar
     */
    public static void imprimirConPausa(String texto, int segundos) {
        System.out.println(texto);
        try {
            Thread.sleep(segundos * 1000); // convertir segundos a milisegundos
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
