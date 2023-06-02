package com.yhy.eduManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int no;
    private String name;
    private int sex;
    private int age;
    private String sexName;
    private String address;
    public Student(int no) {
        this.no = no;
    }
    public Student(int no, String name, int sex, int age,String address) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address=address;
    }
    public Student(String name, int sex, int age,String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address=address;
    }
}
