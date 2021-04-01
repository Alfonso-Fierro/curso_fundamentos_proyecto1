    
public class InvertirArreglo1
{
    public static int[] invertir(int[] ref){
        int[] invertido = new int[ref.length];
        for(int i = 0; i < invertido.length; i++){
            invertido[i] = ref[ref.length-(1+i)];
        }
        System.out.println("Arrego invertido.");
        return invertido;
    }
}