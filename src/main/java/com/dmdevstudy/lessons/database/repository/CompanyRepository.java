package com.dmdevstudy.lessons.database.repository;

import com.dmdevstudy.lessons.bpp.InjectBean;
import com.dmdevstudy.lessons.database.pool.ConnectionPool;

public class CompanyRepository {
    @InjectBean
    private ConnectionPool connectionPool;
    private CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    public static CompanyRepository of(ConnectionPool connPool)
    {
        return new CompanyRepository(connPool);
    }
}
