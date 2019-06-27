package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("drinking_fountain")
public class Drinking_fountain implements Serializable {
    @TableId("did")
    private int did;
    private String dname;
    private int mode;
    private int switch_status;
    private int connect_status;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getSwitch_status() {
        return switch_status;
    }

    public void setSwitch_status(int switch_status) {
        this.switch_status = switch_status;
    }

    public int getConnect_status() {
        return connect_status;
    }

    public void setConnect_status(int connect_status) {
        this.connect_status = connect_status;
    }

    @Override
    public String toString() {
        return "Drinking_fountain{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", mode=" + mode +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }

    public Drinking_fountain(int did, String dname, int mode, int switch_status, int connect_status) {
        this.did = did;
        this.dname = dname;
        this.mode = mode;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Drinking_fountain(String dname, int mode, int switch_status, int connect_status) {
        this.dname = dname;
        this.mode = mode;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Drinking_fountain() {
    }
}
