import services.ServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ServiceImpl convert = new ServiceImpl();

        System.out.println("#######_Markaziy Bank Valyuta Konvertori_#######");
        System.out.println();

        while (true) {
            System.out.println("1.So'mdan valyutaga konvertatsiya");
            System.out.println("2.Valyutadan so'mga konvertatsiya");
            System.out.println("3.Chiqish");
            System.out.print("=> ");

            int opt1 = scanner.nextInt();

            switch (opt1) {
                case 1:
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("1.So'm dan Dollar ga");
                    System.out.println("2.So'm dan Euro ga");
                    System.out.println("3.So'm dan Yuan ga");
                    System.out.print("=> ");

                    int opt2 = scanner.nextInt();

                    switch (opt2) {
                        case 1:
                            convert.somToDollar();
                            break;
                        case 2:
                            convert.somToEuro();
                            break;
                        case 3:
                            convert.somToYuan();
                            break;
                        default:
                            System.out.println();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Noto'g'ri tanlov !");
                            System.out.println();
                    }

                    break;

                case 2:
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("1.Dollar dan So'm ga");
                    System.out.println("2.Euro dan So'm ga");
                    System.out.println("3.Yuan dan So'm ga");
                    System.out.print("=> ");

                    int opt3 = scanner.nextInt();

                    switch (opt3) {
                        case 1:
                            convert.dollarToSom();
                            break;
                        case 2:
                            convert.euroToSom();
                            break;
                        case 3:
                            convert.yuanToSom();
                            break;
                        default:
                            System.out.println();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Noto'g'ri tanlov !");
                            System.out.println();
                    }

                    break;

                case 3:
                    System.exit(3);
                    break;
                default:
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Noto'g'ri tanlov !");
                    System.out.println();
            }

        }

    }
}
