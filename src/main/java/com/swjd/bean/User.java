package com.swjd.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value="user")
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private int uId;
    @TableField("uname")
    private String uName;
    @TableField("realname")
    private String  realName;
    @TableField("password")
    private String password;
    @TableField("flag")
    private String flag;

    public User() {
    }

    public User(String uName, String realName, String password, String flag) {
        this.uName = uName;
        this.realName = realName;
        this.password = password;
        this.flag = flag;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
