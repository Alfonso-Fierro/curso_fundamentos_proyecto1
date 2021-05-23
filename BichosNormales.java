public class BichosNormales extends Bichos
{
    public int salud = 10;
    public String name;
    public BichosNormales(String n){
        this.name = n; 
    }
    public String getNombre(){
        return this.name;
    }
    public int getSalud(){
        return this.salud;
    }
    public String toString(){
        return "BN-"+this.salud;
    }
    public void balazo(){
        this.salud= this.salud-5;
    }
}

