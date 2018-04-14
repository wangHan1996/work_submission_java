package com.wh.workSubmission.entity;

import java.io.Serializable;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@TableName("work_release")
public class WorkRelease extends Model<WorkRelease> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("work_no")
    private String workNo;
    @TableField("work_name")
    private String workName;
    @TableField("course_no")
    private String courseNo;
    private String description;
    @TableField("release_time")
    private LocalDateTime releaseTime;
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorkRelease{" +
        "id=" + id +
        ", workNo=" + workNo +
        ", workName=" + workName +
        ", courseNo=" + courseNo +
        ", description=" + description +
        ", releaseTime=" + releaseTime +
        ", address=" + address +
        "}";
    }
}
