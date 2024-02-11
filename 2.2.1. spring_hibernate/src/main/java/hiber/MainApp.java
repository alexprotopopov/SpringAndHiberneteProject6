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
        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        userService.addCar(new Car("Lada", "111"));
        userService.addCar(new Car("BMW", "222"));
        userService.addCar(new Car("LandRover", "333"));
        userService.addCar(new Car("Porsche", "444"));
        List<User> users = userService.listUsers();

        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail() + user);
            System.out.println("Model = " + user.getUserCar().getModel());
            System.out.println("Series = " + user.getUserCar().getSeries());
            System.out.println();
        }

        System.out.println(userService.infoUser("BMW", "222"));

        context.close();
    }
}
