
package Proyecto_EDD1358;

/**
 *
 * @author jaasiel  
 */
import java.util.*;
public class TestLista{ 
public static void main(String args[]) {
//Crea un lista
ArrayList<String> list = new ArrayList<String>();           

// Agrega items a la lista
list.add("elemento 1"); 
list.add("elemento 2"); 
list.add(2, "elemento");//este item esta en la posicion 2
list.add("elemento 4");

//  to string
System.out.println("contiene los siguientes elementos:"+ list);

// usando iterator
Iterator<String> iter=list.iterator();
while (iter.hasNext()){
    System.out.println(iter.next());
}

//limpiando el arraylist
list.clear();
System.out.println("despues del clean quedan: " + list);

//llenando la lista
list.add("elementoN 1");
list.add("elementoN 2");
list.add("elementoN 4");
//añadiendo en posición específica
list.add(2, "elementoN 3");
list.add("elementoN 2");

// El último indice de un item
int ultimo = list.lastIndexOf("elementoN 2");
System.out.println("El valor índice elementoN 2 es: " + ultimo);

// corroborar que no este vacia 
boolean check = list.isEmpty();
System.out.println("¿Está vacío el array: " + check);

//Obtiene el indice de un item
int pos = list.indexOf("elementoN 2");
System.out.println("El índice del elementoN 2 es: " + pos);
       

// buscando un ite,
boolean element = list.contains("elementoN 5");
System.out.println("Checa si un item esta en la list elementoN 5: " + element);

// Obtener un item con un índice
String item = list.get(0);
System.out.println("El item en el índice 0 es: " + item);


// Borrando el item 0
list.remove(0);

// Borraando el item3
list.remove("elementoN 3");
// Borrando el índice 2
list.remove(2);


System.out.println("El arraylist tiene los siguintes items: " + list);
    System.out.println("el tamaño del arraylist es");
    System.out.println(list.size());
}

}
   

