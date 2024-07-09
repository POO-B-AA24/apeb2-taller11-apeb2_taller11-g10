import java.util.Scanner;
public class juegoRoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Guerrero guerrero = new Guerrero("Aquiles", 150, 5.0, 200, "Espada");
        Mago mago = new Mago(80, 1.0, "Willy el Wonkas", 150, 5.0);
        Arquero arquero = new Arquero(120, "Arco De Fuego", "Myrgwin", 180, 5.0);

        while (true) {
            System.out.println("Seleccione el combate que desea realizar:");
            System.out.println("1. Guerrero vs Mago");
            System.out.println("2. Guerrero vs Arquero");
            System.out.println("3. Mago vs Arquero");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 4) {
                System.out.println("¡Hasta luego!");
                break;
            }
            System.out.println("------------------------------");
            System.out.println("Nivel de los personajes antes del combate:");
            System.out.println("Guerrero " + guerrero.nivelExperiencia);
            System.out.println("Mago " + mago.nivelExperiencia);
            System.out.println("Arquero " + arquero.nivelExperiencia);
            System.out.println("------------------------------");

            switch (opcion) {
                case 1:
                    realizarCombate(guerrero, mago);
                    break;
                case 2:
                    realizarCombate(guerrero, arquero);
                    break;
                case 3:
                    realizarCombate(mago, arquero);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    public static void realizarCombate(Personaje p1, Personaje p2) {
        double puntosAtaqueP1 = p1.atacar();
        double puntosDefensaP2 = p2.defender();
        double puntosAtaqueP2 = p2.atacar();
        double puntosDefensaP1 = p1.defender();

        System.out.println(p1.nom + " vs " + p2.nom);

        if (puntosAtaqueP1 > puntosDefensaP2) {
            System.out.println(p1.nom + " gana el combate contra " + p2.nom);
            p1.incrementarExperiencia();
            p2.decrementarExperiencia();
        } else if (puntosAtaqueP2 > puntosDefensaP1) {
            System.out.println(p2.nom + " gana el combate contra " + p1.nom);
            p2.incrementarExperiencia();
            p1.decrementarExperiencia();
        } else {
            System.out.println("El combate entre " + p1.nom + " y " + p2.nom + " termina en empate");
        }
    }

    abstract static class Personaje {

        public String nom;
        public int puntosVida;
        public double nivelExperiencia;

        public Personaje(String nom, int puntosVida, double nivelExperiencia) {
            this.nom = nom;
            this.puntosVida = puntosVida;
            this.nivelExperiencia = nivelExperiencia;
        }

        public abstract double atacar();

        public abstract double defender();

        public void incrementarExperiencia() {
            this.nivelExperiencia += 1.0;
        }

        public void decrementarExperiencia() {
            if (this.nivelExperiencia > 0) {
                this.nivelExperiencia -= 1.0;
            }
        }
    }

    static class Guerrero extends Personaje {

        public int fuerza;
        public String habilidadCuerpoCuerpo;

        public Guerrero(String nom, int fuerza, double nivelExperiencia, int puntosVida,
                String habilidadCuerpoCuerpo) {
            super(nom, puntosVida, nivelExperiencia);
            this.fuerza = fuerza;
            this.habilidadCuerpoCuerpo = habilidadCuerpoCuerpo;
        }

        @Override
        public double atacar() {
            return fuerza;
        }

        @Override
        public double defender() {
            return fuerza / 1.5;
        }
    }

    static class Mago extends Personaje {

        public int hechizo;
        public double poderMagico;

        public Mago(int hechizo, double poderMagico, String nom, int puntosVida,
                double nivelExperiencia) {
            super(nom, puntosVida, nivelExperiencia);
            this.hechizo = hechizo;
            this.poderMagico = poderMagico;
        }

        @Override
        public double atacar() {
            return poderMagico;
        }

        @Override
        public double defender() {
            return poderMagico / 1.5;
        }
    }

    static class Arquero extends Personaje {

        public int precision;
        public String habilidadDistancia;

        public Arquero(int precision, String habilidadDistancia, String nom, int puntosVida,
                double nivelExperiencia) {
            super(nom, puntosVida, nivelExperiencia);
            this.precision = precision;
            this.habilidadDistancia = habilidadDistancia;
        }

        @Override
        public double atacar() {
            return precision;
        }

        @Override
        public double defender() {
            return precision / 1.5;
        }
    }
}
