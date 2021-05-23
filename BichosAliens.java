public class BichosAliens extends Bichos
{
    public int salud = 20;
    public String name;
    public BichosAliens(String n){
        this.name = n;
    }
    public String getNombre(){
        return this.name;
    }
    public int getSalud(){
        return this.salud;
    }
    public String toString(){
        return "BA-"+this.salud;
    }
    public void balazo(){
        this.salud= this.salud-5;
    }
}
