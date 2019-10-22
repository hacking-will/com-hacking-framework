package com.hacking.util.result;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/22
 */
public class ResultUtil {

    public static Object success(Object data){
        ResultInfo<Object> resultInfo = new ResultInfo<>();
        resultInfo.setCode(ResultEnum.SUCCESS.getCode());
        resultInfo.setDescription(ResultEnum.SUCCESS.getDesc());
        resultInfo.setData(data);
        return resultInfo;
    }
    public static Object success(int code, String desc, Object data){
        ResultInfo<Object> resultInfo = new ResultInfo<>();
        resultInfo.setCode(code);
        resultInfo.setDescription(desc);
        resultInfo.setData(data);
        return resultInfo;
    }

    public static Object fail(String message){
        ResultInfo<Object> resultInfo = new ResultInfo<>();
        resultInfo.setCode(ResultEnum.FAIL.getCode());
        resultInfo.setDescription(message);
        return resultInfo;
    }

    public static Object fail(int code, String message){
        ResultInfo<Object> resultInfo = new ResultInfo<>();
        resultInfo.setCode(code);
        resultInfo.setDescription(message);
        return resultInfo;
    }

    public static Object result(int code, String desc, Object data){
        ResultInfo<Object> resultInfo = new ResultInfo<>();
        resultInfo.setCode(code);
        resultInfo.setDescription(desc);
        resultInfo.setData(data);
        return resultInfo;
    }
}
