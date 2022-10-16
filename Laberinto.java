package EDD_1358;

/**
 *
 * @author jaas
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Laberinto {
final static char C =' ', X ='x', S ='s', E='e', V='.';

final static int START_I=0, START_J=0;
final static int END_I=9,END_J=9;

private static final char[][] laberinto={
        {S, X, X, X, X, X, X, X, X, X},
        {C, C, C, C, C, C, C, C, C, X},
        {X, C, C, C, X, C, X, X, C, X},
        {X, C, X, X, X, C, X, X, C, X},
        {X, C, C, C, C, X, X, X, C, X},
        {X, X, X, X, C, X, X, C, C, C},
        {X, X, X, X, C, X, C, C, X, C},
        {X, X, C, X, C, X, X, C, X, C},
        {X, X, C, C, C, C, C, C, X, C},
        {X, X, X, X, X, X, C, X, C, E}};
        Scanner sc = new Scanner(System.in);
public int tamLaberinto(){
    return laberinto.length;
}

public void imprimir(){
    for(int i=0; i <tamLaberinto();i++){
       for(int j=0;j< tamLaberinto();j++){
        System.out.print(laberinto[i][j]);
        System.out.print(' ');
        }
     System.out.println();
    }
}

 public char marcar(int i, int j, char valor){
     assert((isInMaze(i, j)));
     char tmp = laberinto[i][j];
     laberinto[i][j]= valor;
     return tmp;
 }
 public char marcar(MazePos pos, char value) {
        return marcar(pos.i(), pos.j(), value);
    }

    public boolean isMarked(int i, int j) {
        assert (isInMaze(i, j));
        return (laberinto[i][j] == V);
    }

    public boolean isMarked(MazePos pos) {
        return isMarked(pos.i(), pos.j());
    }

    public boolean limpiar(int i, int j) {
        assert (isInMaze(i, j));
        return (laberinto[i][j] != X && laberinto[i][j] != V);
    }

    public boolean limpiar(MazePos pos) {
        return limpiar(pos.i(), pos.j());
    }

    //true if cell is within maze 
    public boolean isInMaze(int i, int j) {
        if (i >= 0 && i < tamLaberinto() && j >= 0 && j < tamLaberinto()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInMaze(MazePos pos) {
        return isInMaze(pos.i(), pos.j());
    }

    public boolean Final(int i, int j) {
        return (i == Laberinto.END_I && j == Laberinto.END_J);
    }

    public boolean Final(MazePos pos) {
        return Final(pos.i(), pos.j());
    }

    @Override
    public char[][] clone() {

        char[][] mazeCopy = new char[tamLaberinto()][tamLaberinto()];
        for (int i = 0; i < tamLaberinto(); i++) {
            System.arraycopy(laberinto[i], 0, mazeCopy[i], 0, tamLaberinto());
        }
        return mazeCopy;
    }

    public void restaurar(char[][] savedMaze) {
        for (int i = 0; i < tamLaberinto(); i++) {
            for (int j = 0; j < tamLaberinto(); j++) {
                laberinto[i][j] = savedMaze[i][j];
            }
        }
    }

    public static void main(String[] args) {

        Laberinto maze = new Laberinto();
        maze.imprimir();

        System.out.println("\n\nSal del laberinto con una pila: ");
        maze.resolverConPila();

        System.out.println("\n\nSal del laberinto con una cola: ");
        maze.resolverConCola();



    }


    public void resolverConPila() {

        //guardar el laberinto
        char[][] savedMaze = clone();

        //declaran las ubicaciones de pila
        Stack<MazePos> candidatos = new Stack<>();

        //inserte el inicio
        candidatos.push(new MazePos(START_I, START_J));

        MazePos crt, next;
        while (!candidatos.empty()) {

            //obtener la posición actual
            crt = candidatos.pop();

            if (Final(crt)) {
                break;
            }

            //marcar la posición actual
            marcar(crt, V);

            //poner sus vecinos en la cola
            next = crt.Norte();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
            next = crt.Este();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
            next = crt.Oeste();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
            next = crt.Sur();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
        }

        if (!candidatos.empty()) {
            System.out.println("Ya lo tienes!");
        } else {
            System.out.println("Estás atrapado en el laberinto!");
        }
        imprimir();

        //restaurar el laberinto
        restaurar(savedMaze);
    }

    public void resolverConCola() {

        //guardar el laberinto
        char[][] savedMaze = clone();

        //declaran las ubicaciones de pila 
        LinkedList<MazePos> candidates = new LinkedList<>();

        //inserte el inicio 
        candidates.add(new MazePos(START_I, START_J));

        MazePos crt, next;
        while (!candidates.isEmpty()) {

            //posición actual
            crt = candidates.removeFirst();

            if (Final(crt)) {
                break;
            }

            //marcar la posición actual
            marcar(crt, V);

            //poner sus vecinos en la cola
            next = crt.Norte();
            if (isInMaze(next) && limpiar(next)) {
                candidates.add(next);
            }
            next = crt.Este();
            if (isInMaze(next) && limpiar(next)) {
                candidates.add(next);
            }
            next = crt.Oeste();
            if (isInMaze(next) && limpiar(next)) {
                candidates.add(next);
            }
            next = crt.Sur();
            if (isInMaze(next) && limpiar(next)) {
                candidates.add(next);
            }
        }

        if (!candidates.isEmpty()) {
            System.out.println("Ya lo tienes!");
        } else {
            System.out.println("Estás atrapado en el laberinto!");
        }
        imprimir();

        //restaurar el laberinto
        restaurar(savedMaze);
    }


    public boolean solve(MazePos pos) {

        //base case
        if (!isInMaze(pos)) {
            return false;
        }
        if (Final(pos)) {
            return true;
        }
        if (!limpiar(pos)) {
            return false;
        }

        //posición actual debe ser clara
        assert (limpiar(pos));

//        recurso 
//        primera Marcar esta ubicación
        marcar(pos, V);

        //tratar de ir hacia el sur
        if (solve(pos.Sur())) {

            return true;
        }

        //más al oeste 
        if (solve(pos.Oeste())) {

            return true;
        }

        //else irNorte 
        if (solve(pos.Norte())) {

            return true;
        }

        //más al este
        if (solve(pos.Este())) {

            return true;
        }


        marcar(pos, C);

        return false;
    }
      public void resolverConPilacsv() {

        //guardar el laberinto
        char[][] savedMaze = clone();

        //declaran las ubicaciones de pila
        Stack<MazePos> candidatos = new Stack<>();

        //inserte el inicio
        candidatos.push(new MazePos(START_I, START_J));

        MazePos crt, next;
        while (!candidatos.empty()) {

            //obtener la posición actual
            crt = candidatos.pop();

            if (Final(crt)) {
                break;
            }

            //marcar la posición actual
            marcar(crt, V);

            //poner sus vecinos en la cola
            next = crt.Norte();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
            next = crt.Este();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
            next = crt.Oeste();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
            next = crt.Sur();
            if (isInMaze(next) && limpiar(next)) {
                candidatos.push(next);
            }
        }

        if (!candidatos.empty()) {
            System.out.println("Ya lo tienes!");
        } else {
            System.out.println("Estás atrapado en el laberinto!");
        }
        imprimir();

        //restaurar el laberinto
        restaurar(savedMaze);
    }
       public void resolverRecursioncsv() {

        if (solve(new MazePos(START_I, START_J))) {
            System.out.println("lo tengo: ");
        } else {
            System.out.println("Estás atrapado en el laberinto.");
        }
        imprimir();

    }

    

};

class MazePos {

    int i, j;

    public MazePos(int i, int j) {
        this.i = i;
        this.j = j;
    }

    ;
    public int i() {
        return i;
    }

    public int j() {
        return j;
    }

    public void print() {
        System.out.println("(" + i + "," + j + ")");
    }

    public MazePos Norte() {
        return new MazePos(i - 1, j);
    }

    public MazePos Sur() {
        return new MazePos(i + 1, j);
    }

    public MazePos Este() {
        return new MazePos(i, j + 1);
    }

    public MazePos Oeste() {
        return new MazePos(i, j - 1);
    }
 public static String[][] CONVERTIR(String rutaCSV) {

        try {

            Scanner lector = new Scanner(new File(rutaCSV));

            String[][] matriz = new String[110][100];

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

            System.out.println("No se encuentra : " + rutaCSV);

            return null;

        }

    }
 
};

