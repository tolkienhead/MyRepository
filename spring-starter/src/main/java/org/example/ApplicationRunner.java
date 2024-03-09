package org.example;

import org.example.database.pool.ConnectionPool;
import org.example.database.repository.CompanyRepository;
import org.example.database.repository.UserRepository;
import org.example.ioc.Container;
import org.example.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        }
    }
}
