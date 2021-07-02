package com.example.privatefinancialadvisor.beans;

public class Found {
    private String id;
    private String name;
    private String type;
    private String pinYinFullName;
    private String pinYinShortName;

    public Found(String id, String name, String type, String pinYinFullName, String pinYinShortName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pinYinFullName = pinYinFullName;
        this.pinYinShortName = pinYinShortName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPinYinFullName() {
        return pinYinFullName;
    }

    public void setPinYinFullName(String pinYinFullName) {
        this.pinYinFullName = pinYinFullName;
    }

    public String getPinYinShortName() {
        return pinYinShortName;
    }

    public void setPinYinShortName(String pinYinShortName) {
        this.pinYinShortName = pinYinShortName;
    }

    @Override
    public String toString() {
        return "Found{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", pinYinFullName='" + pinYinFullName + '\'' +
                ", pinYinShortName='" + pinYinShortName + '\'' +
                '}';
    }
}

