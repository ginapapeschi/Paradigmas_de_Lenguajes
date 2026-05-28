import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestor{
    private List<Frecuente> viajeros;
    
    public Gestor(){
        viajeros = new ArrayList<>();
    }

/* 1) Cargar viajero */
    public void cargarViajero(){

        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("Ingrese número: ");
        int num = sc.nextInt();

        System.out.print("Ingrese DNI: ");
        String dni = sc.next();

        System.out.print("Ingrese nombre: ");
        String nom = sc.next();

        System.out.print("Ingrese apellido: ");
        String ap = sc.next();

        System.out.print("Ingrese cantidad de millas: ");
        int millas = sc.nextInt();

        viajeros.add(new Frecuente(num, dni, nom, ap, millas));
        System.out.println();
        System.out.println("¡Viajero cargado correctamente!");
    }

/* 2) Mostrar viajero */
    public void mostrarViajero(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el número: ");
        int num = sc.nextInt();
        
        int i = 0;
        boolean encontrado = false;

        while((i < viajeros.size()) && (!encontrado)){
            if(viajeros.get(i).getNumero() == num){
                System.out.println(viajeros.get(i));
                encontrado = true;
            } else {
                i++;
            }
        }

        if(!encontrado){
            System.out.println("\nError - Viajero no encontrado");
        }
    }

/* 3) Consultar cantidad de millas */
    public int consultarCantMillas(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el número de DNI: ");
        String dni = sc.next();

        int i = 0;
        int millas = -1;

        while((i < viajeros.size()) && (millas == -1)){
            if(viajeros.get(i).getDNI().equals(dni)){
                millas = viajeros.get(i).getMillas();

            }else{
                i++;
            }
        }

        return millas;
    }

/*4) Acumular millas */
    public int acumularMillas(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el número de DNI: ");
        String dni = sc.next();

        System.out.println("Ingrese la cantidad de millas: ");
        int cantMillas = sc.nextInt();

        int i = 0;
        int resultado = -1;

        while(i < viajeros.size() && (resultado == -1)){
            if(viajeros.get(i).getDNI().equals(dni)){
                resultado = viajeros.get(i).acumularMillas(cantMillas);
            }else{
                i++;
            }
        }
        
        return resultado;
    }

/*5) Canjear millas */
    public int canjearMillas(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el número de DNI: ");
        String dni = sc.next();

        System.out.println("\nIngrese la cantidad de millas: ");
        int cantMillas = sc.nextInt();

        int i = 0;
        int resultado = -1;

        while((i < viajeros.size()) && (resultado == -1)){
            if(viajeros.get(i).getDNI().equals(dni)){
                resultado = viajeros.get(i).canjearMillas(cantMillas);
            }else{
                i++;
            }
        }
        return resultado;
    }

/*6) Mejor viajero */
    public void mejorViajero(){
        List<Frecuente> mejores = new ArrayList<>();
        int maxMillas = -1;
        
        for(Frecuente v : viajeros){
            if(v.getMillas() > maxMillas){
                maxMillas = v.getMillas();
                mejores.clear();
                mejores.add(v);
            
            }else if(v.getMillas() == maxMillas){
                mejores.add(v);
            }
        }

        System.out.println("\n=== Mejor/es viajero/s ===");

        for(Frecuente m : mejores){
                System.out.println(m);
            
        }
    }
}