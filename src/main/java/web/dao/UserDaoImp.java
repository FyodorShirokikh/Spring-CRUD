package web.dao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
    @Override
    public void delete(int id) {
        User tempUser = entityManager.find(User.class, id);
        entityManager.remove(tempUser);
    }
    @Override
    public void edit(int id, User user) {
        User tempUser = entityManager.find(User.class, id);
        tempUser.setId(user.getId());
        tempUser.setName(user.getName());
        tempUser.setLastname(user.getLastname());
        tempUser.setAge(user.getAge());
        entityManager.merge(tempUser);
    }
}
