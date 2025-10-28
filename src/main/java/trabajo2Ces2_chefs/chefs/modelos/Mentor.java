package trabajo2Ces2_chefs.chefs.modelos;

import java.util.ArrayDeque;
import java.util.Deque;

public class Mentor {
    private String nombre;
    private CategoriaCulinaria categoria;
    private Restaurante restaurante;
    private Deque<Chef> chefs;
    private int concursosGanados;

    public Mentor() {
        this.chefs = new ArrayDeque<>();
    }

    public Mentor(String nombre, CategoriaCulinaria categoria, Restaurante restaurante, int concursosGanados) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.restaurante = restaurante;
        this.concursosGanados = concursosGanados;
        this.chefs = new ArrayDeque<>();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(CategoriaCulinaria categoria) { this.categoria = categoria; }
    public void setRestaurante(Restaurante restaurante) { this.restaurante = restaurante; }
    public void setConcursosGanados(int concursosGanados) { this.concursosGanados = concursosGanados; }
    public void setChefs(Deque<Chef> chefs) { this.chefs = chefs; }


    public void agregarChef(Chef chef) {
        this.chefs.add(chef);
    }

    public String getNombre() { return nombre; }
    public CategoriaCulinaria getCategoria() { return categoria; }
    public Restaurante getRestaurante() { return restaurante; }
    public int getConcursosGanados() { return concursosGanados; }
    public Deque<Chef> getChefs() { return chefs; }
}
