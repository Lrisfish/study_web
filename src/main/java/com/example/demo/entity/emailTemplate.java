package com.example.demo.entity;

import java.util.Date;

public class emailTemplate {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_email_template.EMAIL_TEMPLATE_ID
     *
     * @mbggenerated
     */
    private Integer emailTemplateId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_email_template.RELEASE_TIME
     *
     * @mbggenerated
     */
    private Date releaseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_email_template.STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_email_template.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_email_template.UPDATE_TIME
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_email_template.EMAIL_TEMPLATE_ID
     *
     * @return the value of tb_email_template.EMAIL_TEMPLATE_ID
     *
     * @mbggenerated
     */
    public Integer getEmailTemplateId() {
        return emailTemplateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_email_template.EMAIL_TEMPLATE_ID
     *
     * @param emailTemplateId the value for tb_email_template.EMAIL_TEMPLATE_ID
     *
     * @mbggenerated
     */
    public void setEmailTemplateId(Integer emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_email_template.RELEASE_TIME
     *
     * @return the value of tb_email_template.RELEASE_TIME
     *
     * @mbggenerated
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_email_template.RELEASE_TIME
     *
     * @param releaseTime the value for tb_email_template.RELEASE_TIME
     *
     * @mbggenerated
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_email_template.STATUS
     *
     * @return the value of tb_email_template.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_email_template.STATUS
     *
     * @param status the value for tb_email_template.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_email_template.CREATE_TIME
     *
     * @return the value of tb_email_template.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_email_template.CREATE_TIME
     *
     * @param createTime the value for tb_email_template.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_email_template.UPDATE_TIME
     *
     * @return the value of tb_email_template.UPDATE_TIME
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_email_template.UPDATE_TIME
     *
     * @param updateTime the value for tb_email_template.UPDATE_TIME
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}