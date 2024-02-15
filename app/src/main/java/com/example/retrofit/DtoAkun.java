package com.example.retrofit;


import com.google.gson.annotations.SerializedName;

public class DtoAkun {
    @SerializedName("id_akun")
    private  String idAkun;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("level")
    private String level;

    public DtoAkun(String idAkun, String username, String password, String level) {
        this.idAkun = idAkun;
        this.username = username;
        this.password = password;
        this.level = level;
    }
    @Override
    public String toString() {
        return "{" +
                "id_akun='" + idAkun + '\'' +
                ", username=" + username +
                ", password=" + password +
                ", level=" + level +
                '}';
    }
    public String getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(String idAkun) {
        this.idAkun = idAkun;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
