public class Prenotazione {
    private int posti=20;
    public int get() { return posti; }
    public synchronized Boolean prenota(int richiesta) {
        if (posti >= richiesta) {
            posti =posti- richiesta;
            return true;
        }
        return false;
    }
}
