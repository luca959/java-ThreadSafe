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
        try 
        {           
            p.Crea(this.nome_evento,this.num_posti);
            Thread.sleep(2000);
        } 
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        try 
        {
            p.Aggiungi(this.nome_evento,this.num_posti);
            Thread.sleep(2000);
        } 
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        try 
        {
            p.Chiudi("Piscina");
            Thread.sleep(2000);
        } 
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }


    


    }

}