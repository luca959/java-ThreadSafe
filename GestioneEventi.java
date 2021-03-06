import java.util.concurrent.ConcurrentHashMap;
public class GestioneEventi{

    private ConcurrentHashMap<String, Integer> Eventi;

    public GestioneEventi(){
        Eventi=new ConcurrentHashMap<>();

    }

    public void Crea(String x, int y){
        Eventi.putIfAbsent(x,y);
        System.out.println(x+" "+y+" Aggiunti");
    }

    public synchronized void Aggiungi(String x, int y){
        if (Eventi.get(x) != null){
            Eventi.computeIfPresent(x, (key, oldValue) -> oldValue+y);
            notifyAll();
        }
        System.out.println(x+" "+Eventi.get(x)+" Modificati");

    }
    public synchronized Boolean prenota(int richiesta,String NomeEvento) {
        if(Eventi.get(NomeEvento)!=null){
            int posti=Eventi.get(NomeEvento);
            while(!(posti >= richiesta)){
                try { wait(); } catch(InterruptedException e){}
                posti=Eventi.get(NomeEvento);

            }
            if(posti >= richiesta){
                posti -= richiesta;
                Eventi.replace(NomeEvento,posti);
                return true;
            }
                return false;
            }
            return false;
    }
    
    public void ListaEventi(){
                // Using keySet()
                System.out.println("Keys: " + Eventi.keySet());
                // Using values()
                System.out.println("Values: " + Eventi.values());
    }
    public int PostiDisponibili(String x){
        int posti=Eventi.get(x);
        return posti;
    }
    public void Chiudi(String x){
        if(Eventi.get(x) != null){
            int value=Eventi.get(x);
            Eventi.remove(x,value);
            System.out.println("Evento rimosso con successo");
        }

    }
}