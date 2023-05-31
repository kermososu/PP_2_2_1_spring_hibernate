package hiber.dao;

import hiber.model.*;
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
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(car);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User getUserWithCar(String model, int series) {

      String asd3 = "from User user where user.car.model = :model and user.car.series = :series";

      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(asd3);

      query.setParameter("model", model).setParameter("series", series);

      return query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}