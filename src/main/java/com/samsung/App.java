package com.samsung;

import com.samsung.domain.Country;
import com.samsung.repository.CountryRepository;
import com.samsung.service.CusDemo;
import com.samsung.service.CusDemoService;
import org.h2.tools.Console;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);


//        CusDemo libraryDemo = context.getBean(CusDemo.class);
//        libraryDemo.mealDemo();
//        libraryDemo.cusDemo();
//        context.close();

//        try {
//            Console.main(args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
