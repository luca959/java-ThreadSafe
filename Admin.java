public class Admin  extends Thread {
    private GestioneEventi p;
    private int num_posti;
    private String nome_evento;
    public Admin(GestioneEventi Eventi,int x,String y){
        this.p=Eventi;
        this.num_posti=x;
        this.nome_evento=y;
    }

    public void run() {
        //esegue la sequenza Crea, pausa, Aggiungi, pausa, Chiudi per diversi 
        p.Crea(this.nome_evento,this.num_posti);
        try 
        {
            Thread.sleep(2000);
        } 
        catch(InterruptedException e)
        {
             // this part is executed when an exception (in this example InterruptedException) occurs
        }
        p.Aggiungi(this.nome_evento,this.num_posti);
        try 
        {
            Thread.sleep(2000);
        } 
        catch(InterruptedException e)
        {
             // this part is executed when an exception (in this example InterruptedException) occurs
        }
        System.out.println("Cinema: "+  p.PostiDisponibili("Cinema")+" Teatro "+p.PostiDisponibili("Teatro")+" Stadio: "+ p.PostiDisponibili("Stadio"));
    


    }

}