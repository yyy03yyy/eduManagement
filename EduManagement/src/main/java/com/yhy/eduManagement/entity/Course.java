package com.yhy.eduManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private int no;
    private String name;
    private int address;
    private int credit;
    private String addressName;
    public Course(int no) {
        this.no = no;
    }

    public Course(int no, String name, int address, int credit) {
        this.no = no;
        this.name = name;
        this.address = address;
        this.credit = credit;
    }

    public Course(String name, int address, int credit) {
        this.name = name;
        this.address = address;
        this.credit = credit;
    }
}