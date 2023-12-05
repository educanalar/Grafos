import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo= new Grafo();

        String bob, alice, rob, maria, mark, borrar;

        System.out.println("Primer nombre: ");
        bob = scanner.nextLine();
        System.out.println("Segundo nombre: ");
        alice = scanner.nextLine();
        System.out.println("Tercer nombre: ");
        rob = scanner.nextLine();
        System.out.println("Cuarto nombre: ");
        maria = scanner.nextLine();
        System.out.println("Quinto nombre; ");
        mark = scanner.nextLine();

        grafo.agregarVertice(bob);
        grafo.agregarVertice(alice);
        grafo.agregarVertice(rob);
        grafo.agregarVertice(maria);
        grafo.agregarVertice(mark);

        grafo.agregarArista(bob,alice);
        grafo.agregarArista(bob,rob);
        grafo.agregarArista(alice,mark);
        grafo.agregarArista(alice,maria);
        grafo.agregarArista(mark,rob);
        grafo.agregarArista(rob,maria);

        System.out.println("Relacion entre los nombres agregados: ");
        grafo.imprimirGrafoComoListaAdyacente();

        System.out.println("Que nombre desea eliminar: ");
        borrar= scanner.nextLine();
        grafo.eliminarVertice(borrar);
        grafo.eliminarArista(bob,alice);
        grafo.eliminarArista(bob,rob);

        System.out.println("Relacion entre los nombres agregados: ");
        grafo.imprimirGrafoComoListaAdyacente();
    }

}