
package EDD_1358;

/**
 *
 * @author jaas
 */
import java.util.ArrayList;
public class Trabajador {
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private int AnioIngreso;
    private int NumTrabajador;
    private int HoraExtra;
    private double sueldo;
//Constructor
    public Trabajador(int numTrabajador, String nombre, String apellidoP, String apellidoM,int He,  double sueldo, int anioIngreso) {
        this.Nombre = nombre;
        this.ApellidoP = apellidoP;
        this.ApellidoM = apellidoM;
        this.AnioIngreso = anioIngreso;
        this.NumTrabajador = numTrabajador;
        this.HoraExtra = He;
        this.sueldo = sueldo;
    }
    
    //Setters and Getters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public int getAnioIngreso() {
        return AnioIngreso;
    }

    public void setAnioIngreso(int AnioIngreso) {
        this.AnioIngreso = AnioIngreso;
    }

    public int getNumTrabajador() {
        return NumTrabajador;
    }

    public void setNumTrabajador(int NumTrabajador) {
        this.NumTrabajador = NumTrabajador;
    }

    public int getHoraExtra() {
        return HoraExtra;
    }

    public void setHoraExtra(int HoraExtra) {
        this.HoraExtra = HoraExtra;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    //metodo para organizarlos por mayor antiguedad
    public static void Antigueda(ArrayList Trabajadorlist) {
        int contador=0;
        int anio=0;
        int masAntiguo=0;
        int masReciente=0;
        int inmy=0;
           for (Object item :Trabajadorlist ) {
               anio = ((Trabajador)item).getAnioIngreso();
               if (contador ==0){
                   masAntiguo = masReciente;
                   inmy= contador;
               }
               contador+=1;
           }
             
       
        System.out.println("el nuevo es " + ((Trabajador) Trabajadorlist.get(inmy)).getNombre() + " " 
                                                            + ((Trabajador) Trabajadorlist.get(inmy)).getApellidoP() + " eres el nuevo");
        System.out.println("El número mayor es " + masAntiguo);
        contador = 0;
        int imen = 0;
        int menor = 0;
        for (Object item : Trabajadorlist) {

            anio = ((Trabajador) item).getAnioIngreso();

            if (contador == 0) {
                menor = anio;
            }

            if (anio < menor) {
                menor = anio;
                imen = contador;

            }

            contador += 1;
        }

        double sueldobonus = ((Trabajador) Trabajadorlist.get(imen)).getSueldo();
        ((Trabajador) Trabajadorlist.get(imen)).setSueldo(sueldobonus + sueldobonus * .03);
        System.out.println("el trabajador más antiguo es: " + ((Trabajador) Trabajadorlist.get(imen)).getNombre() + " " +
                            ((Trabajador) Trabajadorlist.get(imen)).getApellidoP());
    }

    public double sueldo() {
        double sueldofinal;
        sueldofinal = sueldo + (276.5 * HoraExtra);
        this.setSueldo(sueldofinal);
        return sueldofinal;
    }    

    @Override
    public String toString() {
        return "Trabajador{" + "Nombre=" + Nombre + ", ApellidoP=" + ApellidoP + ", ApellidoM=" + ApellidoM + ", AnioIngreso=" + AnioIngreso + ", NumTrabajador=" + NumTrabajador + ", HoraExtra=" + HoraExtra + ", sueldo=" + sueldo + '}';
    }
 
    }
    
