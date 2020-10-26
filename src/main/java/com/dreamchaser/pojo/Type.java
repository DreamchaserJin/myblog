package com.dreamchaser.pojo;

import java.util.Date;

/**
 * type
 * 
 * @author bianj
 * @version 1.0.0 2020-07-17
 */
public class Type implements java.io.Serializable {

    /** ID编号 */
    private Integer id;

    /** 专栏名称 */
    private String name;

    /** 专栏简介 */
    private String introduction;

    /** 博客数量 */
    private Integer number=null;

    /** 更新时间 */
    private Date date;


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
     * 获取专栏名称
     * 
     * @return 专栏名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置专栏名称
     * 
     * @param name
     *          专栏名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取专栏简介
     * 
     * @return 专栏简介
     */
    public String getIntroduction() {
        return this.introduction;
    }

    /**
     * 设置专栏简介
     * 
     * @param introduction
     *          专栏简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取博客数量
     * 
     * @return 博客数量
     */
    public Integer getNumber() {
        return this.number;
    }

    /**
     * 设置博客数量
     * 
     * @param number
     *          博客数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取更新时间
     * 
     * @return 更新时间
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * 设置更新时间
     * 
     * @param date
     *          更新时间
     */
    public void setDate(Date date) {
        this.date = date;
    }
}