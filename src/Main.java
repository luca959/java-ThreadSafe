public class Main {
    public static void main(String[] args) throws
            InterruptedException {
        Prenotazione P=new Prenotazione(); // oggetto condiviso
        Cliente t1=new Cliente(P,3);
        Cliente t2=new Cliente(P,10);
        Cliente t3=new Cliente(P,5);
        Cliente t4=new Cliente(P,2);
        Cliente t5=new Cliente(P,4);
        Cliente t6=new Cliente(P,2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        System.out.println("Posti : "+P.get());
    }
}
