package com.example.waterpurifiermanagementsystem.util;


import org.springframework.stereotype.Component;

@Component
public class Result {
    private  int status;
    private  String message;
    private  int count;
    private  Object object;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /*
    * 封装返回的普通数据
    * */
    public Result message(int status,String message,Object object){
        this.setStatus(status);
        this.setMessage(message);
        this.setObject(object);
        return this;
    }
    public Result message(int status,String message){
        this.setStatus(status);
        this.setMessage(message);
        return this;
    }
    /*
    *
    * 封装返回的分页数据
    * */
    public Result pageMessage(int status,String message,int count,Object object){
        this.setStatus(status);
        this.setMessage(message);
        this.setObject(object);
        this.setCount(count);
        return this;
    }

}
