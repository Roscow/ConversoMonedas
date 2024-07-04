import java.util.Scanner;

public class Main {
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

                String monedaDesde="USD";
                String monedaHacia="USD";
                switch (opcion){
                    case 1:
                        monedaDesde = "USD";
                        monedaHacia = "ARS";
                        break;
                    case 2:
                        monedaDesde = "ARS";
                        monedaHacia = "USD";
                        break;
                    case 3:
                        monedaDesde = "USD";
                        monedaHacia = "CLP";
                        break;
                    case 4:
                        monedaDesde = "CLP";
                        monedaHacia = "USD";
                        break;
                    case 5:
                        monedaDesde = "USD";
                        monedaHacia = "BRL";
                        break;
                    case 6:
                        monedaDesde = "BRL";
                        monedaHacia = "USD";
                        break;
                    case 7:
                        monedaDesde = "USD";
                        monedaHacia = "COP";
                        break;
                    case 8:
                        monedaDesde = "COP";
                        monedaHacia = "USD";
                        break;
                }
                Utilidades.imprimirConPausa("Seleccionada opcion n° :"+opcion, 3);
                System.out.println("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();
                Conversor conversor = new Conversor(monedaDesde, monto, monedaHacia);
                conversor.resultado();
            }
        }
    }
}