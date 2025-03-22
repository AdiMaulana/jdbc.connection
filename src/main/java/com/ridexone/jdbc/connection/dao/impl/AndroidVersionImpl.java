package com.ridexone.jdbc.connection.dao.impl;

import com.ridexone.jdbc.connection.dao.AndroidVersionInterface;
import com.ridexone.jdbc.connection.model.AndroidVersion;
import com.ridexone.jdbc.connection.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AndroidVersionImpl implements AndroidVersionInterface{
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

    @Override
    public AndroidVersion getById(int id) {
        String sql = "SELECT * FROM android_version WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new AndroidVersion(
                    rs.getInt("id"),
                    rs.getString("version_name"),
                    rs.getInt("api_level"),
                    rs.getDate("release_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AndroidVersion> getAll() {
        List<AndroidVersion> versions = new ArrayList<>();
        String sql = "SELECT * FROM android_version";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                versions.add(new AndroidVersion(
                    rs.getInt("id"),
                    rs.getString("version_name"),
                    rs.getInt("api_level"),
                    rs.getDate("release_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return versions;
    }

    @Override
    public void update(AndroidVersion version) {
        String sql = "UPDATE android_version SET version_name=?, api_level=?, release_date=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, version.getVersionName());
            pstmt.setInt(2, version.getApiLevel());
            pstmt.setDate(3, new java.sql.Date(version.getReleaseDate().getTime()));
            pstmt.setInt(4, version.getId());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM android_version WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
