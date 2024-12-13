import java.util.Scanner;

public class MunicipioDeLoja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int consumo = 0, edad = 0, porcentajeDiscapacidad = 0;
        float valorAgua = 0, impuestoAlcantarillado = 0, tasaBasura = 0.75f, tasaProcesamiento = 0.50f, total = 0;

        System.out.print("Ingrese el consumo de agua en metros cubicos:\n ");
        while (true) {
            if (sc.hasNextInt()) {
                consumo = sc.nextInt();
                if (consumo < 1) System.out.println("Ingrese un numero entero positivo");
                else break;
            } else {
                System.out.println("Ingrese un numero entero");
                sc.next();
            }
        }

        System.out.print("Ingrese su edad:\n ");
        while (true) {
            if (sc.hasNextInt()) {
                edad = sc.nextInt();
                if (edad < 0) System.out.println("Ingrese una edad correcta");
                else break;
            } else {
                System.out.println("Ingrese un numero entero");
                sc.next();
            }
        }

        int terceraEdad = (edad >= 65) ? 1 : 0;
        int discapacidad = 0;
        String respuestaDiscapacidad;

        while (true) {
            System.out.print("Tiene alguna discapacidad :\n  ");
            respuestaDiscapacidad = sc.next();
            if (respuestaDiscapacidad.equalsIgnoreCase("si")) {
                discapacidad = 1;
                break;
            } else if (respuestaDiscapacidad.equalsIgnoreCase("no")) break;
            else System.out.println("Ingrese 'si' o 'no'");
        }

        if (discapacidad == 1) {
            System.out.print("Ingrese el porcentaje de discapacidad:\n  ");
            while (true) {
                if (sc.hasNextInt()) {
                    porcentajeDiscapacidad = sc.nextInt();
                    if (porcentajeDiscapacidad < 0) System.out.println("Ingrese un numero positivo");
                    else break;
                } else {
                    System.out.println("Ingrese un numero entero");
                    sc.next();
                }
            }
        }

        float[] limites = {15, 25, 40, 60};
        float[] tarifas = {3.0f, 0.1f, 0.2f, 0.3f, 0.35f};
        valorAgua = 3.0f;

        for (int i = 0; i < limites.length; i++) {
            if (consumo > limites[i]) {
                valorAgua += (i == 0) ? (limites[i] - 0) * tarifas[i + 1] : (limites[i] - limites[i - 1]) * tarifas[i + 1];
            } else {
                valorAgua += (consumo - (i == 0 ? 0 : limites[i - 1])) * tarifas[i + 1];
                break;
            }
        }

        if (terceraEdad == 1) valorAgua *= (consumo <= 15) ? 0.50f : 0.70f;
        if (discapacidad == 1 && porcentajeDiscapacidad > 0) valorAgua -= valorAgua * (porcentajeDiscapacidad / 100.0f);

        impuestoAlcantarillado = valorAgua * 0.35f;
        total = valorAgua + impuestoAlcantarillado + tasaBasura + tasaProcesamiento;

        System.out.printf("INFORME COSTOS TOTAL $%.2f%n", total);
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("El costo del agua potable     |: $%.2f%n", valorAgua);
        System.out.printf("El impuesto de alcantarillado |: $%.2f%n", impuestoAlcantarillado);
        System.out.printf("El valor por recolección      |: $%.2f%n", tasaBasura);
        System.out.printf("El valor por procesamiento    |: $%.2f%n", tasaProcesamiento);
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("SUBTOTAL:                     |:\n ");
        System.out.printf(valorAgua+"+" +impuestoAlcantarillado +"+"+ tasaBasura +"+"+ tasaProcesamiento+"\n");
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("Total a pagar                 |: $%.2f%n", total);
    }
}