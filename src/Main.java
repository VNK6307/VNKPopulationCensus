import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
// Подсчет количества несовершеннолетних в городе
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних граждан в городе - " + count);

        // Получение списка пригодных к службе в армии
        long count1 = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .count();
        System.out.println("Количество граждан, пригодных к службе в армии - " + count1);

        List<String> abledToArmy = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println("Список граждан, пригодных к службе в армии:");
        for (String s : abledToArmy) {
            System.out.println(s);
        }

        // Получение и сортировка списка женщин с высшим образованием
        List<String> highEducatedWomen = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 60)
                .filter(person -> person.getSex().equals(Sex.WOMAN))
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println("Список работоспособных женщин с высшим образованием:");
        for (String s : highEducatedWomen) {
            System.out.println(s);
        }

        // Получение и сортировка списка мужчин с высшим образованием
        List<String> highEducatedMen = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 65)
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println("Список работоспособных мужчин с высшим образованием:");
        for (String s : highEducatedMen) {
            System.out.println(s);
        }
    }
}