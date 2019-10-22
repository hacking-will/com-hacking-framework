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
public enum ResultEnum {

    /**
     * 操作成功
     */
    SUCCESS(0, "成功"),
    /**
     * 操作失败
     */
    FAIL(-1, "失败"),
    /**
     * 非法的参数
     */
    ILLEGAL_PARAMETER(112, "非法的参数"),
    ;

    private int code;
    private String desc;

    ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
