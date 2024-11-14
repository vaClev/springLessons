package com.dmdevstudy.lessons.service;

import com.dmdevstudy.lessons.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;
    private CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    public static CompanyRepository of(ConnectionPool connPool)
    {
        return new CompanyRepository(connPool);
    }
}
