package com.yhy.eduManagement.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grade {
    private int Sno;
    private int Cno;
    private int grade;

    public Grade(int Sno,int Cno){
        this.Cno=Cno;
        this.Sno=Sno;
    }
}
