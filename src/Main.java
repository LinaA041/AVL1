import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AVL<Integer>  avlThree = new AVL<>();
        int numeroIteracion = sc.nextInt();

        int element;

        StringBuilder msg = new StringBuilder();

        //No implementé el metodo de eliminar, por lo cual, para este caso no se coloca primero el tipo de operación, simplemente
        //se ingresa el elemento a insertar

        for(int i = 0; i < numeroIteracion; i++) {

            element = sc.nextInt();

                avlThree.insert(element);
                msg.append(avlThree.imprimirPorNiveles());

        }
        System.out.println(msg);
    }
}
