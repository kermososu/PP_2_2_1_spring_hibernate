package hiber.dao;

import hiber.model.*;


import java.util.List;

public interface UserDao {
   void add(User user, Car car);
   User getUserWithCar(String model, int series);
   List<User> listUsers();
}
