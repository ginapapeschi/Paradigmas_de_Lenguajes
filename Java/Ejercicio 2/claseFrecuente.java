public class Frecuente{

    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int millas;

/* Constructor */
    public Frecuente(int num, String dni, String nom, String ap, int m){
        this.numero = num;
        this.dni = dni;
        this.nombre = nom;
        this.apellido = ap;
        this.millas = m;
    }

/* Getters y Setters */
    public int getNumero(){
        return numero;
    }

    public String getDNI(){
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getMillas(){
        return millas;
    }

    public void setNumero(int num){
        this.numero = num;
    }

    public void setDNI(String dni){
        this.dni = dni;
    }

    public void setNombre(String nom){
        this.nombre = nom;
    }

    public void setApellido(String ap){
        this.apellido = ap;
    }

    public void setMillas(int m){
        this.millas = m;
    }

/* C */
    public int acumularMillas(int cantMillasRecorridas){
        this.setMillas(this.getMillas() + cantMillasRecorridas);
        return this.getMillas();
    }

    public int canjearMillas(int cantMillasACanjear){
        int resultado = -2;

        if (cantMillasACanjear <= this.getMillas()){
            this.setMillas(this.getMillas() - cantMillasACanjear);
            resultado = this.getMillas();
        } else {
            System.out.println("Error - La cantidad de millas a canjear supera a las millas acumuladas");
        }

        return resultado;
    }

@Override
    public String toString(){
        return
            "Número: " + numero +
            "\nDNI: " + dni +
            "\nNombre: " + nombre +
            "\nApellido: " + apellido +
            "\nMillas: " + millas;
    }

}