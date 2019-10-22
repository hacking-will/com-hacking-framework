package com.hacking.system.service.impl;

import com.hacking.system.entity.SysLog;
import com.hacking.system.repository.SysLogRepository;
import com.hacking.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 系统日志表Service接口实现
 *
 * @author Jintingying
 * @date 2019/10/22 05:15:02
 */
@Service
public class SysLogServiceImpl implements SysLogService,Serializable{
    @Autowired
    private SysLogRepository sysLogRepository;

    @Transactional
    @Override
    public void saveSysLog(SysLog sysLog){
        this.sysLogRepository.save(sysLog);
    }
}