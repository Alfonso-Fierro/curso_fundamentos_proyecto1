public class Vehiculo{   
    //Campos generales del programa
    public static Vehiculo[][] vehiculos; //Matríz contenedora de los objetos
    /* El índice de las filas es el piso y el índice de las columnas es el espacio.
     * se debe poder parquear en cualquier piso, en cualquier espacio (restricciones acomodadas)
       */
    public static String[] propiedades;// 
    public static int tamano; //cantidad de espacios totales en el edificio
    public static int cantidad = -1;//contador de Autos dentro del parqueadero
    public static final Vehiculo filler = new Vehiculo("x","x","x",0);//Objeto definido para ecitar la excepción null
    //Atributos de caracterización para los objetos
    private String placa; //Placa del auto  
    private String marca; //Marca del auto 
    private String color; //Color del auto
    private int valorComercial; //Precio del auto    
    public Vehiculo(){
        //constructor vacío, sin función.
    }
    public Vehiculo(String p, String m, String c){
        //constructor de un auto cuyo valor comercial es desconocido.
        this(p,m,c,30000000);
        /*
         * this.placa = p;
         * this.marca = m;
         * this.color = c;
         * this.valorComercial = 30000000 ;
           */
    }
    public Vehiculo(String p, String m, String c, int vC){
        //constructor de un auto cuyo valor comercial es conocido.
        this.placa = p;
        this.marca = m;
        this.color = c;
        this.valorComercial = vC ;
        Vehiculo.cantidad++;
    }
    //Métodos set&get (características por individuo)
    public void setMarca(String m){
        this.marca = m;
    }
    public void setPlaca(String p){
        this.placa = p;
    }
    public void setColor(String c){
        this.color = c;
    }
    public void setValor(int vC){
        this.valorComercial = vC;
    }
    public String getPlaca(){
        return this.placa;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getColor(){
        return this.color;
    }
    //Método en caso de necesitar realizar operaciones numéricas
    public int getValor(){
        return valorComercial;
    }
    //Método para el almacenamiento en un array String
    public String getValorString(){
        return String.valueOf(this.valorComercial);
    }
    public static void toStringVehiculos(Vehiculo ref){
        System.out.println(" Placa: "+ ref.getPlaca() + ", Marca: " + ref.getMarca()
                    + ", Color: " + ref.getColor() + ", Valor comercial: " + ref.getValorString() + "||");
    }
    public static void toStringVehiculos(Vehiculo[] ref){
        for(int i=0; i<ref.length; i++){            
            System.out.println(" Placa: "+ ref[i].getPlaca() + ", Marca: " + ref[i].getMarca()
            + ", Color: " + ref[i].getColor() + ", Valor comercial: " + ref[i].getValorString() + "||");            
        }  
    }
    public static String toStringVehiculos(){
        String g="";
        for(int i=0; i<vehiculos.length; i++){
            for(int j=0; j<vehiculos[i].length; j++){
                if(vehiculos[i][j] != Vehiculo.filler){
                    g+= " Placa: "+ vehiculos[i][j].getPlaca() + ", Marca: " + vehiculos[i][j].getMarca()
                    + ", Color: " + vehiculos[i][j].getColor() + ", Valor comercial: " + vehiculos[i][j].getValorString() + "||\n";     
                }
            }
        }   
        return g;
    }
    public static Vehiculo[] bubleSort (Vehiculo[] ref) {
        boolean swap = true;
        Vehiculo temp = new Vehiculo("x","x","x",1);
        Vehiculo[] ordenTemporal = new Vehiculo[ref.length];
        while(swap){
            swap = false;
            for(int i = 0;i < ref.length-1; i++){
                if(ref[i].getValor() > ref[i+1].getValor()){
                    temp = ref[i];
                    ref[i] = ref[i+1];
                    ref[i+1] = temp;                   
                    swap = true;
                }
            }
        }
        for(int i = 0;i < ordenTemporal.length; i++){
            ordenTemporal[i] = ref[i];
        }
        return ordenTemporal;
    }
    public static Vehiculo[] vehiculoToArray(){
        //ref es la misma matriz del parqueadero
        int c = 0;
        for(int i=0; i<Vehiculo.vehiculos.length; i++){
            for(int j=0; j<Vehiculo.vehiculos[i].length; j++){
                if(Vehiculo.vehiculos[i][j] != Vehiculo.filler){
                    c++;
                }
            }
        }
        Vehiculo[] array = new Vehiculo[c];
        int d = 0;
        for(int i=0; i<Vehiculo.vehiculos.length; i++){
            for(int j=0; j<Vehiculo.vehiculos[i].length; j++){
                if(Vehiculo.vehiculos[i][j] != Vehiculo.filler){
                    array[d] = Vehiculo.vehiculos[i][j]; 
                    d++;
                }
            }
        }
        return array;
    }
    public static Vehiculo[] valorOrdenado(){
        Vehiculo[] valoresOptimos = Vehiculo.vehiculoToArray();
        Vehiculo.bubleSort(valoresOptimos);
        //Búsqueda para definir el índice del arreglo ordenado
        return valoresOptimos;
    }
    public static String VehiculosColor(String c){
       String text="";
       for(int i=0; i<vehiculos.length; i++){
            for(int j=0; j<vehiculos[i].length; j++){
                if((vehiculos[i][j]!= null)&&(vehiculos[i][j].color.equalsIgnoreCase(c))){
                    text+= " Placa: "+ vehiculos[i][j].placa + ", Marca: " + vehiculos[i][j].marca + ", Color: " 
                    + vehiculos[i][j].color + ", Valor comercial: " + vehiculos[i][j].valorComercial + "||\n";     
                }
            }
        }
        return text; 
    }
}