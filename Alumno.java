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
public class Alumno {
    private String numeroCuenta;
    private String nombre;
    private String carrera;
    private double promedio;

    public Alumno(String numeroCuenta, String nombre, String carrera, double promedio) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", carrera=" + carrera + ", promedio=" + promedio + '}';
    }


   
}
