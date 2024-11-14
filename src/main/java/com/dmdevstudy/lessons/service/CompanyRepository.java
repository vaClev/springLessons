package com.dmdevstudy.lessons.service;

import com.dmdevstudy.lessons.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;
    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
