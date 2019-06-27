package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("air_conditioning")
public class Air_conditioning implements Serializable {
    @TableId("aid")
    private int aid;
    private String aname;
    private int temp;
    private int mode;
    private int speed;
    private int time;
    private int direction;
    private int switch_status;
    private int connect_status;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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

    public Air_conditioning() {
    }

    public Air_conditioning(int aid, String aname, int temp, int mode, int speed, int time, int direction, int switch_status, int connect_status) {
        this.aid = aid;
        this.aname = aname;
        this.temp = temp;
        this.mode = mode;
        this.speed = speed;
        this.time = time;
        this.direction = direction;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Air_conditioning(String aname, int temp, int mode, int speed, int time, int direction, int switch_status, int connect_status) {
        this.aname = aname;
        this.temp = temp;
        this.mode = mode;
        this.speed = speed;
        this.time = time;
        this.direction = direction;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    @Override
    public String toString() {
        return "Air_conditioning{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", temp=" + temp +
                ", mode=" + mode +
                ", speed=" + speed +
                ", time=" + time +
                ", direction=" + direction +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }
}
