package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
@TableName("speaker")
public class Speaker implements Serializable {
    @TableId("sid")
    private int sid;
    private String sname;
    private int volume;
    private int switch_status;
    private int connect_status;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
        return "Speaker{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", volume=" + volume +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }

    public Speaker(String sname, int volume, int switch_status, int connect_status) {
        this.sname = sname;
        this.volume = volume;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Speaker(int sid, String sname, int volume, int switch_status, int connect_status) {
        this.sid = sid;
        this.sname = sname;
        this.volume = volume;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Speaker() {
    }

}
