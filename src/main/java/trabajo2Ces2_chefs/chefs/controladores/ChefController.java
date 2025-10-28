package trabajo2Ces2_chefs.chefs.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import trabajo2Ces2_chefs.chefs.ChefRepository;
import trabajo2Ces2_chefs.chefs.modelos.Chef;
import trabajo2Ces2_chefs.chefs.modelos.Mentor;
import trabajo2Ces2_chefs.chefs.modelos.Restaurante;

import java.util.*;
import java.util.function.Function;

@Controller
public class ChefController {

    private final ChefRepository repo;

    public ChefController(ChefRepository repo) {
        this.repo = repo;
    }

    @GetMapping({"/", "/sector1"})
    public String sector1(Model model) {
        Stack<Chef> chefsStack = repo.getChefsStack();
        Mentor mentor = repo.getMentor(); // <-- esta línea obtiene el mentor
        model.addAttribute("chefsStack", chefsStack);
        model.addAttribute("mentor", mentor);
        return "sector1";
    }


    @GetMapping("/sector2")
    public String sector2(Model model) {

        Stack<Chef> chefsStack = repo.getChefsStack();
        List<String> desdeStack = new ArrayList<>();

        ListIterator<Chef> listIt = chefsStack.listIterator();
        while (listIt.hasNext()) {
            Chef c = listIt.next();
            desdeStack.add(c.getNombre() + " - " + c.getCategoria() + " - " + c.getRestaurante());
        }
        Deque<Chef> deque = repo.getMentor().getChefs();
        List<String> desdeDeque = new ArrayList<>();

        Iterator<Chef> it = deque.iterator();
        while (it.hasNext()) {
            Chef c = it.next();
            desdeDeque.add(c.getNombre() + " - " + c.getCategoria() + " - " + c.getRestaurante());
        }

        model.addAttribute("desdeStack", desdeStack);
        model.addAttribute("desdeDeque", desdeDeque);
        return "sector2";
    }


    @GetMapping("/sector3")
    public String sector3(Model model) {
        Stack<Chef> chefsStack = repo.getChefsStack();
        Deque<Chef> dequeChefs = new ArrayDeque<>(chefsStack);

        List<String> chefsCaseros = dequeChefs.stream()
                .filter(c -> c.getRestaurante() == Restaurante.CASERO)
                .map(Chef::getNombre)
                .toList();

        model.addAttribute("chefsCaseros", chefsCaseros);
        return "sector3";
    }



    @GetMapping("/sector4")
    public String sector4(Model model) {

        Function<Chef, Integer> sumarPlatos = (Chef c) ->
                c.getPlatosGanadores().stream().mapToInt(Integer::intValue).sum();

        Stack<Chef> chefsStack = repo.getChefsStack();
        Map<String, Integer> resultados = new LinkedHashMap<>();

        for (Chef c : chefsStack) {
            resultados.put(c.getNombre(), sumarPlatos.apply(c));
        }

        model.addAttribute("resultados", resultados);
        return "sector4";
    }


    @GetMapping("/sector5")
    public String sector5(Model model) {

        Chef ejemplo = repo.getChefsStack().peek();

        Function<Chef, Integer> funcion = (Chef c) ->
                c.getPlatosGanadores().stream().mapToInt(Integer::intValue).sum();

        int total = ejemplo.verTotalPlatos(funcion);

        model.addAttribute("ejemploNombre", ejemplo.getNombre());
        model.addAttribute("ejemploTotal", total);

        return "sector5";
    }

}
