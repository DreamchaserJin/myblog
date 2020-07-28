package com.dreamchaser.pojo;
import java.util.Date;
import java.util.List;

/**
 * blog
 *
 */

public class BlogCombination {

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
    private Type type;

    /** 浏览量 */
    private Integer views=563;

    /** 标签 */
    private List<Tag> tags;

    /** 评论 */
    private List<Comment> comments;

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
    private Integer property;

    /** 状态：0.草稿；1.已发布 */
    private Integer state;

    public BlogCombination(Integer id, String title, String summary, String content, Date date, Type type, Integer views, List<Tag> tags, List<Comment> comments, String pictureUrl, Integer isRecommend, Integer isReprint, Integer isAppreciation, Integer isComment, Integer property, Integer state) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.date = date;
        this.type = type;
        this.views = views;
        this.tags = tags;
        this.comments = comments;
        this.pictureUrl = pictureUrl;
        this.isRecommend = isRecommend;
        this.isReprint = isReprint;
        this.isAppreciation = isAppreciation;
        this.isComment = isComment;
        this.property = property;
        this.state = state;
    }
    public BlogCombination(Blog blog,Type type,List<Tag> tags,List<Comment> comments) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.date = blog.getDate();
        this.type = type;
        this.views = blog.getViews();
        this.tags = tags;
        this.comments = comments;
        this.pictureUrl = blog.getPictureUrl();
        this.isRecommend = blog.getIsRecommend();
        this.isReprint = blog.getIsReprint();
        this.isAppreciation = blog.getIsAppreciation();
        this.isComment = blog.getIsComment();
        this.property = blog.getProperty();
        this.state = blog.getState();
    }
    public BlogCombination(Blog blog,Type type,List<Tag> tags) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.date = blog.getDate();
        this.type = type;
        this.views = blog.getViews();
        this.tags = tags;
        this.pictureUrl = blog.getPictureUrl();
        this.isRecommend = blog.getIsRecommend();
        this.isReprint = blog.getIsReprint();
        this.isAppreciation = blog.getIsAppreciation();
        this.isComment = blog.getIsComment();
        this.property = blog.getProperty();
        this.state = blog.getState();
    }
    public BlogCombination(Blog blog,Type type) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.date = blog.getDate();
        this.type = type;
        this.views = blog.getViews();
        this.pictureUrl = blog.getPictureUrl();
        this.isRecommend = blog.getIsRecommend();
        this.isReprint = blog.getIsReprint();
        this.isAppreciation = blog.getIsAppreciation();
        this.isComment = blog.getIsComment();
        this.property = blog.getProperty();
        this.state = blog.getState();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }



    public Integer getViews() {
        return views;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }



    public List<Comment> getComments() {
        return comments;
    }



    public String getPictureUrl() {
        return pictureUrl;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public Integer getIsReprint() {
        return isReprint;
    }

    public Integer getIsAppreciation() {
        return isAppreciation;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public Integer getProperty() {
        return property;
    }

    public Integer getState() {
        return state;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public void setViews(Integer views) {
        this.views = views;
    }

    public Type getType() {
        return type;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public void setIsReprint(Integer isReprint) {
        this.isReprint = isReprint;
    }

    public void setIsAppreciation(Integer isAppreciation) {
        this.isAppreciation = isAppreciation;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BlogCombination{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", views=" + views +
                ", tags=" + tags +
                ", comments=" + comments +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", isRecommend=" + isRecommend +
                ", isReprint=" + isReprint +
                ", isAppreciation=" + isAppreciation +
                ", isComment=" + isComment +
                ", property=" + property +
                ", state=" + state +
                '}';
    }
}