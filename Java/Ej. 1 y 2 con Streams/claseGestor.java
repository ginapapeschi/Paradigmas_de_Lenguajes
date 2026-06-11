import java.util.ArrayList;
import java.util.List;

public class Gestor{
    private List<Frecuente> viajeros;
    
    public Gestor(){
        viajeros = new ArrayList<>();
    }

/* Método auxiliar para buscar por DNI */
    private Frecuente buscarPorDNI(String dni) throws ViajeroNoEncontradoException{
        return viajeros.stream()
                .filter(v -> v.getDNI().equals(dni))
                .findFirst()
                .orElseThrow(() -> new ViajeroNoEncontradoException("Error - No existe un viajero con el DNI ingresado")
                );
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
        viajeros.stream()
                .filter(v -> v.getNumero() == num)
                .findFirst()
                .ifPresentOrElse(v -> System.out.println(v),
                                () -> System.out.println("\nError - Viajero no encontrado")
                );
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
        int maxMillas = viajeros.stream()
                        .mapToInt(v -> v.getMillas())
                        .max()
                        .orElse(-1);

        System.out.println("\n=== Mejor/es viajero/s ===");

        viajeros.stream()
                .filter(v -> v.getMillas() == maxMillas)
                .forEach(v -> System.out.println(v));
    }
}