package com.ridexone.jdbc.connection;

import com.ridexone.jdbc.connection.dao.AndroidVersionInterface;
import com.ridexone.jdbc.connection.dao.DaoFactory;
import com.ridexone.jdbc.connection.model.AndroidVersion;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AndroidVersionInterface dao = DaoFactory.getAndroidVersionDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Pilih Operasi:");
            System.out.println("1. Tambah Android Version");
            System.out.println("2. Lihat Semua Android Version");
            System.out.println("3. Edit Android Version");
            System.out.println("4. Hapus Android Version");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    tambahAndroidVersion(dao, scanner);
                    break;
                case 2:
                    lihatSemuaAndroidVersion(dao);
                    break;
                case 3:
                    editAndroidVersion(dao, scanner);
                    break;
                case 4:
                    hapusAndroidVersion(dao, scanner);
                    break;
                case 0:
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    private static void tambahAndroidVersion(AndroidVersionInterface dao, Scanner scanner) {
        System.out.print("Masukkan Nama Versi: ");
        String versionName = scanner.nextLine();
        System.out.print("Masukkan API Level: ");
        int apiLevel = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Masukkan Tanggal Rilis (YYYY-MM-DD): ");
        String[] tanggal = scanner.nextLine().split("-");
        Date releaseDate = new Date(Integer.parseInt(tanggal[0]) - 1900, Integer.parseInt(tanggal[1]) - 1, Integer.parseInt(tanggal[2]));

        AndroidVersion version = new AndroidVersion(0, versionName, apiLevel, releaseDate);
        dao.insert(version);
        System.out.println("Versi Android berhasil ditambahkan!");
    }

    private static void lihatSemuaAndroidVersion(AndroidVersionInterface dao) {
        List<AndroidVersion> versions = dao.getAll();
        System.out.println("Daftar Versi Android:");
        for (AndroidVersion version : versions) {
            System.out.println("ID: " + version.getId() + ", Nama Versi: " + version.getVersionName() + ", API Level: " + version.getApiLevel());
        }
    }

    private static void editAndroidVersion(AndroidVersionInterface dao, Scanner scanner) {
        System.out.print("Masukkan ID Versi yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Masukkan Nama Versi baru: ");
        String versionName = scanner.nextLine();
        System.out.print("Masukkan API Level baru: ");
        int apiLevel = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Masukkan Tanggal Rilis baru (YYYY-MM-DD): ");
        String[] tanggal = scanner.nextLine().split("-");
        Date releaseDate = new Date(Integer.parseInt(tanggal[0]) - 1900, Integer.parseInt(tanggal[1]) - 1, Integer.parseInt(tanggal[2]));

        AndroidVersion version = new AndroidVersion(id, versionName, apiLevel, releaseDate);
        dao.update(version);
        System.out.println("Versi Android berhasil diedit!");
    }

    private static void hapusAndroidVersion(AndroidVersionInterface dao, Scanner scanner) {
        System.out.print("Masukkan ID Versi yang ingin dihapus: ");
        int id = scanner.nextInt();
        dao.delete(id);
        System.out.println("Versi Android berhasil dihapus!");
    }
}
