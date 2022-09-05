
package EDD_1358;

/**
 *
 * @author jaas
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class trabajadorADT{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] Matriz = CONVERTIR("C:/Usuarios/jaas/descargas/junio.dat");

        if (Matriz != null) { 

            System.out.println("Archivo leído");

            for (int fila = 0; fila < Matriz[fila].length; fila++) {

                if (Matriz[fila][0] != null) { 
                    for (int columna = 0; columna < Matriz[columna].length; columna++) {
                        System.out.print(Matriz[fila][columna] + " ");

                    }

                    System.out.println();

                }

            }

        } else {

            System.out.println("Error");
        }
        ArrayList<Trabajador> Trabajadores = new ArrayList();
        Object object = new Object();
        for (int i = 1; i < Matriz.length; i++) {
            if (Matriz[i][0]==null) {
break;                
            }
            Trabajadores.add(new Trabajador(Integer.parseInt(Matriz[i][0]),Matriz[i][1], Matriz[i][2],Matriz[i][3],Integer.parseInt(Matriz[i][4]),Double.parseDouble(Matriz[i][5]),Integer.parseInt(Matriz[i][6])));
            }
        System.out.println("\n\n\n\n");
        System.out.println("salarios");
        for (Trabajador item: Trabajadores) {
            System.out.println(item);
}
        System.out.println("\n\n\n\n");
        System.out.println("");
        System.out.println("");
        System.out.println("salario con horas extras");
        for (Trabajador item: Trabajadores) {
            ((Trabajador)item).sueldo();
            System.out.println(item);
}
Trabajador.Antigueda(Trabajadores);
        System.out.println("\n\n\n\n");
System.out.println("bono");
        for (Trabajador item: Trabajadores) {
          
            System.out.println(item);
}
    }

    private static String[][] CONVERTIR(String rutaCSV) {

        try {

            Scanner lector = new Scanner(new File(rutaCSV));

            String[][] matriz = new String[95][95];

            int fil = 0;

            String linea = lector.nextLine();

            while (lector.hasNextLine()) {

                if (matriz[fil].toString().endsWith(",")) {
                    fil++;
                } else {
                    matriz[fil] = linea.split(","); 

                }

                fil++; 

                linea = lector.nextLine(); 
            }

            matriz[fil] = linea.split(",");
            lector.close();

            return matriz;

        } catch (FileNotFoundException e) {

            System.out.println("la ruta: " + rutaCSV + "no se encuentra");

            return null;

        }

    }

}