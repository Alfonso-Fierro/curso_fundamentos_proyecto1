public class Sensor
{
   public static Sensor[][] sensores;
   private int estado;
 
   public Sensor(){
   }
   public Sensor(int e){
       this.estado=e;
   }
   public int getEstado(){
        return estado;
    }
   public void setEstado(int e){
        this.estado=e;
   }
   public String toString(){
       String esta="";
       if(estado==1){
           esta="Estado: Ocupado";
       }else if(estado==0){
        esta= "Estado: Libre";
       }
       return esta;
   }
   public static String sensorLibre(){
       String libre="";
       for(int i=0; i<sensores.length; i++){
           for(int j=0; j<sensores[i].length; j++){
               if(Vehiculo.vehiculos[i][j] == Vehiculo.filler){
                   libre+= " Libre: " + sensores[i][j]+ " piso: "+ (j+1) + " espacio: " + (i+1) + "\n";   
               }
               else{
                   libre+= "Ocupado";
               }
           }   
       }
       return libre;
   }
   public static String sensoresEstado(){
        String sen;
        String estad="";
        for(int i=0; i<sensores.length; i++){
            for(int j=0; j<sensores[i].length; j++){
                if(Vehiculo.vehiculos[i][j] == Vehiculo.filler){
                    sen="Libre";
                    estad+= sen + " piso: "+ (j+1) + " espacio:" + (i+1) + "\n";   
                }else if(Vehiculo.vehiculos[i][j] != Vehiculo.filler){
                    sen="Ocupado";
                    estad+= sen + " piso: "+ (j+1) + " espacio:" + (i+1) + "\n";   
                }
            }
        }
        return estad;
    }
}