package com.wh.workSubmission.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;


public class Profession extends Model<Profession> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("profession_no")
    private String professionNo;
    @TableField("profession_name")
    private String professionName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfessionNo() {
        return professionNo;
    }

    public void setProfessionNo(String professionNo) {
        this.professionNo = professionNo;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Profession{" +
        "id=" + id +
        ", professionNo=" + professionNo +
        ", professionName=" + professionName +
        "}";
    }
}
