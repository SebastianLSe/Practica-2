/// //Una compañía de autos usados paga $2,500.00 de sueldo a sus empleados por mes, Además agrega
/// pagos extras a sus sueldos como: una comisión de $250.00 por cada automóvil vendido cuyo valor
/// de venta supere el $10,000.00 y el 5% de utilidad del valor total de ventas.  La compañía necesita
/// emitir un informe desglosado por empleado donde indique el número total de autos vendidos, el valor
///  total de los autos que vendió, el monto total que se le debería pagar al final del mes, indicando:
/// el sueldo mensual, la comisión por cada automóvil y la utilidad por el valor total de la venta. También
/// debe permitir ingresar la venta de los automóviles hasta que se desee y luego emitir el respectivo informe.
import java.util.Scanner;

public class InformeVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sueldoBase = 2500.00;
        double comisionPorAuto = 250.00;
        double porcentajeUtilidad = 0.05;
        double totalVentas = 0.0;
        double comisionTotal = 0.0;
        double utilidadTotal = 0.0;
        int contadorVentas = 0;

        while (true) {
            System.out.print("Ingrese el valor de la venta del auto:\n ");
            double valorVenta = 0.0;

            while (true) {
                if (scanner.hasNextDouble()) {
                    valorVenta = scanner.nextDouble();
                    if (valorVenta >= 0) {
                        totalVentas += valorVenta;
                        contadorVentas++;
                        break;
                    } else {
                        System.out.println("Ingrese un numero positivo");
                    }
                } else {
                    System.out.println("Ingrese un numero valido");
                    scanner.next();
                }
            }if (valorVenta >= 10000) {
                comisionTotal += comisionPorAuto;
            }

            System.out.print("¿Desea ingresar otra venta? \n: ");
            String continuar = scanner.next();
            while (!continuar.equalsIgnoreCase("si") && !continuar.equalsIgnoreCase("no")) {
                System.out.println("Conteste con 'si' o 'no'.");
                continuar = scanner.next();
            }if (continuar.equalsIgnoreCase("no")) {
                break; // Salir del bucle si el usuario no quiere continuar
            }
        }

        utilidadTotal = totalVentas * porcentajeUtilidad;
        double totalAPagar = sueldoBase + comisionTotal + utilidadTotal;

        System.out.println("\nINFORME DE VENTAS");
        System.out.printf("-----------------------------------------------%n");
        System.out.println("Número total de autos vendidos:| " + contadorVentas);
        System.out.println("Costo total:                   |$" + totalVentas);
        System.out.println("Sueldo mensual:                |$" + sueldoBase);
        System.out.println("Comisión total por autos:      |$" + comisionTotal);
        System.out.println("Comisión total por autos:      |$" + utilidadTotal);
        System.out.printf("-----------------------------------------------%n");
        System.out.println("SUBTOTAL:                      |" );
        System.out.println("$"+sueldoBase+"+"+"$"+comisionTotal+"+"+"$"+utilidadTotal);
        System.out.printf("-----------------------------------------------%n");
        System.out.println("TOTAL MONTO A PAGAR:           |$" + totalAPagar);

        scanner.close();
    }
}