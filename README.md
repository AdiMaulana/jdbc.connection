# JDBC Connection Project
Dibuat Untuk Tugas Mata Kuliah Pemrograman Berbasis Objek 2

Tampilan program:

![Image](https://github.com/user-attachments/assets/85d73f6f-b65f-4e46-ae75-26fa5e645c0b)

Proyek ini adalah contoh aplikasi Java yang menggunakan JDBC untuk berinteraksi dengan database MySQL. Aplikasi ini memungkinkan pengguna untuk melakukan operasi CRUD (Create, Read, Update, Delete) pada tabel `android_version`.

## Fitur Utama
---------------

- **CRUD Operations**: Aplikasi ini menyediakan fitur untuk menambah, melihat, mengedit, dan menghapus data Android version.
- **Console-Based Interface**: Pengguna berinteraksi dengan aplikasi melalui antarmuka konsol.
- **MySQL Database Integration**: Aplikasi ini menggunakan JDBC untuk berinteraksi dengan database MySQL.

## Struktur Proyek
-------------------

- **`src/main/java`**: Berisi kode sumber Java untuk aplikasi, termasuk model data, DAO, dan kelas utama.
- **`src/main/resources`**: Berisi sumber daya yang tidak dikompilasi.
- **`src/test/java`**: Berisi kode sumber untuk pengujian unit.
- **`pom.xml`**: File konfigurasi Maven yang mengelola dependensi dan proses build.

## Cara Menjalankan Aplikasi
---------------------------

1. Pastikan Anda memiliki JDK dan Maven terinstal.
2. Jalankan perintah berikut di terminal untuk membangun dan menjalankan aplikasi:
```mvn clean compile exec:java -Dexec.mainClass="com.ridexone.jdbc.connection.Main```

3. Ikuti instruksi di konsol untuk melakukan operasi CRUD.

## Dependensi
-------------

- **MySQL Connector/J**: Digunakan untuk berinteraksi dengan database MySQL.
- **Junit**: Digunakan untuk pengujian unit.
```<dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## Lisensi
---------

Proyek ini dibuat untuk tujuan pendidikan dan dapat digunakan secara bebas.

## Contoh Kode
--------------

Berikut adalah contoh kode untuk menambahkan data Android version:
```public class AndroidVersionImpl implements AndroidVersionInterface{
    @Override
    public void insert(AndroidVersion version) {
        String sql = "INSERT INTO android_version (version_name, api_level, release_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, version.getVersionName());
            pstmt.setInt(2, version.getApiLevel());
            pstmt.setDate(3, new java.sql.Date(version.getReleaseDate().getTime()));
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```

## Kontribusi
--------------

Kontribusi sangat diterima. Silakan buat pull request jika Anda memiliki perubahan yang ingin disertakan.

## Kontak
---------

Jika Anda memiliki pertanyaan atau memerlukan bantuan, silakan hubungi [Adi Maulana](mailto:adi.maulana.amin@gmail.com).
