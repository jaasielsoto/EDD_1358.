
package Proyecto_EDD1358;

/**
 *
 * @author jaasiel
 */
import java.util.*;

public class PruebaLinked {
public static void main(String args[]) {
    
LinkedList<String> listas = new LinkedList<String>();

//lista 
listas.add("objeto 1");
listas.add("objeto 5");
listas.add("objeto 3");
listas.add("objeto 6");
listas.add("objeto 2");

//imprimiendo lista
System.out.println("lista ligada: " +listas);

//agregando al prinicipio y final de la lista forma FIFO
listas.addFirst("Primer objeto");
listas.addLast("Último objeto");
System.out.println("LinkedList agregando objetos: " +listas);

//tamaño
System.out.println("tamaño : " + listas.size() );



//borrando en primer y último índice
listas.removeFirst();
listas.removeLast();
System.out.println("LinkedList despues de borrae el primer y último item: " +listas);
  
//posición de un item
System.out.println("posición del objeto 2");
listas.indexOf("objeto 2");
listas.set(4, "objeto nuevo");
    System.out.println("actualización");
    System.out.println(listas);
    

//buscando un elemento
if (listas.contains("objeto aleatorio")){
    
System.out.println("El objeto aleatorio está en la lista");
}else{
System.out.println("El objeto aleatorio no se encuentra");
}


//Obtención y recuperacion de items
Object item = listas.get(0);
System.out.println("Primer objeto: " +item);
listas.set(0, "cambiando por el primero");
Object item2 = listas.get(0);
System.out.println("Primer objeto despues de actualizar : " + item2);


//eliminando con un índice
listas.add(0, "Nuevo objeto");
listas.remove(2);
System.out.println("lista: " +listas); 

    
listas.removeAll(listas);
    System.out.println("c vacia");
    listas.add(0, "casi vacía");
    System.out.println(listas.toString());
}

}

