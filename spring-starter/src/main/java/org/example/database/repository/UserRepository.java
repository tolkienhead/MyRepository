package org.example.database.repository;

import org.example.database.pool.ConnectionPool;

import java.sql.Connection;

public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }
}
