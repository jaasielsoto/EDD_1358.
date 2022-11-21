
package EDD_1358;

/**
 *
 * @author jaas
 */
public class colasPrioridad <T> {
    class Celda{
        T elemento;
        int prioridad;
        Celda sig;

        @Override
        public String toString() {
            return "|"+elemento+"|->";
        }
        public String pintAll(){
            return "[Datos ="+elemento+"] -> [siguiente : "+this.sig+"]"; 
            }             
    }
    private Celda cola;
    
    public colasPrioridad(){
        cola = new Celda();
        cola.sig = null;
    }
    public boolean vacia(){
        return (cola.sig==null);
    }
    public int primero() throws Exception{
        if(vacia()) throw new Exception();
                Celda aux;
                aux = cola;
                cola= cola.sig;
                return (int) aux.sig.elemento;
        }
    public int primero_prioridad() throws Exception{
        if(vacia()) throw new Exception();
        return cola.sig.prioridad;
    }
    
    /**
    *ordenar por prioridad 
    */
    public void insertar(T elemento, int prioridad){
        Celda p,q;
        boolean encontrado = false;
        p = cola;
        while((p.sig!=null)&&(!encontrado)){
            if(p.sig.prioridad>prioridad)
                encontrado = true;
            else p= p.sig;
        }
             q = p.sig;
             p.sig = new Celda();
             p=p.sig;
             p.elemento = elemento;
             p.prioridad = prioridad;
             p.sig=p;
    }
public void supreme()throws Exception{
    if (vacia())throw new Exception();
    cola = cola.sig;
}

    @Override
    public String toString() {
        String lista = "";
        Celda aux = cola;
        aux = aux.sig;
        while(aux !=null){
            lista = lista + aux.toString();
            aux = aux.sig;
        }
        return lista;
    }

}
