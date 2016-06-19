package ru.orbot90.mybatistest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.orbot90.mybatistest.model.User;
import ru.orbot90.mybatistest.service.FooService;

/**
 * Created by orbot on 19.06.16.
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("ru.orbot90");
        applicationContext.refresh();
        User user = applicationContext.getBean(FooService.class).doSomeBusinessStuff("1234");
        System.out.println(user);
    }
}
