/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD_1358;

/**
 *
 * @author jaas
 */
public class Lista {
    public static void main(String[] args) {
        Alumno al1 = new Alumno("1160650", "Juan", "DER", 9.0);
        Alumno al2 = new Alumno("1156484", "Laura", "ICO", 8.0);
        Alumno al3 = new Alumno("1116308", "Jesus", "PER", 8.0);
        System.out.println(al1);
        
        ArregloADT lista = new ArregloADT(4);
        lista.setElemento(0, al1);
        lista.setElemento(2, al2);
        lista.setElemento(3, al3);
        System.out.println(lista);
    }
}
