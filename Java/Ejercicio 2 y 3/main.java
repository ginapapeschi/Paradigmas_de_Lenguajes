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
                case 1: 
                        System.out.print("Ingrese número: ");
                        int num = sc.nextInt();

                        System.out.print("Ingrese DNI: ");
                        String dni = sc.next();

                        System.out.print("Ingrese nombre: ");
                        String nom = sc.next();

                        System.out.print("Ingrese apellido: ");
                        String ap = sc.next();

                        System.out.print("Ingrese cantidad de millas: ");
                        int m = sc.nextInt();
                        
                        gestor.cargarViajero(num, dni, nom, ap, m);
                        break;

                case 2: 
                        System.out.print("\nIngrese el número: ");
                        int num = sc.nextInt();
                        gestor.mostrarViajero(num);
                        break;

                case 3: 
                        System.out.print("\nIngrese el número de DNI: ");
                        String dni = sc.next();

                        try{
                            int millas = gestor.consultarCantMillas(dni);
                            System.out.println("\nCantidad de millas: " + millas);
                                
                        }catch (ViajeroNoEncontradoException e){
                            System.out.println(e.getMessage());
                        }

                        break;

                case 4: 
                        System.out.print("\nIngrese el número de DNI: ");
                        String dni = sc.next();

                        System.out.print("Ingrese la cantidad de millas: ");
                        int m = sc.nextInt();

                        try{
                            int cantMillas4 = gestor.acumularMillas(dni, m);
                            System.out.println("\nMillas acumuladas: " + cantMillas4);
                            
                        }catch (ViajeroNoEncontradoException e){
                            System.out.println(e.getMessage());
                        }

                        break;

                case 5: 
                        System.out.print("\nIngrese el número de DNI: ");
                        String dni = sc.next();

                        System.out.print("Ingrese la cantidad de millas: ");
                        int m = sc.nextInt();

                        try{
                            int cantMillas5 = gestor.canjearMillas(dni, m);
                            System.out.println("\nMillas restantes: " + cantMillas5);
                        
                        }catch (ViajeroNoEncontradoException e){
                            System.out.println(e.getMessage());
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