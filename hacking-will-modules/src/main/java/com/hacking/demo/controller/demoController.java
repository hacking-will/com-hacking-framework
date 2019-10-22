package com.hacking.demo.controller;

import com.hacking.annotation.AutoLog;
import com.hacking.util.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/22
 */

@Api
@RestController
@RequestMapping(value = "/demo")
public class demoController {

    @AutoLog
    @PostMapping(value = "/demoMethod")
    public Object demoMethod(){
        return ResultUtil.success(null);
    }

}
