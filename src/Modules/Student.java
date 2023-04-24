package Modules;

import dbConnect.DoConnection;

import java.sql.Connection;

public class Student {
    DoConnection connect=new DoConnection();
    Connection con=connect.getConnection();
    String name,username,password,phoneNo,email,status;
    int id;
    public Student(){

    }
    public Student(int id,String name,String username,String password,String phoneNo,String email ,String status){
       this.id=id;
       this.name=name;
       this.username=username;
       this.password=password;
       this.phoneNo=phoneNo;
       this.email=email;
       this.status=status;
    }
    public void setId(int id){
    }
    public int getId() {
        return id;
    }
    public void setName(String name){
    }
    public String getName(){
        return name;
    }
    public void setUsername(String username){
    }
    public  String getUsername(){
        return username;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public  String getPhoneNo(){
        return phoneNo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setStatus(String status){
        this.status=status;}
    public String getStatus(){
        return status;
    }
}
