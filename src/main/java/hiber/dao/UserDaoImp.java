package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
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
        String hql = "from User";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.getResultList();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserByModelAndSeries(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().
                createQuery("from User where model = :paramName");
        query.setParameter("paramName",model);
        return query.getResultList();
    }

}
