import java.util.Scanner;

public class CostoLlamadas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int zonaSeleccionada = 0;
        int minutos = 0;
        float costoTotal = 0;
        String claveZona = "";

        System.out.println("Tabla de precios por zona:");
        System.out.println("| Zona                 | Clave | Precio Minuto (USD)  |");
        System.out.println("| America del Norte    | +12   | 2.75                |");
        System.out.println("| America Central      | +15   | 1.89                |");
        System.out.println("| America del Sur      | +18   | 1.60                |");
        System.out.println("| Europa               | +19   | 3.50                |");
        System.out.println("| Asia                 | +23   | 4.50                |");
        System.out.println("| Africa               | +25   | 3.10                |");
        System.out.println("| Oceania              | +29   | 3.00                |");
        System.out.println("| Resto del Mundo      | +31   | 6.00                |");

        System.out.println("Ingresa la zona (12, 15, 18, 19, 23, 25, 29, 31):");

        do {
            if (scanner.hasNextInt()) {
                zonaSeleccionada = scanner.nextInt();
                if (Zona.obtenerZonaPorClave(zonaSeleccionada) != null) {
                    Zona zona = Zona.obtenerZonaPorClave(zonaSeleccionada);
                    claveZona = zona.getNombre();
                    costoTotal = zona.getCostoMinuto();
                    break;
                } else {
                    System.out.println("Zona no valida");
                }
            } else {
                System.out.println("Ingresa un numero entero");
                scanner.next();
            }
        } while (true);

        System.out.println("USTED HA SELECCIONADO ZONA: \n" + claveZona);
        System.out.println("Ingrese el numero de minutos:");

        do {
            if (scanner.hasNextInt()) {
                minutos = scanner.nextInt();
                if (minutos >= 0 && minutos <= 1000000000) {
                    break;
                } else {
                    System.out.println("Numero de minutos no valido");
                }
            } else {
                System.out.println("Ingresa un numero entero");
                scanner.next();
            }
        } while (true);

        float totalAPagar = minutos * costoTotal;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("TABLA DE RESUMEN");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Zona seleccionada:          | " + claveZona);
        System.out.println("Clave:                      | +" + zonaSeleccionada);
        System.out.println("COSTO ZONA SELECCIONADA:    | $" + costoTotal);
        System.out.println("MINUTOS EN LLAMADA :        | " + minutos);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("SUBTOTAL:                   | $" + minutos+ "*"+ costoTotal);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("TOTAL A PAGAR:              | $" + totalAPagar);

        scanner.close();
    }
}