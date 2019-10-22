package com.hacking.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志表
 *
 * @author Jintingying
 * @date 2019/10/22 12:25:17
 */
@Data
@Entity
@Table(name = "sys_log")
public class SysLog implements Serializable {

    /**
     * 主键
     **/
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 日志类型（1登录日志，2操作日志）
     **/
    @Column(name = "LOG_TYPE")
    private int logType;

    /**
     * 日志内容
     **/
    @Column(name = "LOG_CONTENT")
    private String logContent;

    /**
     * 操作类型
     **/
    @Column(name = "OPERATE_TYPE")
    private int operateType;

    /**
     * 操作用户账号
     **/
    @Column(name = "USERID")
    private String userid;

    /**
     * 操作用户名称
     **/
    @Column(name = "USERNAME")
    private String username;

    /**
     * IP
     **/
    @Column(name = "IP")
    private String ip;

    /**
     * 请求java方法
     **/
    @Column(name = "METHOD")
    private String method;

    /**
     * 请求路径
     **/
    @Column(name = "REQUEST_URL")
    private String requestUrl;

    /**
     * 请求参数
     **/
    @Column(name = "REQUEST_PARAM")
    private String requestParam;

    /**
     * 请求类型
     **/
    @Column(name = "REQUEST_TYPE")
    private String requestType;

    /**
     * 耗时
     **/
    @Column(name = "COST_TIME")
    private Long costTime;

    /**
     * 创建人
     **/
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 创建时间
     **/
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新人
     **/
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 更新时间
     **/
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}
