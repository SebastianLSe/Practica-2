import java.util.Scanner;

public class Secuencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Que numero necesita\n: ");
        int n = scanner.nextInt();

        if (n > 1000) {
            System.out.println("Numero muy alto");
            return;
        }

        int X = 1, Y = 1, p = 1, e = 2;
        String resultado = "";

        for (int i = 1; i <= n; i++) {
            int numerador = (i % 4 == 0 || i % 4 == 3) ? -X : X;
            int denominador = (int) Math.pow(p, e);

            resultado += (i == 1 ? "" : "\n" + (numerador > 0 ? "+" : "-")) + "[" + (numerador < 0 ? -numerador : numerador) + "/" + denominador + "^" + e + "]";

            int temp = X;
            X = Y;
            Y = temp + Y;
            p += 2;
            e += 2;
        }

        System.out.println("RESULTADO: \n" + resultado);
        scanner.close();
    }
}