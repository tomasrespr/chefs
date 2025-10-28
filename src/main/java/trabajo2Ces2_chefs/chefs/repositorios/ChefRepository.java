package trabajo2Ces2_chefs.chefs;

import org.springframework.stereotype.Repository;
import trabajo2Ces2_chefs.chefs.modelos.CategoriaCulinaria;
import trabajo2Ces2_chefs.chefs.modelos.Chef;
import trabajo2Ces2_chefs.chefs.modelos.Mentor;
import trabajo2Ces2_chefs.chefs.modelos.Restaurante;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@Repository
public class ChefRepository {

    private final Stack<Chef> chefsStack = new Stack<>();
    private final Mentor mentor;

    public ChefRepository() {
        // Crear 5 chefs en distintas combinaciones de restaurante y categoría
        Chef chef1 = new Chef("Laura", CategoriaCulinaria.INTERMEDIO, Restaurante.CASERO);
        Chef chef2 = new Chef("Carlos", CategoriaCulinaria.INTERMEDIO, Restaurante.GOURMET);
        Chef chef3 = new Chef("Diana", CategoriaCulinaria.PROFESIONAL, Restaurante.CASERO);
        Chef chef4 = new Chef("Andrés", CategoriaCulinaria.PRINCIPIANTE, Restaurante.FUSION);
        Chef chef5 = new Chef("Sofía", CategoriaCulinaria.INTERMEDIO, Restaurante.GOURMET);

        // Asignar últimos 5 puntajes (simulan platos ganadores)
        chef1.agregarPlatoGanador(8); chef1.agregarPlatoGanador(9); chef1.agregarPlatoGanador(10); chef1.agregarPlatoGanador(7); chef1.agregarPlatoGanador(9);
        chef2.agregarPlatoGanador(6); chef2.agregarPlatoGanador(7); chef2.agregarPlatoGanador(8); chef2.agregarPlatoGanador(9); chef2.agregarPlatoGanador(10);
        chef3.agregarPlatoGanador(10); chef3.agregarPlatoGanador(10); chef3.agregarPlatoGanador(9); chef3.agregarPlatoGanador(8); chef3.agregarPlatoGanador(7);
        chef4.agregarPlatoGanador(5); chef4.agregarPlatoGanador(6); chef4.agregarPlatoGanador(7); chef4.agregarPlatoGanador(8); chef4.agregarPlatoGanador(9);
        chef5.agregarPlatoGanador(7); chef5.agregarPlatoGanador(8); chef5.agregarPlatoGanador(9); chef5.agregarPlatoGanador(10); chef5.agregarPlatoGanador(9);

        // Llenar el stack con todos los chefs
        chefsStack.push(chef1);
        chefsStack.push(chef2);
        chefsStack.push(chef3);
        chefsStack.push(chef4);
        chefsStack.push(chef5);

        // Crear mentor con los mismos chefs
        mentor = new Mentor("Chef Ramses", CategoriaCulinaria.PROFESIONAL, Restaurante.GOURMET, 3);
        Deque<Chef> deque = new ArrayDeque<>(chefsStack); // convierte el stack en deque
        mentor.setChefs(deque);
    }

    // Devuelve el Stack de chefs (para usar ListIterator)
    public Stack<Chef> getChefsStack() {
        return chefsStack;
    }

    // Devuelve el Mentor (que contiene el Deque)
    public Mentor getMentor() {
        return mentor;
    }

    // Devuelve un Deque construido a partir del stack (para el punto 3)
    public Deque<Chef> getDequeFromStack() {
        return new ArrayDeque<>(chefsStack);
    }

    // Método auxiliar: devuelve lista filtrada por restaurante (programación funcional)
    public List<Chef> findByRestaurante(Restaurante restaurante) {
        return getDequeFromStack()
                .stream()
                .filter(c -> c.getRestaurante() == restaurante)
                .collect(Collectors.toList());
    }
}
