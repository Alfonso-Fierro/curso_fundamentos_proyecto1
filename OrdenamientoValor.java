public class OrdenamientoValor
{
  public static String toStringVehiculos(Vehiculo[] ref){
        String g="";
        for(int i=0; i<ref.length; i++){                  
            g+= " Placa: "+ ref[i].getPlaca() + ", Marca: " + ref[i].getMarca()
            + ", Color: " + ref[i].getColor() + ", Valor comercial: " + ref[i].getValorString() + "||";                          
        }   
        return g;
    }
  public static Vehiculo[] bubleSort (Vehiculo[] list , int length) {
        boolean swap = true;
        Vehiculo temp;
        while(swap){
            swap = false;
            for(int i = 0;i < list.length-1; i++){              
                if(list[i].getValorNumerico() > list[i+1].getValorNumerico()){
                    temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;                   
                    swap = true;
                }
            }
        }
        return list;
    }
  public static Vehiculo[] valorOrdenado(Vehiculo[][] ref){
        //ref es la misma matriz del parqueadero
        int c = 0;
        int contadorIndice = 0;
        Vehiculo[] valoresOptimos = new Vehiculo[tamano];
        for(int i=0; i<ref.length; i++){
            for(int j=0; j<ref[i].length; j++){
                if(ref[i][j]!= null){
                    valoresOptimos[c] = ref[i][j]; 
                }
                c++;
            }
        }
        //usar el bubbleSort para sacar el arreglo con los precios ordenados de menor a mayor 
        Vehiculo.bubleSort(valoresOptimos, valoresOptimos.length);
        //Búsqueda para definir el índice del arreglo ordenado
        for(int i=0; i<valoresOptimos.length; i++){
            if(valoresOptimos[i] != null){
                contadorIndice++;
            }
        }
        Vehiculo[] optimosOrdenados = new Vehiculo[contadorIndice];
        //rellenar el arreglo optimosOrdenados
        for(int i=0; i<optimosOrdenados.length; i++){
            Vehiculo temp = valoresOptimos[i];
            optimosOrdenados[i] = temp;
        }
        return optimosOrdenados;
    }
}
