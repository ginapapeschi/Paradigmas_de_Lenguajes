import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        while(opcion != 7){
            System.out.println("=== MENÚ ===");
            System.out.println("1 - Cargar viajero");
            System.out.println("2 - Mostrar viajero");
            System.out.println("3 - Consultar cantidad de millas");
            System.out.println("4 - Acumular millas");
            System.out.println("5 - Canjear millas");
            System.out.println("6 - Mejor viajero");
            System.out.println("7 - Salir");

            System.out.print("\nSu opción -> ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1: gestor.cargarViajero();
                        break;

                case 2: gestor.mostrarViajero();
                        break;

                case 3: int millas = gestor.consultarCantMillas();
                        if(millas == -1){
                            System.out.println("\nError - No se encontró el viajero con el DNI ingresado");
                        }else{
                            System.out.println("\nCantidad de millas: " + millas);
                        }
                        break;

                case 4: int cantMillas = gestor.acumularMillas();
                        if(cantMillas == -1){
                            System.out.println("\nError - No se encontró el viajero con el DNI ingresado");
                        }else{
                            System.out.println("\nMillas acumuladas: " + cantMillas);
                        }
                        break;

                case 5: int cantMillas = gestor.canjearMillas();
                        if(cantMillas == -1){
                            System.out.println("\nError - No se encontró el viajero con el DNI ingresado");
                        }else{
                            if(cantMillas >= 0){
                                System.out.println("\nMillas restantes: " + cantMillas);
                            }
                        }
                        break;

                case 6: gestor.mejorViajero();
                        break;

                case 7: System.out.println("\nSaliendo del programa...");
                        break;
                default:
                System.out.println();
                System.out.println("Error - Opción inválida");
            }
            System.out.println();
        }
        sc.close();
    }
}

/* 

=== MEJORAS Y ACLARACIONES ===

- Puede pasarse el scanner por parámetros para evitar abrirlo en cada función que lo necesite. Por ejemplo, gestor.cargarViajero(sc); y se recibe como public void cargarViajero(Scanner sc){}.

- Otra forma puede ser que el main lea todos los datos, y se los pasen por parámetros a las funciones directamente, en lugar del scanner.

- El método toString() en Java es muy parecido a __str__() en Python. @Override permite sobreescribir un MÉTODO HEREDADO (polimorfismo).

*/