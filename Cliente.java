public class Cliente extends Thread {
    private GestioneEventi p;
    private int richiesta;
    private int numero;
    private String evento;

    public Cliente(GestioneEventi X,int r,int n,String e){
        this.p=X;
        this.richiesta=r;
        this.evento=e;
        this.numero=n;
    }
    public void run() {
        var res = p.prenota(this.richiesta,this.evento); 
        if (res) {
            System.out.println(this.numero+"   "+res+ " Prenotazione di : " + richiesta + " Posti a : "+this.evento+", posti disponibili: "+ p.PostiDisponibili(this.evento));
        }
        else {
            System.out.println(this.numero+"   "+res + "  NO Prenotazione di : " + richiesta + " Posti a:"+ this.evento+",posti disponibili: "+ p.PostiDisponibili(this.evento));
        }

    }

}