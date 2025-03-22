package com.ridexone.jdbc.connection.model;

import java.util.Date;

public class AndroidVersion {
    private int id;
    private String versionName;
    private int apiLevel;
    private Date releaseDate;

    public AndroidVersion() {
    }

    public AndroidVersion(int id, String versionName, int apiLevel, Date releaseDate) {
        this.id = id;
        this.versionName = versionName;
        this.apiLevel = apiLevel;
        this.releaseDate = releaseDate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(int apiLevel) {
        this.apiLevel = apiLevel;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "AndroidVersion{" + "id=" + id + ", versionName=" + versionName + ", apiLevel=" + apiLevel + ", releaseDate=" + releaseDate + '}';
    }
}
