package com.hacking.system.repository;

import com.hacking.system.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 系统日志表Repository
 *
 * @author Jintingying
 * @date 2019/10/22 12:28:13
 */
@Repository
public interface SysLogRepository extends JpaRepository<SysLog, String>, JpaSpecificationExecutor {

}
