package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.HashMap;

public interface BetDao {

    void add(Person person, Bet bet);

    HashMap<String, Bet> getAll();
}
