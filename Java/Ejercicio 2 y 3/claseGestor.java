import java.util.ArrayList;
import java.util.List;

public class Gestor{
    private List<Frecuente> viajeros;
    
    public Gestor(){
        viajeros = new ArrayList<>();
    }

/* Método auxiliar para buscar por DNI */
    private Frecuente buscarPorDNI(String dni) throws ViajeroNoEncontradoException{
        int i = 0;

        while(i < viajeros.size()){
            if(viajeros.get(i).getDNI().equals(dni)){
                return viajeros.get(i);
            }
            i++;
        }
        throw new ViajeroNoEncontradoException("Error - No existe un viajero con el DNI ingresado");
    }

/* 1) Cargar viajero */
    public void cargarViajero(int num, String dni, String nom, String ap, int m){
    /* Manejo de excepciones */
        try{
            buscarPorDNI(dni);
            throw new ViajeroDuplicadoException("\nError - Ya existe un viajero con ese DNI");
        
        }catch (ViajeroNoEncontradoException e){
            viajeros.add(new Frecuente(num, dni, nom, ap, m));
            System.out.println("\n¡Viajero cargado correctamente!");

        }
    }

/* 2) Mostrar viajero */
    public void mostrarViajero(int num){        
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
    public int consultarCantMillas(String dni) throws ViajeroNoEncontradoException{
        Frecuente viajero = buscarPorDNI(dni);
        return viajero.getMillas();
    }

/*4) Acumular millas */
    public int acumularMillas(String dni, int cantMillas) throws ViajeroNoEncontradoException{
        Frecuente viajero = buscarPorDNI(dni);
        return viajero.acumularMillas(cantMillas);
    }

/*5) Canjear millas */
    public int canjearMillas(String dni, int cantMillas) throws ViajeroNoEncontradoException{
        Frecuente viajero = buscarPorDNI(dni);
        return viajero.canjearMillas(cantMillas);
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