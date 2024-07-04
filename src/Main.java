import java.util.Scanner;

public class Main {
    public static void imprimirConPausa(String texto, int segundos) {
        System.out.println(texto);
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        int opcion = 1;
        Scanner scanner = new Scanner(System.in);
        ClearScreen limpiarPantalla = new ClearScreen();

        while (opcion != 0){
            limpiarPantalla.clearScreen();
            System.out.println("#######################################################");
            System.out.println("      Conversion de monedas:   ");
            System.out.println("      Seleccion un tipo de cambio");
            System.out.println("      1- USD -> ARS  : Dolares a peso argentino");
            System.out.println("      2- ARS -> USD  : Peso Argentino a Dolar  ");
            System.out.println("      3- USD -> CLP  : Dolares a peso Chileno");
            System.out.println("      4- CLP -> USD  : Peso Chileno a Dolar  ");
            System.out.println("      5- USD -> BRL  : Dolares a peso Brasileño");
            System.out.println("      6- BRL -> USD  : Peso Brasileño a Dolar  ");
            System.out.println("      7- USD -> COP  : Dolares a peso Colombiano");
            System.out.println("      8- COP -> USD  : Peso Colombiano a Dolar  ");
            System.out.println("       0-  para salir ");
            System.out.println("########################################################");
            System.out.println();
            opcion = scanner.nextInt();
            if (opcion ==0 ){
                System.out.println("Gracias por usar nuestro conversor de moneda ALURA..");
            }else{
                switch (opcion){
                    case 1:
                        imprimirConPausa("Seleccionada opcion 1", 3);
                        break;
                    case 2:
                        imprimirConPausa("seleccionada opcion 2",3);
                        break;
                }
            }
        }
    }
}