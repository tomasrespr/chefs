package trabajo2Ces2_chefs.chefs.modelos;

import java.util.Stack;
import java.util.function.Function;

public class Chef {
    private String nombre;
    private CategoriaCulinaria categoria;
    private Restaurante restaurante;
    private Stack<Integer> platosGanadores;

    public Chef() {
        this.platosGanadores = new Stack<>();
    }

    public Chef(String nombre, CategoriaCulinaria categoria, Restaurante restaurante) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.restaurante = restaurante;
        this.platosGanadores = new Stack<>();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(CategoriaCulinaria categoria) { this.categoria = categoria; }
    public void setRestaurante(Restaurante restaurante) { this.restaurante = restaurante; }

    public void agregarPlatoGanador(int puntos) {
        this.platosGanadores.push(puntos);
    }

    public String getNombre() { return nombre; }
    public CategoriaCulinaria getCategoria() { return categoria; }
    public Restaurante getRestaurante() { return restaurante; }
    public Stack<Integer> getPlatosGanadores() { return platosGanadores; }

    public int verTotalPlatos(Function<Chef, Integer> funcion) {
        Integer total = funcion.apply(this);
        System.out.println("Total de platos ganadores del chef " + nombre + " = " + total);
        return total != null ? total : 0;
    }

}

