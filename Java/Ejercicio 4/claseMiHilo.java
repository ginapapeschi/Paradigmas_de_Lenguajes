import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MiHilo extends Thread{
    private String rutaArchivo;
    private ConjuntoPalabras conjunto;

    public MiHilo(String ruta){
        this.rutaArchivo =  ruta;
        this.conjunto = new ConjuntoPalabras();
    }

    public ConjuntoPalabras getConjunto(){
        return this.conjunto;
    }

    public String limpiarSignos(String texto){
        return texto.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ ]", "");
    }

    public String[] limpiarStopWords(String[] texto){
        String[] stopWords = {
            "el", "la", "los", "las",
            "un", "una", "unos", "unas",
            "y", "o", "de", "del",
            "en", "a", "por", "para",
            "con", "que", "es"
        };

        return Arrays.stream(texto)
                     .filter(p -> !Arrays.asList(stopWords).contains(p))
                     .toArray(String[]::new);
    }

    @Override
    public void run(){
        try(BufferedReader br = new BufferedReader(new FileReader(this.rutaArchivo))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] palabras = limpiarStopWords(limpiarSignos(linea)
                                    .toLowerCase()
                                    .split(" ")
                );

                Arrays.stream(palabras)
                        .filter(p -> !p.isEmpty())
                        .forEach(p -> {
                            Palabra palabra = conjunto.buscar(p);
                            if(palabra == null){
                                conjunto.agregarPalabra(new Palabra(p));
                            }else{
                                conjunto.incrementa(palabra);
                            }
                        });
            }
        
        }catch(IOException e){
            System.out.println("\nError leyendo archivo: " + this.rutaArchivo);
        }
    }
}