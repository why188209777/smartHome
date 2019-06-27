package com.chongya.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("tv")
public class Tv implements Serializable {
    @TableId("tid")
    private int tid;
    private int channel;
    private int volume;
    private int switch_status;
    private int connect_status;

    public Tv() {
    }

    public Tv(int tid, int channel, int volume, int switch_status, int connect_status) {
        this.tid = tid;
        this.channel = channel;
        this.volume = volume;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public Tv(int channel, int volume, int switch_status, int connect_status) {
        this.channel = channel;
        this.volume = volume;
        this.switch_status = switch_status;
        this.connect_status = connect_status;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSwitch_status(int switch_status) {
        this.switch_status = switch_status;
    }

    public void setConnect_status(int connect_status) {
        this.connect_status = connect_status;
    }

    public int getTid() {
        return tid;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public int getSwitch_status() {
        return switch_status;
    }

    public int getConnect_status() {
        return connect_status;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "tid=" + tid +
                ", channel=" + channel +
                ", volume=" + volume +
                ", switch_status=" + switch_status +
                ", connect_status=" + connect_status +
                '}';
    }
}
