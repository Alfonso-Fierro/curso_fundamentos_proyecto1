import java.util.*;
import java.time.*;
public class pruebas
{   
    public static Vehiculo[][] autos = new Vehiculo[4][4];
    public static final Date actual = new Date();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese cobro carros:");
        int car= scan.nextInt(); 
        System.out.print("Ingrese cobro motos:");
        int moto= scan.nextInt(); 
        System.out.print("opciones");
        int num= scan.nextInt();        
        while(num!=0){
            switch(num){
                case 1:
                    System.out.println("ingreso carro");
                    System.out.println("Ingrese índice 0-3:");
                    int index = scan.nextInt();
                    System.out.println("Ingrese la placa del auto:");
                    String placa= scan.next();
                    System.out.println("Ingrese la marca del auto:");
                    String marca= scan.next();
                    System.out.println("Ingrese el color del auto:");
                    String color= scan.next();
                    Vehiculo c = new Carro(placa, marca, color, car);
                    autos[index][index] = c;
                    break;
                    case 2:
                    System.out.println("ingreso moto");
                    System.out.println("Ingrese índice 0-3:");
                    int index2 = scan.nextInt();
                    System.out.println("placa moto:");
                    String placa2= scan.next();
                    System.out.println("marca moto:");
                    String marca2= scan.next();
                    System.out.println("color moto:");
                    String color2= scan.next();
                    Vehiculo m = new Moto(placa2, marca2, color2, moto);
                    autos[index2][index2] = m;
                break;         
                case 3:
                    System.out.println("hora");
                    System.out.println(Vehiculo.horaActual());
                    break;
                case 4:
                    System.out.println("info");
                    for(int i=0; i<autos.length; i++){
                        for(int j=0; j<autos.length; j++){
                            if(autos[i][j] != null){                                
                                System.out.println(autos[i][j].toString()+ " Hora de ingreso: "+autos[i][j].getIngreso());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("salida");
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    System.out.println(salidap(x,y));
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            num= scan.nextInt();
        }
    }
    public static String salidap(int x, int y){
        Vehiculo mov = autos[x][y];
        long pago = Duration.between(mov.getIngreso(),horaActuali()).toMinutes()*(mov.getCobro()/60);
        autos[x][y] = null;
        return "Total a pagar: $"+pago;
    }
    public static LocalDateTime horaActuali(){
        return LocalDateTime.now();
    } 
}
