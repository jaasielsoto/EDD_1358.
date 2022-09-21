
package EDD_1358;

/**
 *
 * @author jaas
 */
import java.util.Scanner;
public class JuegoDeLaVida {
   private Tablero tablero;
   private byte[][] aux_board;
   private Scanner sc_key;
   
   public JuegoDeLaVida(){
       this.tablero = new Tablero();
       this.aux_board= new byte[RequerimientosDelJuegoDeLaVida.altura][RequerimientosDelJuegoDeLaVida.ancho];
       this.sc_key      = new Scanner(System.in);
       this.print_banner();
       this.set_board_user();
       this.game_process();
   }
      private void print_banner(){
       System.out.println("******* El juego de la vida *******\n");
       System.out.println("· El tamaño de la matriz se especifica en RequerimientosDelJuegoDeLaVida");
       System.out.println("· ahora debemos configurar las celdas para activar la celda (valor1) ");
       System.out.println("\t\tejemplo valido:\n\t\t2 3\n\t\t0 0\n");
       System.out.println("cuando termine de configurar use cordenadas que no sean: -1 -1 :)");
       System.out.println("introdusca una calve");
       this.sc_key.nextLine();
       this.clear_window();
    }  
      private void set_board_user(){
       int x,y = 0;
       boolean banderita = false;
       do{
           System.out.println("Configuración : "); this.tablero.print_estatus();
           System.out.println("\n\ncoordenadas:\t");
           x = this.sc_key.nextInt();
           y = this.sc_key.nextInt();
           banderita = x>=0 && x<=RequerimientosDelJuegoDeLaVida.altura && y>=0 && y<=RequerimientosDelJuegoDeLaVida.ancho;
           if(banderita) this.tablero.set_coordenadas(x,y,(byte)1);
       }while(banderita);
   }
         private void game_process(){
       int celvivasAlrededor = 0;
       this.tablero.print_estatus();
       while(true){
           try{ Thread.sleep(RequerimientosDelJuegoDeLaVida.tCiclo); }
           catch(InterruptedException e){}
           finally{
               for(int x=0;x<RequerimientosDelJuegoDeLaVida.altura;x++){
                   for(int y=0;y<RequerimientosDelJuegoDeLaVida.ancho;y++){
                       celvivasAlrededor = tablero.celVivas_alrededor(x,y);
                       if(this.tablero.get_coordenadas(x,y)==1){
                           if(celvivasAlrededor>=RequerimientosDelJuegoDeLaVida.celViva0 && celvivasAlrededor<=RequerimientosDelJuegoDeLaVida.celViva1){ aux_board[x][y] = (byte)1;}
                           else if(celvivasAlrededor<RequerimientosDelJuegoDeLaVida.celViva0 || celvivasAlrededor>RequerimientosDelJuegoDeLaVida.celViva1){ aux_board[x][y] = (byte)0;}
                           }
                   else if(celvivasAlrededor==RequerimientosDelJuegoDeLaVida.celViva2){ aux_board[x][y] = (byte)1;} 
                   }             
               }
           }
           if(this.check_break_flag()) break;
           this.copy_boards();
           this.clear_window();
           this.tablero.print_estatus();                  
       }
    }
       private boolean check_break_flag(){
       for(int i=0;i<RequerimientosDelJuegoDeLaVida.altura;i++) for(int j=0;j<RequerimientosDelJuegoDeLaVida.ancho;j++) if(this.aux_board[i][j]!=this.tablero.get_coordenadas(i,j)) return false;
       return true;
   }
      private void copy_boards(){ for(int i=0;i<RequerimientosDelJuegoDeLaVida.altura;i++) for(int j=0;j<RequerimientosDelJuegoDeLaVida.ancho;j++) this.tablero.set_coordenadas(i,j,this.aux_board[i][j]); }
      
     private void clear_window(){for(int i=0;i<50;++i,System.out.println());}
   public static void main(String args[]){
       JuegoDeLaVida gol = new JuegoDeLaVida();
   }
}
