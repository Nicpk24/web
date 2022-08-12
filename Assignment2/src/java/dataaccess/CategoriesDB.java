package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import models.Category;

public class CategoriesDB {

    public List getCategories() {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        Query q = manager.createNamedQuery("Category.findAll");
        List list = q.getResultList();
        return list;
    }
    
    public Category getCategoryById(int id){
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        Category category = manager.find(Category.class, id);
        return category;
    }
    
}
