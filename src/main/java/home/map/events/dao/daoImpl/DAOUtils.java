package home.map.events.dao.daoImpl;

import javax.persistence.EntityManager;

/**
 * Created by greg on 20.07.15.
 */
public class DAOUtils<T> {
    private EntityManager em = EntityManagerHelper.getInstance();

    public void add(T t) throws WritingDataException {
try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();
            throw new WritingDataException();
        }

    }

    public void delete(T t) throws WritingDataException {
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new WritingDataException();
        }
    }

    public void update(T t) throws WritingDataException {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new WritingDataException();
        }
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
