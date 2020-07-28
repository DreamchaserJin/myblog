package com.dreamchaser.pojo;

import java.util.Date;
import java.util.Objects;

public class CommentCombination {
    /**
     * ID编号
     */
    private Integer id;

    /**
     * 发表评论的用户名称
     */
    private String name;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 博客ID名称
     */
    private String blog;

    /**
     * 发布时间
     */
    private Date time;

    /**
     * 是否是管理员
     */
    private Integer isAdmin;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父评论的id
     */
    private Integer parent;

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

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
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public CommentCombination(Integer id, String name, String email, String blog, Date time, Integer isAdmin, String content, Integer parent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.blog = blog;
        this.time = time;
        this.isAdmin = isAdmin;
        this.content = content;
        this.parent = parent;
    }

    public CommentCombination(Comment comment, Blog blog) {
        this.id = comment.getId();
        this.name = comment.getName();
        this.email = comment.getEmail();
        this.blog = blog.getTitle();
        this.time = comment.getTime();
        this.isAdmin = comment.getIsAdmin();
        this.content = comment.getContent();
        this.parent = comment.getParent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentCombination that = (CommentCombination) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(blog, that.blog) &&
                Objects.equals(time, that.time) &&
                Objects.equals(isAdmin, that.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, blog, time, isAdmin, content, parent);
    }
}
