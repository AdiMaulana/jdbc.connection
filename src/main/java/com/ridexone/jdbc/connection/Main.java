package com.ridexone.jdbc.connection;

import com.ridexone.jdbc.connection.dao.DaoFactory;
import com.ridexone.jdbc.connection.model.AndroidVersion;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AndroidVersion version = new AndroidVersion(
            0,  
            "Android 15", 
            34, 
            new Date() 
        );

        // Insert
        DaoFactory.getAndroidVersionDAO().insert(version);
        System.out.println("Insert berhasil!");

        // Get All
        List<AndroidVersion> versions = DaoFactory.getAndroidVersionDAO().getAll();
        System.out.println("Daftar Versi Android:");
        versions.forEach(v -> System.out.println(v.getVersionName()));
    }
}
