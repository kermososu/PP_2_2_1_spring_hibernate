package hiber.dao;

import hiber.model.*;


import java.util.List;

public interface UserDao {
   void add(User user, Car car);
   User getUserByModelAndSeries(String model, int series);
   List<User> listUsers();
}
