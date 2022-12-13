package Proyecto_EDD1358;

/**
 *
 * @author jaasiel
 */
import java.util.Stack;

public class PruebaStack {
    public static void main(String[] args) {
        
    Stack<String> pila= new Stack<>();
   

        // añadir
        pila.push("Carro");
        pila.push("Pollo");
        pila.push("Cargador");
        pila.push("Pelicano");
        pila.push("Chilakiles");
        pila.push("Calaca");
        pila.push("Goya");
        
        //to string
        System.out.println("imprimir pila: " + pila);

        // eliminar
        String item = pila.pop();
        System.out.println("objeto eliminado: " + item);
        System.out.println("limite: " + pila.capacity());
      
        //peek
        System.out.println("operación peek");
        System.out.println(pila.peek());
        
        //buscar
        if (pila.contains("pollo")) {
            System.out.println("la pila contiene \"pollo\" ");
            
        }else{
        System.out.println("la pila no contiene \"pollo\" ");
        }
        
            //operaciones variadas
        System.out.println("primer objeto");
        System.out.println(pila.firstElement());
        System.out.println("último objeto");
        System.out.println(pila.lastElement());
        System.out.println(pila.toString());
        pila.clear();
        if (pila.isEmpty()) {
            System.out.println("ta vacio");
        }
        }   
}

