import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AVL<Integer>  avlThree = new AVL<>();


        int numeroIteracciones = sc.nextInt();

        int element;
         String msg = "";
        for(int i = 0; i < numeroIteracciones; i++) {

            element = sc.nextInt();

                avlThree.insert(element);

                avlThree.imprimirPorNiveles();

        }
        avlThree.imprimirPorNiveles();
    }
}
