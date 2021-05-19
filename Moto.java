import java.util.*;
public class Moto extends Vehiculo
{
    private static final String clase = "Moto";
    public Moto(String placa, String marca, String color){
        super(placa,marca,color);
        super.setIngreso();
        this.setTipo(clase);        
    }
    public Moto(String placa, String marca, String color, int vC){
        super(placa,marca,color);
        super.setValor(vC);
        this.setTipo(clase);
        super.setIngreso();
    }
    @Override
    public int getCobro(){
        return this.cobro;
    }
}

