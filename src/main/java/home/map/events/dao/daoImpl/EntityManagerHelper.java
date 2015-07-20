package home.map.events.dao.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by greg on 20.07.15.
 */
public class EntityManagerHelper {
    private static EntityManager entityManager;

    public static EntityManager getInstance() {
        if(entityManager == null){
            initialize();
        }
        return entityManager;
    }

    private EntityManagerHelper() {
    }



    private static  void initialize() {
        entityManager = Persistence.createEntityManagerFactory("DB").createEntityManager();
    }

    public static void close() {
        if (entityManager != null)
            entityManager.close();
    }
}
