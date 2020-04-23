package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;
import core.basesyntax.exceptions.InjectionException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] field = clazz.getDeclaredFields();
        for (Field test : field) {
            if (test.getDeclaredAnnotation(Inject.class) != null) {
                if (test.getType().equals(BetDao.class)
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    test.setAccessible(true);
                    test.set(instance, Factory.getBetDao());
                } else if (test.getType().equals(PersonDao.class)
                        && PersonDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    test.setAccessible(true);
                    test.set(instance, Factory.getPersonDao());
                } else {
                    throw new InjectionException("Failed to inject!!!");
                }
            }
        }
        return instance;
    }
}

