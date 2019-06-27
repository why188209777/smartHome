package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("refrigerator")
public class Refrigerator implements Serializable {
    @TableId("rid")
    private int rid;
    private String rname;
    private int gear;
    private int switch_status;
    private int connect_status;

    @Override
    public String toString() {
        return "Refrigerator{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", gear=" + gear +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
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
