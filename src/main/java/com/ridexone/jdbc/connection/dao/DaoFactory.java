package com.ridexone.jdbc.connection.dao;

import com.ridexone.jdbc.connection.dao.impl.AndroidVersionImpl;

public class DaoFactory {
    public static AndroidVersionInterface getAndroidVersionDAO() {
        return new AndroidVersionImpl();
    }
}
