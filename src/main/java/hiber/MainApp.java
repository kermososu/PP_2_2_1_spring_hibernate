package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Car1", 1000);
        Car car2 = new Car("Car2", 2000);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);

        userService.add(user1, car1);
        userService.add(user2, car2);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.print(user);
        }

        System.out.println(userService.getUserWithCar("Car1", 1000));
        System.out.println(userService.getUserWithCar("Car2", 2000));

        context.close();
    }
}
