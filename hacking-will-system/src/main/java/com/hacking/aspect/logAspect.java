package com.hacking.aspect;

import com.alibaba.fastjson.JSONObject;
import com.hacking.annotation.AutoLog;
import com.hacking.system.entity.SysLog;
import com.hacking.system.service.SysLogService;
import com.hacking.util.HackingStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/19
 */
@Slf4j
@Aspect
@Component
public class logAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("execution(public * com.hacking..controller.*.*(..))")
    public void executeMethod() {

    }

    @Pointcut("@annotation(com.hacking.annotation.AutoLog)")
    public void executeAnnotaton() {

    }

    @Around("executeMethod() || executeAnnotaton()")
    public Object aroundMethodLog(ProceedingJoinPoint point) throws Throwable {
        log.info("LogInfo:-----------------------------------");
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        //执行时长(毫秒)
        long execTime = System.currentTimeMillis() - beginTime;
        log.info("执行时长(ms)： " + execTime);
        log.info("LogInfo:-----------------------------------");

        this.saveSysLog(point, execTime);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = new SysLog();
        // 获取请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        @SuppressWarnings("ConstantConditions") HttpServletRequest request = attributes.getRequest();
        //请求的URL
        sysLog.setRequestUrl( request.getRequestURL().toString());
        //请求的IP PS:使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
        sysLog.setIp( request.getRemoteAddr());
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." +  methodName + "()");
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = JSONObject.toJSONString(args);
            sysLog.setRequestParam(params);
        }catch (Exception e){

        }
        //耗时
        sysLog.setCostTime(time);
        //创建日期
        sysLog.setCreateTime(new Date());

        AutoLog syslog = method.getAnnotation(AutoLog.class);
        if(syslog != null){
            //注解上的描述,操作日志内容
            sysLog.setLogContent(syslog.context());
            sysLog.setOperateType(syslog.operateType().ordinal());
        }

        sysLog.setId(HackingStringUtils.randomUUID_32());
        sysLogService.saveSysLog(sysLog);
    }
}
