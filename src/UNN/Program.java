package UNN;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Program  implements Iterable<Comand> { //Iterable - стандартный интерфейс для обьектов,элементы которых можно переибрат

    private ArrayList<Comand> commands = new ArrayList<>();

    public void add(Comand command) {
        commands.add(command);
    }
    @Override
    public Iterator<Comand> iterator() {
        return commands.iterator();
    }

    public Map<String, List<Comand>> groupCommands() { //Создаем Map и разбиваем по группам

        Map<String, List<Comand>> result = commands.stream()
                .collect(Collectors.groupingBy(c -> c.getName()));

        return result;
    }

    public String mostPopularInstruction() { //Значение String группы с наибольшим количесвтом команд
        Map<String, List<Comand>> groups = groupCommands();

        return groups.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .get().getKey();
    }

    public List<String> sortedInstructions() { //сортировку инструкций по частоте появления
        Map<String, List<Comand>> groups = groupCommands();

        return groups.entrySet().stream()
                .sorted((a, b) -> Integer.compare(
                        b.getValue().size(),
                        a.getValue().size()))
                .map(e -> e.getKey())
                .toList();
    }

    public List<Comand> findbyRegister(String register) { //Используем ли нужный регитр
        return commands.stream()
                .filter(c -> c.usesRegister(register))
                .toList();
    }

    public List<Integer> getMemoryAddressRange() { //Минимальный и маккимальный адрес в нашей памяти
        List<Integer> a = commands.stream()
                .map(c -> c.getAddress())
                .filter(x -> x != -1)
                .sorted()
                .toList();

        return List.of(a.get(0), a.get(a.size() - 1));
    }

    }



