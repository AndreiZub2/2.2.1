package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
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

      CarService carService = context.getBean(CarService.class);
      carService.add(new Car("Vaz", 2106));
      carService.add(new Car("Vaz", 2107));
      carService.add(new Car("Vaz", 2108));
      carService.add(new Car("Vaz", 2109));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<Car> cars = carService.listCar();
      for (Car car : cars) {
         System.out.println("Id = "+car.getId());
         System.out.println("Car model = "+car.getModel());
         System.out.println("Car series = "+car.getSeries());
         System.out.println();
      }
      System.out.println(userService.getUserAuto("Vaz", 2107));

      context.close();
   }
}
