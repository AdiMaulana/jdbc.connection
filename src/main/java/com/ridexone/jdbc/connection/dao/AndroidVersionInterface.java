package com.ridexone.jdbc.connection.dao;

import com.ridexone.jdbc.connection.model.AndroidVersion;
import java.util.List;

public interface AndroidVersionInterface {
    void insert(AndroidVersion version);
    AndroidVersion getById(int id);
    List<AndroidVersion> getAll();
    void update(AndroidVersion version);
    void delete(int id);
}
