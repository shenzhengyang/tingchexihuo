package com.example.zy.happyrun.Login.Entity;

/**
 * Created by zy on 2016/8/12.
 */
public class Logout_entity {
    private Long num;
    private String name;
    private String password;
    public Logout_entity(){
        super();
    }

    public Logout_entity(Long num, String name, String password) {
        this.num = num;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Logout_entity{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
