package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class DtoNewUser {
    @SerializedName("cnamaus")
    private String cnamaus;
    @SerializedName("cpassword")
    private String cpassword;
    @SerializedName("level")
    private String level;

    public DtoNewUser(String cnamaus, String cpassword, String level) {
        this.cnamaus = cnamaus;
        this.cpassword = cpassword;
        this.level = level;
    }

    public String getCnamaus() {
        return cnamaus;
    }

    public void setCnamaus(String cnamaus) {
        this.cnamaus = cnamaus;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
