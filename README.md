# jdbc.connection
Tugas Mata Kuliah Pemrograman Berbasis Objek 2

Tampilan program:

![Image](https://github.com/user-attachments/assets/0a74dd44-395f-4b08-8265-c38289f8954f)

berikut code untuk melakukan crud menggunakan DaoFactory:

```package com.ridexone.jdbc.connection.dao;

import com.ridexone.jdbc.connection.model.AndroidVersion;
import java.util.List;

public interface AndroidVersionInterface {
    void insert(AndroidVersion version);
    AndroidVersion getById(int id);
    List<AndroidVersion> getAll();
    void update(AndroidVersion version);
    void delete(int id);
}
```

