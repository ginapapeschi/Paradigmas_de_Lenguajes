MiHilo h1 = new MiHilo("Texto1.txt");
MiHilo h2 = new MiHilo("Texto2.txt");

try{
    h1.start();
    h2.start();
    h1.join();
    h2.join();

}catch(InterruptedException e){
    System.out.println("Error esperando hilos");
}

ConjuntoPalabras total = new ConjuntoPalabras();

total.combinar(h1.getConjunto());
total.combinar(h2.getConjunto());

total.mostrar();