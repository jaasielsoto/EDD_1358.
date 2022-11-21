package EDD_1358;


/**
 *
 * @author jaas
 */
public class Nodo {
    private int valor;
    private Nodo siguiente;
    
    public void Nodo(){
        this.valor=0;
        this.siguiente=null;
    }
    public int getValor(){
        return valor;
    }
    public void setValor(){
        this.valor=valor;
    }
    public Nodo getSiguiente(){
        return siguiente;
            }
    public void setSiguiente(Nodo siguiente){
        this.siguiente= siguiente;
    }
}
