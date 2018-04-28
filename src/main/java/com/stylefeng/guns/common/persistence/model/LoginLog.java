package com.stylefeng.guns.common.persistence.model;

import java.util.Date;

import javax.persistence.Table;

/**
 * <p>
 * 登录记录
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
@Table(name = "sys_login_log")
public class LoginLog extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 日志名称
     */
    private String  logname;
    /**
     * 管理员id
     */
    private Integer userid;
    /**
     * 创建时间
     */
    private Date    createtime;
    /**
     * 是否执行成功
     */
    private String  succeed;
    /**
     * 具体消息
     */
    private String  message;
    /**
     * 登录ip
     */
    private String  ip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", logname=" + logname +
                ", userid=" + userid +
                ", createtime=" + createtime +
                ", succeed=" + succeed +
                ", message=" + message +
                ", ip=" + ip +
                "}";
    }
}
