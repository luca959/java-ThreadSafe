public class Main {
    public static void main(String[] args) throws
            InterruptedException {
        GestioneEventi P=new GestioneEventi(); // oggetto condiviso
        Admin a1=new Admin(P,10,"Cinema");
        Admin a2=new Admin(P,50,"Teatro");
        Admin a3=new Admin(P,50,"Stadio");
        Admin a4=new Admin(P,50,"Piscina");

        Cliente t1=new Cliente(P,3,1,"Teatro");
        Cliente t2=new Cliente(P,10,2,"Cinema");
        Cliente t3=new Cliente(P,5,3,"Stadio");

        a1.start();
        a2.start();
        a3.start();
        a4.start();

        t1.start();
        t2.start();
        t3.start();
    
        a1.join();
        a2.join();
        a3.join();
        a4.join();

        t1.join();
        t2.join();
        t3.join();
        P.ListaEventi();


    }
}
