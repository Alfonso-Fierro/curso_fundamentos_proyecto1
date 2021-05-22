import java.util.*;
public class Carro extends Vehiculo
{   
    public static int cobro;
    private final String clase = "Carro";
    public Carro(String placa, String marca, String color, int cobro){
        super(placa,marca,color);
        this.setTipo(clase);
        super.setIngreso();
        this.setCobro(cobro);
    }
    public Carro(String placa, String marca, String color, int vC, int cobro){
        super(placa,marca,color);
        super.setValor(vC);
        this.setTipo("Carro");
        super.setIngreso();
        this.setCobro(cobro);
    }
    public void setCobro(int cobro){
        super.cobro = cobro;
        this.cobro = cobro;
    }
    public int getCobro(){
        return this.cobro;
    }
}
