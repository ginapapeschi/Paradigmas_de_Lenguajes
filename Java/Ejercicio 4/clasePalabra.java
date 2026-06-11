public class Palabra{
    private String palabra;
    private int cantVeces;

    public Palabra(String p){
        this.palabra = p;
        this.cantVeces = 1;
    }

    public Palabra(String p, int cantidad){
        this.palabra = p;
        this.cantVeces = cantidad;
    }

    public String getPalabra(){
        return this.palabra;
    }

    public int getCantVeces(){
        return this.cantVeces;
    }

    public void incrementar(){
        this.cantVeces++;
    }

    public String toString(){
        return "\nPalabra: " + this.palabra +
                "\nCantidad: " + this.cantVeces;
    }
}