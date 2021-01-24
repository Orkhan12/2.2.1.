package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<User> print(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u where (u.car.model= :modelName) AND (u.car.series =:seriesName)");
        query.setParameter("modelName", model);
        query.setParameter("seriesName", series);
        return query.getResultList();
    }
}
