public class Cliente extends Thread {
    private Prenotazione p;
    private int richiesta;

    public Cliente(Prenotazione X,int r){
        this.p=X;
        this.richiesta=r;
    }
    public  synchronized void run() {
        if (p.prenota(this.richiesta)) {
            System.out.println(p.prenota(richiesta) + "Prenotazione di : " + richiesta + " Posti ");
            System.out.println("posti disponibili: "+p.get());

        }
        else {
            System.out.println(p.prenota(richiesta) + "  NO Prenotazione di : " + richiesta + " Posti ");
            System.out.println("posti disponibili: "+p.get());

        }

    }

}