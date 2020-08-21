package com.dreamchaser.pojo;

import java.util.Date;

/**
 * blog
 * 
 */
public class Blog {

    /** ID编号 */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客摘要 */
    private String summary;

    /** 博客内容 */
    private String content;

    /** 发布时间 */
    private Date date;

    /** 所属专栏 */
    private Integer type;

    /** 浏览量 */
    private Integer views=0;

    /** 标签 */
    private String tags;

    /** 评论 */
    private String comments;

    /** 首图地址 */
    private String pictureUrl;

    /** 是否开启推荐 */
    private Integer isRecommend=0;

    /** 是否开启转载声明 */
    private Integer isReprint=0;

    /** 是否开启赞赏 */
    private Integer isAppreciation=0;

    /** 是否开启评论 */
    private Integer isComment=0;

    /** 1.原创；2.转载；3.翻译 */
    private Integer property=1;

    /** 状态：0.草稿；1.已发布 */
    private Integer state;


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
     * 获取博客标题
     * 
     * @return 博客标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置博客标题
     * 
     * @param title
     *          博客标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取博客摘要
     * 
     * @return 博客摘要
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * 设置博客摘要
     * 
     * @param summary
     *          博客摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取博客内容
     * 
     * @return 博客内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置博客内容
     * 
     * @param content
     *          博客内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取发布时间
     * 
     * @return 发布时间
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * 设置发布时间
     * 
     * @param date
     *          发布时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取所属专栏
     * 
     * @return 所属专栏
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 设置所属专栏
     * 
     * @param type
     *          所属专栏
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取浏览量
     * 
     * @return 浏览量
     */
    public Integer getViews() {
        return this.views;
    }

    /**
     * 设置浏览量
     * 
     * @param views
     *          浏览量
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取标签
     * 
     * @return 标签
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * 设置标签
     * 
     * @param tags
     *          标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取评论
     * 
     * @return 评论
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * 设置评论
     * 
     * @param comments
     *          评论
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取首图地址
     * 
     * @return 首图地址
     */
    public String getPictureUrl() {
        return this.pictureUrl;
    }

    /**
     * 设置首图地址
     * 
     * @param pictureUrl
     *          首图地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取是否开启推荐
     * 
     * @return 是否开启推荐
     */
    public Integer getIsRecommend() {
        return this.isRecommend;
    }

    /**
     * 设置是否开启推荐
     * 
     * @param isRecommend
     *          是否开启推荐
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取是否开启转载声明
     * 
     * @return 是否开启转载声明
     */
    public Integer getIsReprint() {
        return this.isReprint;
    }

    /**
     * 设置是否开启转载声明
     * 
     * @param isReprint
     *          是否开启转载声明
     */
    public void setIsReprint(Integer isReprint) {
        this.isReprint = isReprint;
    }

    /**
     * 获取是否开启赞赏
     * 
     * @return 是否开启赞赏
     */
    public Integer getIsAppreciation() {
        return this.isAppreciation;
    }

    /**
     * 设置是否开启赞赏
     * 
     * @param isAppreciation
     *          是否开启赞赏
     */
    public void setIsAppreciation(Integer isAppreciation) {
        this.isAppreciation = isAppreciation;
    }

    /**
     * 获取是否开启评论
     * 
     * @return 是否开启评论
     */
    public Integer getIsComment() {
        return this.isComment;
    }

    /**
     * 设置是否开启评论
     * 
     * @param isComment
     *          是否开启评论
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * 获取1.原创；2.转载；3.翻译
     * 
     * @return 1.原创；2.转载；3.翻译
     */
    public Integer getProperty() {
        return this.property;
    }

    /**
     * 设置1.原创；2.转载；3.翻译
     * 
     * @param property
     *          1.原创；2.转载；3.翻译
     */
    public void setProperty(Integer property) {
        this.property = property;
    }

    /**
     * 获取状态：0.草稿；1.已发布
     * 
     * @return 状态
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置状态：0.草稿；1.已发布
     * 
     * @param state
     *          状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

}