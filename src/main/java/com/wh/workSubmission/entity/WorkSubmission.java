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
@TableName("work_submission")
public class WorkSubmission extends Model<WorkSubmission> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("work_no")
    private String workNo;
    @TableField("student_no")
    private String studentNo;
    private String address;
    @TableField("submission_time")
    private LocalDateTime submissionTime;
    private String status;


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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorkSubmission{" +
        "id=" + id +
        ", workNo=" + workNo +
        ", studentNo=" + studentNo +
        ", address=" + address +
        ", submissionTime=" + submissionTime +
        ", status=" + status +
        "}";
    }
}
