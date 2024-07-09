import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Juan Perez");

        Menu menu1 = new MenuCarta("Bife de chorizo", 20.0, 5.0, 3.0, 10.0);
        Menu menu2 = new MenuDia("Pollo al horno", 15.0, 4.0, 2.0);
        Menu menu3 = new MenuNinos("Hamburguesa", 10.0, 2.0, 1.5);
        Menu menu4 = new MenuEconomico("Ensalada", 8.0, 15.0);

        cuenta.agregarMenu(menu1);
        cuenta.agregarMenu(menu2);
        cuenta.agregarMenu(menu3);
        cuenta.agregarMenu(menu4);

        cuenta.calcularValores();
        System.out.println(cuenta.toString());
    }
}

abstract class Menu {

    public String nombrePlato;
    public double valorInicial;
    public double valorMenu;

    public Menu(String nombrePlato, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }

    public abstract void calcularValorMenu();

    @Override
    public abstract String toString();
}

class MenuCarta extends Menu {

    public double valorGuarnicion;
    public double valorBebida;
    public double porcentajeServicio;

    public MenuCarta(String nombrePlato, double valorInicial, double valorGuarnicion, double valorBebida, double porcentajeServicio) {
        super(nombrePlato, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
        calcularValorMenu();
    }

    @Override
    public void calcularValorMenu() {
        this.valorMenu = valorInicial + valorGuarnicion + valorBebida + (porcentajeServicio * valorInicial / 100);
    }

    @Override
    public String toString() {
        return String.format("MenuCarta: %s, Valor Inicial: %.2f, Valor Guarnicion: %.2f, Valor Bebida: %.2f, Porcentaje Servicio: %.2f%%, Valor Total: %.2f",
                nombrePlato, valorInicial, valorGuarnicion, valorBebida, porcentajeServicio, valorMenu);
    }
}

class MenuDia extends Menu {

    public double valorPostre;
    public double valorBebida;

    public MenuDia(String nombrePlato, double valorInicial, double valorPostre, double valorBebida) {
        super(nombrePlato, valorInicial);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
        calcularValorMenu();
    }

    @Override
    public void calcularValorMenu() {
        this.valorMenu = valorInicial + valorPostre + valorBebida;
    }

    @Override
    public String toString() {
        return String.format("MenuDia: %s, Valor Inicial: %.2f, Valor Postre: %.2f, Valor Bebida: %.2f, Valor Total: %.2f",
                nombrePlato, valorInicial, valorPostre, valorBebida, valorMenu);
    }
}

class MenuNinos extends Menu {

    public double valorHelado;
    public double valorPastel;

    public MenuNinos(String nombrePlato, double valorInicial, double valorHelado, double valorPastel) {
        super(nombrePlato, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
        calcularValorMenu();
    }

    @Override
    public void calcularValorMenu() {
        this.valorMenu = valorInicial + valorHelado + valorPastel;
    }

    @Override
    public String toString() {
        return String.format("MenuNinos: %s, Valor Inicial: %.2f, Valor Helado: %.2f, Valor Pastel: %.2f, Valor Total: %.2f",
                nombrePlato, valorInicial, valorHelado, valorPastel, valorMenu);
    }
}

class MenuEconomico extends Menu {

    public double porcentajeDescuento;

    public MenuEconomico(String nombrePlato, double valorInicial, double porcentajeDescuento) {
        super(nombrePlato, valorInicial);
        this.porcentajeDescuento = porcentajeDescuento;
        calcularValorMenu();
    }

    @Override
    public void calcularValorMenu() {
        this.valorMenu = valorInicial - (porcentajeDescuento * valorInicial / 100);
    }

    @Override
    public String toString() {
        return String.format("MenuEconomico: %s, Valor Inicial: %.2f, Porcentaje Descuento: %.2f%%, Valor Total: %.2f",
                nombrePlato, valorInicial, porcentajeDescuento, valorMenu);
    }
}

class Cuenta {

    public String nombreCliente;
    public List<Menu> menus;
    public double subtotal;
    public double iva;
    public double valorTotal;

    public Cuenta(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.menus = new ArrayList<>();
    }

    public void agregarMenu(Menu menu) {
        menus.add(menu);
    }

    public void calcularValores() {
        subtotal = 0;
        for (Menu menu : menus) {
            subtotal += menu.valorMenu;
        }
        iva = subtotal * 0.12;
        valorTotal = subtotal + iva;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta de: ").append(nombreCliente).append("\n");
        for (Menu menu : menus) {
            sb.append(menu.toString()).append("\n");
        }
        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("IVA: %.2f\n", iva));
        sb.append(String.format("Total a pagar: %.2f\n", valorTotal));
        return sb.toString();
    }
}
