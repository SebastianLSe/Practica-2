import java.util.Scanner;

public class MenuPrincipal {
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

    int op=0;

    do {
        System.out.println("MENU PRINCIPAL");
        System.out.println("------------------------");
        System.out.println("1-InformeVentas");
        System.out.println("2-CostoLlada");
        System.out.println("3-MunicipioDeLoja");
        System.out.println("4-Secuencia");
        System.out.println("5-Salir");
        System.out.println("------------------------");
        System.out.println("Digite una opcion\n");
        op = sc.nextInt();
        switch (op) {
            case 1:
                InformeVentas.main(null);

                break;
            case 2:

                CostoLlamadas.main(null);
                break;
            case 3:

                MunicipioDeLoja.main(null);
                break;
            case 4:
                Secuencia.main(null);

                break;
            case 5:
             break;


        }
    }while (op!=5);

}
}