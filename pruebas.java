import java.util.*;
import java.time.*;
public class pruebas
{   
    public static Vehiculo[] autos = new Vehiculo[4];
    public static final Date actual = new Date();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num= scan.nextInt();
        while(num!=0){
            switch(num){
                case 1:
                    System.out.println("Ingrese índice 0-3:");
                    int index = scan.nextInt();
                    System.out.println("Ingrese la placa del auto:");
                    String placa= scan.next();
                    System.out.println("Ingrese la marca del auto:");
                    String marca= scan.next();
                    System.out.println("Ingrese el color del auto:");
                    String color= scan.next();
                    Carro c = new Carro(placa, marca, color);
                    autos[index] = c;
                    break;
                    case 2:
                    System.out.println("Ingrese índice 0-3:");
                    int index2 = scan.nextInt();
                    System.out.println("placa moto:");
                    String placa2= scan.next();
                    System.out.println("marca moto:");
                    String marca2= scan.next();
                    System.out.println("color moto:");
                    String color2= scan.next();
                    Moto m = new Moto(placa2, marca2, color2);
                    autos[index2] = m;
                break;         
                case 3:
                    System.out.println(Vehiculo.horaActual());
                    break;
                case 4:
                    for(Vehiculo i: autos){
                        if(i != null){
                            System.out.println(i.toString()+ " Hora de ingreso: "+i.getIngreso());                      
                        }
                        else{ 
                            continue;
                        }
                    }
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            num= scan.nextInt();
        }
    }
}
