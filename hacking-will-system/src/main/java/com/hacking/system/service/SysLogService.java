package com.hacking.system.service;


import com.hacking.system.entity.SysLog;

/**
 * 系统日志表Service接口
 *
 * @author Jintingying
 * @date 2019/10/22 12:30:09
 */
public interface SysLogService {

        void saveSysLog(SysLog sysLog);
}
