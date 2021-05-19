import java.util.*;
public class Principal{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("¡Bienvenido!");
        System.out.print("Ingrese la cantidad de pisos:");
        int pisos= scan.nextInt();
        System.out.print("Ingrese la cantidad de espacios:");
        int espacios= scan.nextInt();
        Vehiculo.vehiculos = new Vehiculo[espacios][pisos];
        Sensor.sensores = new Sensor[espacios][pisos];
        Vehiculo.tamano = espacios*pisos;
        for(int i=0; i<Sensor.sensores.length; i++){
            for(int j=0; j<Sensor.sensores[i].length; j++){
                Sensor.sensores[i][j] = new Sensor(0);
            }
        }
 
        System.out.print(
          "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  0 | ⇒ |  Terminar ejecucion                                                               |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  1 | ⇒ |  Indicar espacios disponibles                                                     |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                                          |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                                   |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema                 |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema                        |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  6 | ⇒ |  Verificar el estado de un espacio                                                |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los espacios                                          |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  8 | ⇒ |  Presentar ordenadamente la informacion de los vehiculos con un color determinado |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "| COMANDO  9 | ⇒ |  Presentar la informacion de los vehiculos ordenados por su valor comercial       |\n"
        + "†-----------------------------------------------------------------------------------------------------†\n"
        + "Accion: ");          
        int num= scan.nextInt();
        while(num!=0){
            switch(num){
                case 1:
                System.out.println(Sensor.sensorLibre());
                break;
 
                case 2:
                System.out.print("Ingrese el piso donde desea ubicar el vehiculo:");
                int piso= scan.nextInt()-1;
                System.out.print("Ingrese el espacio donde desea ubicar el vehiculo:");
                int espacio= scan.nextInt()-1;
                if((piso > pisos)||(espacio > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                }
                else if(Sensor.sensores[espacio][piso].getEstado() != 0){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción.");
                    break;
                }else {
                    System.out.print("Ingrese la placa del auto:");
                    String placa= scan.next();
                    System.out.print("Ingrese la marca del auto:");
                    String marca= scan.next();
                    System.out.print("Ingrese el color del auto:");
                    String color= scan.next();
                    Vehiculo vehiculo = new Vehiculo(placa, marca, color);
                    Sensor.sensores[espacio][piso]= new Sensor(1);               
                    vehiculo.vehiculos[espacio][piso]=vehiculo;
                    break;
                }
                
 
                case 3:
                System.out.print("Ingrese el piso donde desea ubicar el vehiculo:");
                int piso2= scan.nextInt()-1;
                System.out.print("Ingrese el espacio donde desea ubicar el vehiculo:");
                int espacio2= scan.nextInt()-1;
                if((piso2 > pisos)||(espacio2 > espacios)){
                    System.out.print("Valores no reconocidos, no se puede ejercer esta acción."+"\n");
                    break;
                }
                if(Sensor.sensores[espacio2][piso2].getEstado() != 0){
                    System.out.println("Parqueadero ocupado, no se puede ejecutar esta acción."); 
                }else {
                    System.out.print("Ingrese la placa del auto:");
                    String placa2= scan.next();
                    System.out.print("Ingrese la marca del auto:");
                    String marca2= scan.next();
                    System.out.print("Ingrese el color del auto:");
                    String color2= scan.next();
                    System.out.print("Ingrese el valor comercial del auto:");
                    int valor= scan.nextInt();
                    Vehiculo vehiculo = new Vehiculo(placa2,marca2,color2,valor);
                    Sensor.sensores[espacio2][piso2]= new Sensor(1);
                    Vehiculo.vehiculos[espacio2][piso2]=vehiculo;
                    break;
                }
                
                case 4: 
                System.out.println("La información de los vehiculos ingresados es: "+ "\n" +
                "----------------------------------------------------------------" + "\n" + Vehiculo.toStringVehiculos());
                break;
 
                case 5:
                System.out.println("La cantidad de vehiculos ingresados es: " + Vehiculo.cantidad);
                break;
 
                case 6:
                System.out.println("Ingrese el piso y el espacio del que desea conocer el estado: "+ "\n");
                System.out.print("Piso:");
                int piso3= scan.nextInt()-1;                
                System.out.print("Espacio:");
                int espacio3= scan.nextInt()-1;                
                if((piso3 > pisos)||(espacio3 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                }else{
                    System.out.println("El estado del sensor es: \n"+ Sensor.sensores[espacio3][piso3].toString());
                }
                break;
 
                case 7:
                System.out.println(Sensor.sensoresEstado());
                break;
 
                default:
                System.out.println("Comando incorrecto");
                break;
 
                case 8:
                System.out.print("Ingrese el color de los vehiculos que desea obtener información:");
                String color= scan.next();
                System.out.println(Vehiculo.VehiculosColor(color));
                break;
 
                case 9:
 
                System.out.println("A continuación, la información de los vehiculos ordenados segun su valor comercial:");
                System.out.println("---------------------------------------------------------------------");
                System.out.println(Vehiculo.toStringVehiculos(Vehiculo.valorOrdenado()));
                break;
                }
            System.out.print(
            "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  0 | ⇒ |  Terminar ejecucion                                                               |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  1 | ⇒ |  Indicar espacios disponibles                                                     |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                                          |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                                   |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema                 |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema                        |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  6 | ⇒ |  Verificar el estado de un espacio                                                |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los espacios                                          |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  8 | ⇒ |  Presentar ordenadamente la informacion de los vehiculos con un color determinado |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  9 | ⇒ |  Presentar la informacion de los vehiculos ordenados por su valor comercial       |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "Accion: ");            
            num= scan.nextInt();
        } 
        System.out.println("Saliendo...");
    }
}