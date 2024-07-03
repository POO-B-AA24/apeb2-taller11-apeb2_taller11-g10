public class JuegoRoles {
    public static void main(String[] args) {        
    }
}
abstract class Personaje{
    public String nombre;
    public int puntosVida;
    public double nivelExperiencia;
    public abstract void atacar();
    public abstract void defender();

    public Personaje(String nombre, int puntosVida, double nivelExperiencia) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelExperiencia = nivelExperiencia;
    }
    
}
class Guerrero extends Personaje{
    public int fuerza;

    public Guerrero(int fuerza, String nombre, int puntosVida, double nivelExperiencia) {
        super(nombre, puntosVida, nivelExperiencia);
        this.fuerza = fuerza;
    }     
    public void atacar(){
    }
    public void defender(){
    }
}
class Mago extends Personaje{
    public int hechizo;

    public Mago(int hechizo, String nombre, int puntosVida, double nivelExperiencia) {
        super(nombre, puntosVida, nivelExperiencia);
        this.hechizo = hechizo;
    }
    public void atacar(){
    }
    public void defender(){
    }
    
}
class Arquero extends Personaje{
    public int precision;

    public Arquero(int precision, String nombre, int puntosVida, double nivelExperiencia) {
        super(nombre, puntosVida, nivelExperiencia);
        this.precision = precision;
    }
    public void atacar(){
    }
    public void defender(){
    }
}

