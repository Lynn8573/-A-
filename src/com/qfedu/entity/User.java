package com.qfedu.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String sex;
    private String mail;

    public User() {
    }

    public User(int id, String username, String password, String phone, String sex, String mail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public User(String username, String password, String phone, String sex, String mail) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.mail = mail;
    }
}
