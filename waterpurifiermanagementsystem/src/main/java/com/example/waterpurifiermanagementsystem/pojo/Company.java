package com.example.waterpurifiermanagementsystem.pojo;

public class Company {
    private Integer id;

    private String name;

    private Integer totalcompanyid;

    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTotalcompanyid() {
        return totalcompanyid;
    }

    public void setTotalcompanyid(Integer totalcompanyid) {
        this.totalcompanyid = totalcompanyid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}