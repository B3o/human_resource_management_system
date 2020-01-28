package com.bemore.domain;

import java.util.Date;

/**
 * 公告
 * @author Bmo
 * @date 2020/1/28 15:59
 */
public class Post {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String content;
//    发布人
    private Admin admin;
//    发布日期
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", admin=" + admin +
                ", date=" + date +
                '}';
    }
}
