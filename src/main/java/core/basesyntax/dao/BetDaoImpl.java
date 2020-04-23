package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.HashMap;

@Dao
public class BetDaoImpl implements BetDao {

    @Override
    public void add(Person person,Bet bet) {
        Storage.bets.put("id" + person.getId(),bet);
    }

    @Override
    public HashMap<String, Bet> getAll() {
        return Storage.bets;
    }
}
