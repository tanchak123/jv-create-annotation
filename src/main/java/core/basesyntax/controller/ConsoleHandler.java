package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private PersonDao personDao;

    public void hundle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("q")) {
                return;
            }
            if (command.split(" ").length != 3) {
                System.out.println("Неправильно введены данные!");
                continue;
            }
            Bet bet = null;
            Person person = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = betData[2];
                bet = new Bet(value, risk);
                person = new Person(name);

            } catch (NumberFormatException e) {
                System.out.println("Неправильно введены данные!");
            }
            personDao.add(person);
            betDao.add(person,bet);
            System.out.println(bet == null || person == null ? null : bet.toString() + person.toString());
        }
    }
}
