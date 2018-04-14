package com.wh.workSubmission.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public class Classes extends Model<Classes> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("classes_no")
    private String classesNo;
    @TableField("classes_name")
    private String classesName;
    @TableField("profession_no")
    private String professionNo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassesNo() {
        return classesNo;
    }

    public void setClassesNo(String classesNo) {
        this.classesNo = classesNo;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getProfessionNo() {
        return professionNo;
    }

    public void setProfessionNo(String professionNo) {
        this.professionNo = professionNo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Classes{" +
        "id=" + id +
        ", classesNo=" + classesNo +
        ", classesName=" + classesName +
        ", professionNo=" + professionNo +
        "}";
    }
}
