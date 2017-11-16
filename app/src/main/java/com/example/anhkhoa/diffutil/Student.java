package com.example.anhkhoa.diffutil;

/**
 * Created by anh khoa on 11/16/2017.
 */

public class Student {
    public String ten;
    public String lop;
    public int stt;

    public Student() {
    }

    public Student(String ten, String lop, int stt) {
        this.ten = ten;
        this.lop = lop;
        this.stt = stt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
}
