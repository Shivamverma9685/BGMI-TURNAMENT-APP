package com.example.clintapp;

public class dataclasse {

    String nuber,ref,gbmname;

    public dataclasse(String nuber, String ref, String gbmname) {
        this.nuber = nuber;
        this.ref = ref;
        this.gbmname = gbmname;
    }

    public String getNuber() {
        return nuber;
    }

    public void setNuber(String nuber) {
        this.nuber = nuber;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getGbmname() {
        return gbmname;
    }

    public void setGbmname(String gbmname) {
        this.gbmname = gbmname;
    }
}
