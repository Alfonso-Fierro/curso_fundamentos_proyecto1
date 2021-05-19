import java.util.*;
public class Carro extends Vehiculo
{
    private final String clase = "Carro";
    public Carro(String placa, String marca, String color){
        super(placa,marca,color);
        this.setTipo(clase);
        super.setIngreso();
    }
    public Carro(String placa, String marca, String color, int vC){
        super(placa,marca,color);
        super.setValor(vC);
        this.setTipo("Carro");
        super.setIngreso();
    }
    @Override
    public int getCobro(){
        return this.cobro;
    }
}
