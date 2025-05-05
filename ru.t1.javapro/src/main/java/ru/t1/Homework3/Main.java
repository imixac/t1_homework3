package ru.t1.Homework3;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.t1.Homework3.user.UserService;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        UserService userService = context.getBean(UserService.class);

        userService.deleteTable();
        userService.createTable();
        userService.insertUser("Petya");
        userService.insertUser("Vasya");
        userService.insertUser("Misha");
        System.out.println(userService.getUserById(1L));
        System.out.println(userService.getUserById(2L));
        System.out.println(userService.getUserById(3L));

        System.out.println(userService.getAllUsers());

        userService.deleteUser("Vasya");
        System.out.println(userService.getAllUsers());

    }
}