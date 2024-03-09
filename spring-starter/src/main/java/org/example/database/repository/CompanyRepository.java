package org.example.database.repository;

import org.example.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;

    private CompanyRepository(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    public static CompanyRepository of(ConnectionPool connectionPool){
        System.out.println("Repository has been created");
        return new CompanyRepository(connectionPool);
    }
}
