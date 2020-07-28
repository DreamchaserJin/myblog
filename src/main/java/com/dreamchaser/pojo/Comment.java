package com.dreamchaser.pojo;

import java.util.Date;

/**
 * comment
 * @author 金昊霖
 */
public class Comment implements java.io.Serializable {

    /** ID编号 */
    private Integer id;

    /** 发表评论的用户名称 */
    private String name;

    /** 邮箱地址 */
    private String email;

    /** 博客ID编号 */
    private Integer blog;

    /** 发布时间 */
    private Date time;

    /** 是否是管理员 */
    private Integer isAdmin;

    /** 评论内容 */
    private String content;

    /** 父评论的id */
    private Integer parent;

    public Comment(Integer id, String name, String email, Integer blog, Date time, Integer isAdmin, String content, Integer parent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.blog = blog;
        this.time = time;
        this.isAdmin = isAdmin;
        this.content = content;
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * 获取ID编号
     * 
     * @return ID编号
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置ID编号
     * 
     * @param id
     *          ID编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取发表评论的用户名称
     * 
     * @return 发表评论的用户名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置发表评论的用户名称
     * 
     * @param name
     *          发表评论的用户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取邮箱地址
     * 
     * @return 邮箱地址
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置邮箱地址
     * 
     * @param email
     *          邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取博客ID编号
     * 
     * @return 博客ID编号
     */
    public Integer getBlog() {
        return this.blog;
    }

    /**
     * 设置博客ID编号
     * 
     * @param blog
     *          博客ID编号
     */
    public void setBlog(Integer blog) {
        this.blog = blog;
    }

    /**
     * 获取发布时间
     * 
     * @return 发布时间
     */
    public Date getTime() {
        return this.time;
    }

    /**
     * 设置发布时间
     * 
     * @param time
     *          发布时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取是否是管理员
     * 
     * @return 是否是管理员
     */
    public Integer getIsAdmin() {
        return this.isAdmin;
    }

    /**
     * 设置是否是管理员
     * 
     * @param isAdmin
     *          是否是管理员
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

}