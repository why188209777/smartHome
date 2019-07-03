package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
@TableName("user")
public class User  implements Serializable{
    @TableId("uid")
    private int uid;
    private String uname;
    private String phone;
    private String emergency_phone;
    private String address;

    public User() {
    }

    public User(String uname, String phone, String emergency_phone, String address) {
        this.uname = uname;
        this.phone = phone;
        this.emergency_phone = emergency_phone;
        this.address = address;
    }

    public User(String address) {
        this.address = address;
    }

    public User(int uid, String uname, String phone, String emergency_phone, String address) {
        this.uid = uid;
        this.uname = uname;
        this.phone = phone;
        this.emergency_phone = emergency_phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", emergency_phone='" + emergency_phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergency_phone() {
        return emergency_phone;
    }

    public void setEmergency_phone(String emergency_phone) {
        this.emergency_phone = emergency_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


