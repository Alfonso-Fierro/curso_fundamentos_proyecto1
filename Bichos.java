import java.util.Random;
public class Bichos
{
    protected int salud;
    protected String name;
    public Bichos(){
    }
    public String getNombre(){
        return name;
    }
    public int getSalud(){
        return salud;
    }
    public void  balazo(){
        this.salud= this.salud-5;
    }
}

