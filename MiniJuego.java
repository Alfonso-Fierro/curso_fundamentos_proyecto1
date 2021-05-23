import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class MiniJuego
{
    public static void main(String[] args) {
        Bichos tablero[][]= new Bichos[2][2];
        double random = (Math.random() * ((4 - 1) + 1)) + 1;
        System.out.println((int)random);
        for(int i=0; i<(int)random; i++){
            double random2 = (int)(Math.random() * ((2 - 1) + 1)) + 1;
            System.out.println(random2);
            Bichos temp;
            if(random2 ==1){
                 temp = new BichosNormales("BN");
            
            }else{
                 temp = new BichosAliens("BA");

            }
            switch(i){
                case 0:
                    tablero[0][0] = temp;
                break;
                case 1:
                    tablero[0][1] = temp;
                break;
                case 2:
                    tablero[1][0] = temp;
                break;
                case 3:
                    tablero[1][1] = temp;
                break;
                
            }
        }
        System.out.println(mostrarTablero(tablero));
        iniciarJuego(tablero);

    }
    public static String mostrarTablero(Bichos[][] ref){
        String text1 = "";
        text1 ="-------------" + "\n" + "|" + mostrarCasilla(ref[0][0]) + "|"
                + mostrarCasilla(ref[0][1]) + "|" + "\n" + "-------------" + "\n" + "|"
                + mostrarCasilla(ref[1][0]) + "|" + mostrarCasilla(ref[1][1]) + "|" + "\n" + "-------------"
                + "\n";
            return text1;
        }
    public static String mostrarCasilla(Bichos b) {
        if (b == null) {
            return "     ";
        } else {
            return b.toString();
        }
    }
    public static boolean terminarJuego(Bichos[][] ref){
        boolean sigueJugando = false;
        for(int i = 0; i<ref.length;i++){
            for(int j = 0; j<ref[i].length; j++){
                if(ref[i][j] != null){
                    sigueJugando = sigueJugando || (ref[i][j].getSalud()>0);
                }
            }
        }
        return sigueJugando;
    }
    public static void iniciarJuego(Bichos ref[][]){
            while(terminarJuego(ref)){
                System.out.println("Usuario indique la posición donde quiere disparar");
                Scanner scan = new Scanner(System.in);
                int pos1= scan.nextInt();
                int pos2= scan.nextInt();
                ref[pos1][pos2].balazo();
                if(ref[pos1][pos2].getSalud()<= 0){
                    ref[pos1][pos2]=null;
                }
                 System.out.println(mostrarTablero(ref));
            }
            System.out.println("Todos los bichos han sido asesinados. \nJuego terminado");
        }
    }
