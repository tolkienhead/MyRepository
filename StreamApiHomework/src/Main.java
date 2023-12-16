import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)

        transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        // Вывести список неповторяющихся городов, в которых работают трейдеры

        transactions.stream()
                .map(x -> x.getTrader().getCity())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // Найти всех трейдеров из Кембриджа и отсортировать их по именам

        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        // Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке

        String tradersNames =  transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(tradersNames);

        // Выяснить, существует ли хоть один трейдер из Милана

        boolean TraderFromMilan = transactions.stream()
                .anyMatch(x -> x.getTrader().getCity().equals("Milan"));
        System.out.println(TraderFromMilan);

        // Вывести суммы всех транзакций трейдеров из Кембриджа
        transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getValue())
                .forEach(System.out::println);

        // Какова максимальная сумма среди всех транзакций

        transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue)
                .ifPresent(System.out::println);

        // Найти транзакцию с минимальной суммой

        transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}