package com.dreamchaser.pojo;

import java.util.Date;

/**
 * tag
 * 
 * @author 金昊霖
 * @version 1.0.0 2020-07-17
 */
public class Tag implements java.io.Serializable {

    /** 标签id编号 */
    private Integer id;

    /** 标签名称 */
    private String name;

    /** 博客数量 */
    private Integer number=0;

    /** 更新时间 */
    private Date date;


    /**
     * 获取标签id编号
     * 
     * @return 标签id编号
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置标签id编号
     * 
     * @param id
     *          标签id编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标签名称
     * 
     * @return 标签名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置标签名称
     * 
     * @param name
     *          标签名称
     */
    public void setName(String name) {
        this.name = name;
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