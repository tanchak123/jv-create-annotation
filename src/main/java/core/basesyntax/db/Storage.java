package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    public static final HashMap<String,Bet> bets = new HashMap<>();
    public static final List<Person> ids = new ArrayList<>();
}
