package dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Item;
import models.User;

public class ItemsDB {

    public Boolean delete(int itemId, User owner) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Item itemToDelete = em.find(Item.class, itemId);
        if (itemToDelete != null) {
            try {
                User user = itemToDelete.getOwner();

                if (user.getEmail().equals(owner.getEmail())) {
                    user.getItemCollection().remove(itemToDelete);
                    trans.begin();
                    em.remove(em.merge(itemToDelete));
                    em.merge(user);
                    trans.commit();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                trans.rollback();
                return false;
            } finally {
                em.close();
            }
        }
        return false;
    }

    public boolean add(Item item) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            User user = item.getOwner();
            user.getItemCollection().add(item);
            trans.begin();
            em.persist(item);
            em.merge(user);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            trans.rollback();
            return false;
        } finally {
            em.close();
        }
    }
}
