import java.util.*;
public class Principal{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Usuario, ingrese la cantidad de pisos y la cantidad de espacios");
        int pisos= scan.nextInt();
        int espacios= scan.nextInt();
        Vehiculo.vehiculos = new Vehiculo[espacios][pisos];
        Sensor.sensores = new Sensor[espacios][pisos];
        Vehiculo.tamano = espacios*pisos;
        for(int i=0; i<Vehiculo.vehiculos.length; i++){
            for(int j=0; j<Vehiculo.vehiculos[i].length; j++){
                Vehiculo.vehiculos[i][j] = Vehiculo.filler;
            }
        }
        for(int i=0; i<Sensor.sensores.length; i++){
            for(int j=0; j<Sensor.sensores[i].length; j++){
                Sensor n = new Sensor(0);
                Sensor.sensores[i][j] = n;
            }
        }
 
        System.out.println(
             "†-----------------------------------------------------------------------------------------†\n"
            +"| COMANDO  0 | ⇒ |  Terminar ejecucion                                                    |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  1 | ⇒ |  Imprimir lugares desocupados                                          |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                               |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                        |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema      |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema             |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  6 | ⇒ |  Verificar el estado de lugar                                          |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los lugares                                |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  8 | ⇒ |  Mostrar ordenadamente la informacion de vehiculos con el color deseado|\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  9 | ⇒ |  Mostrar la informacion de vehiculos ordenados por su valor comercial  |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "Accion: ");          
        int num= scan.nextInt();
        while(num!=0){
 
            switch(num){
                case 1:
                System.out.println(Sensor.sensorLibre());
                break;
 
                case 2:
                System.out.println("Ingrese el piso y el espacio");
 
                int piso= scan.nextInt()-1;
                int espacio= scan.nextInt()-1;
                if((piso > pisos)||(espacio > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                }
                else if(Vehiculo.vehiculos[espacio][piso] != Vehiculo.filler){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción"); 
                }else if(Vehiculo.vehiculos[espacio][piso] == Vehiculo.filler){
                    System.out.println("Ingrese placa del auto:");
                    String placa= scan.next();
                    System.out.println("Ingrese la marca del auto:");
                    String marca= scan.next();
                    System.out.println("Ingrese el color del auto:");
                    String color= scan.next();
                    Vehiculo vehiculo = new Vehiculo();
                    Sensor sensor= new Sensor();
                    vehiculo.setPlaca(placa);
                    vehiculo.setMarca(marca);
                    vehiculo.setColor(color);
                    vehiculo.setValor(30000000);
                    sensor.setEstado(1);
                    sensor.sensores[espacio][piso]=sensor;
                    vehiculo.cantidad++;
                    System.out.println(vehiculo.toString());
                    vehiculo.vehiculos[espacio][piso]=vehiculo;
 
                }
                break;
 
                case 3:
                System.out.println("Ingrese el piso y el espacio");
                int piso2= scan.nextInt()-1;
                int espacio2= scan.nextInt()-1;
                if((piso2 > pisos)||(espacio2 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                }
                else if(Vehiculo.vehiculos[espacio2][piso2] != Vehiculo.filler){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción."); 
                }else if(Vehiculo.vehiculos[espacio2][piso2]== Vehiculo.filler){
                    System.out.println("Ingrese placa del auto:");
                    String placa2= scan.next();
                    System.out.println("Ingrese la marca del auto:");
                    String marca2= scan.next();
                    System.out.println("Ingrese el color del auto:");
                    String color2= scan.next();
                    System.out.println("Ingrese valor comercial del auto");
                    int valor= scan.nextInt();
                    Vehiculo vehiculo = new Vehiculo();
                    Sensor sensor= new Sensor();
                    vehiculo.setPlaca(placa2);
                    vehiculo.setMarca(marca2);
                    vehiculo.setColor(color2);
                    vehiculo.setValor(valor);
                    sensor.setEstado(1);
                    sensor.sensores[espacio2][piso2]=sensor;
                    vehiculo.cantidad++;
                    System.out.println(vehiculo.toString());
                    Vehiculo.vehiculos[espacio2][piso2]=vehiculo;
                }
                break;
 
                case 4: 
                System.out.println("La información de los vehiculos es: " + Vehiculo.toStringVehiculos());
                break;
 
                case 5:
                System.out.println("La cantidad de vehiculos es: " + Vehiculo.cantidad);
                break;
 
                case 6:
                System.out.println("Ingrese el sensor del que desea saber el estado.\n 1 es ocupado, 0 es libre");
                int piso3= scan.nextInt();
                int espacio3= scan.nextInt();
                 if((piso3 > pisos)||(espacio3 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                 }else{
                  System.out.println("El estado del sensor es: \n"+ Sensor.sensores[espacio3][piso3].getEstado());
                 }
                break;
 
                case 7:
                System.out.println(Sensor.sensoresEstado());
                break;
 
                default:
                System.out.println("Comando incorrecto");
                break;
 
                case 8:
                System.out.println("Ingrese el color de los carros que quiere adquirir información");
                String colores= scan.next();
                System.out.println(Vehiculo.VehiculosColor(colores));
                break;
 
                case 9:
 
                System.out.println("A continuación información de los carros en orden de valor comercial:");
                System.out.println("---------------------------------------------------------------------");
                Vehiculo.toStringVehiculos(Vehiculo.valorOrdenado());
                break;
                }
            System.out.println(
             "†-----------------------------------------------------------------------------------------†\n"
            +"| COMANDO  0 | ⇒ |  Terminar ejecucion                                                    |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  1 | ⇒ |  Imprimir lugares desocupados                                          |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                               |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                        |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema      |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema             |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  6 | ⇒ |  Verificar el estado de lugar                                          |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los lugares                                |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  8 | ⇒ |  Mostrar ordenadamente la informacion de vehiculos con el color deseado|\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  9 | ⇒ |  Mostrar la informacion de vehiculos ordenados por su valor comercial  |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "Accion: ");        
            num= scan.nextInt();
        } 
        System.out.println("Saliendo...");
    }
}