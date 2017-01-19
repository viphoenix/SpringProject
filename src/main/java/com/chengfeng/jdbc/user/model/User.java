package com.chengfeng.jdbc.user.model;

/**
 * Created by chengfeng on 2017/1/18.
 */
public class User {
    int id;
    String name;
    String createTime;

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name, String createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("user信息: ");
        sb.append("id: ").append(id);
        sb.append(" name: ").append(name);
        sb.append(" createTime: ").append(createTime);

        return sb.toString();
    }
}
