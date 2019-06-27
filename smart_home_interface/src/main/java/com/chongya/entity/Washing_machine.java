package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("washing_machine")
public class Washing_machine implements Serializable {
    @TableId("wid")
    private int wid;
    private String wname;
    private int mode;
    private int time;
    private int switch_status;
    private int connect_status;

    @Override
    public String toString() {
        return "washing_machine{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", mode=" + mode +
                ", time=" + time +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
}
