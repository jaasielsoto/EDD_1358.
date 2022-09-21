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
public class Tablero {
    private byte[][] tablero;
    
    public Tablero(){
        this.tablero = new byte[RequerimientosDelJuegoDeLaVida.altura][RequerimientosDelJuegoDeLaVida.ancho];
    }

    Tablero(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void set_coordenadas(int x, int y, byte value){
    try{this.tablero[x][y] = value;}
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("coordenadas no validas");}
    }   
    public byte get_coordenadas(int x, int y){return this.tablero[x][y];}
 public int celVivas_alrededor(int x, int y){
     int count = 0;
     try{if(this.tablero[x-1][y-1]==1)count++;}
     catch(Exception e){}
     try{if(this.tablero[x+1][y-1]==1)count++;}
     catch(Exception e){}  
    try{if(this.tablero[x-1][y]==1)count++;}
     catch(Exception e){}
    try{if(this.tablero[x+1][y]==1)count++;}
     catch(Exception e){}
    try{if(this.tablero[x][y-1]==1)count++;}
     catch(Exception e){}
    try{if(this.tablero[x][y+1]==1)count++;}
     catch(Exception e){}
    try{if(this.tablero[x+1][y+1]==1)count++;}
     catch(Exception e){}
    try{if(this.tablero[x-1][y+1]==1)count++;}
     catch(Exception e){}
    return count;
 }
 public void print_estatus(){
     for(int x = 0; x< RequerimientosDelJuegoDeLaVida.altura;x++){
         for(int y = 0; y< RequerimientosDelJuegoDeLaVida.ancho; y++){
             if(this.tablero[x][y]==1) System.out.println("*");
             else System.out.print("0");
         }
         System.out.println();
     }
 }
}
