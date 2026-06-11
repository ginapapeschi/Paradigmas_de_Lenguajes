import java.util.ArrayList;

public class ConjuntoPalabras{
    private ArrayList<Palabra> palabras;

    public ConjuntoPalabras(){
        palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra p){
        palabras.add(p);
    }

    public Palabra buscar(String palabra){
        return palabras.stream()
                        .filter(p -> p.getPalabra().equals(palabra))
                        .findFirst()
                        .orElse(null);
    }

    public void incrementa(Palabra p){
        p.incrementar();
    }

    public void mostrar(){
        palabras.stream()
                .forEach(p -> System.out.println(p));
    }

    public void combinar(ConjuntoPalabras otro){
        otro.palabras.stream()
                     .forEach(p -> {
                        Palabra existente = buscar(p.getPalabra());
                        
                        if(existente == null){
                            agregarPalabra(new Palabra(p.getPalabra(), p.getCantVeces()));
                        }else{
                            for(int i = 0; i < p.getCantVeces(); i++){
                                this.incrementa(existente);
                            }
                        }
                     });
    }


}