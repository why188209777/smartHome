package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("Lamp")
public class Lamp implements Serializable {
    @TableId("lid")
    private int lid;
    private String lname;
    private int mode;
    private int switch_status;
    private int connect_status;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
        return "Lamp{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", mode=" + mode +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }

    public Lamp(int lid, String lname, int mode, int switch_status, int connect_status) {
        this.lid = lid;
        this.lname = lname;
        this.mode = mode;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Lamp(String lname, int mode, int switch_status, int connect_status) {
        this.lname = lname;
        this.mode = mode;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Lamp() {
    }
}
