
package EDD_1358;

/**
 *
 * @author jaas
 */
public class TestColaPrioridad {
    public static void main(String[] args) {
        //Este orden no rige como tal a todos los animes es mera aclaración :)
        colasPrioridad colasPrioridad = new colasPrioridad();
        System.out.println("Orden de publicacion de manga");
        colasPrioridad.insertar("Novela Ligera",1);
        colasPrioridad.insertar("Novela Web",0);
        colasPrioridad.insertar("Manga",2);
        colasPrioridad.insertar("Anime",3);
        colasPrioridad.insertar("VideoJuego",4);
        System.out.println(colasPrioridad);
        
    }
}
