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

        Chef chef1 = new Chef("Laura", CategoriaCulinaria.INTERMEDIO, Restaurante.CASERO);
        Chef chef2 = new Chef("Carlos", CategoriaCulinaria.INTERMEDIO, Restaurante.GOURMET);
        Chef chef3 = new Chef("Diana", CategoriaCulinaria.PROFESIONAL, Restaurante.CASERO);
        Chef chef4 = new Chef("Andrés", CategoriaCulinaria.PRINCIPIANTE, Restaurante.FUSION);
        Chef chef5 = new Chef("Sofía", CategoriaCulinaria.INTERMEDIO, Restaurante.GOURMET);

        chef1.agregarPlatoGanador(8); chef1.agregarPlatoGanador(9); chef1.agregarPlatoGanador(10); chef1.agregarPlatoGanador(7); chef1.agregarPlatoGanador(9);
        chef2.agregarPlatoGanador(6); chef2.agregarPlatoGanador(7); chef2.agregarPlatoGanador(8); chef2.agregarPlatoGanador(9); chef2.agregarPlatoGanador(10);
        chef3.agregarPlatoGanador(10); chef3.agregarPlatoGanador(10); chef3.agregarPlatoGanador(9); chef3.agregarPlatoGanador(8); chef3.agregarPlatoGanador(7);
        chef4.agregarPlatoGanador(5); chef4.agregarPlatoGanador(6); chef4.agregarPlatoGanador(7); chef4.agregarPlatoGanador(8); chef4.agregarPlatoGanador(9);
        chef5.agregarPlatoGanador(7); chef5.agregarPlatoGanador(8); chef5.agregarPlatoGanador(9); chef5.agregarPlatoGanador(10); chef5.agregarPlatoGanador(9);

        chefsStack.push(chef1);
        chefsStack.push(chef2);
        chefsStack.push(chef3);
        chefsStack.push(chef4);
        chefsStack.push(chef5);

        mentor = new Mentor("Chef Ramses", CategoriaCulinaria.PROFESIONAL, Restaurante.GOURMET, 3);
        Deque<Chef> deque = new ArrayDeque<>(chefsStack);
        mentor.setChefs(deque);
    }

    public Stack<Chef> getChefsStack() {
        return chefsStack;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public Deque<Chef> getDequeFromStack() {
        return new ArrayDeque<>(chefsStack);
    }

    public List<Chef> findByRestaurante(Restaurante restaurante) {
        return getDequeFromStack()
                .stream()
                .filter(c -> c.getRestaurante() == restaurante)
                .collect(Collectors.toList());
    }
}
