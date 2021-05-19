package com.lk;

import java.util.Objects;

/**
 * @author by LiuKui
 * @date 2021/3/23.
 */
public class Traintime {
    private int day, hour, minute;

    public Traintime() {
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
    }
    public Traintime(int day, int hour, int minute) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Traintime)) return false;
        Traintime traintime = (Traintime) o;
        return day == traintime.day &&
                hour == traintime.hour &&
                minute == traintime.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, hour, minute);
    }

    @Override
    public String toString() {
        return day + ":" +
                +hour + ":" +
                +minute;
    }

}
