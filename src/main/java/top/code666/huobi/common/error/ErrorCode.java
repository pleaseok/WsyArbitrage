package top.code666.huobi.common.error;

public enum ErrorCode {

    BAD_REQUEST(-1,"错误请求"),
    INVALID_PARAMETER(10001,"参数错误"),
    INVALID_COMMAND(10002,"指令错误"),
    BASE_SYMBOL_ERROR(10003,"交易对不存在"),
    BASE_CURRENCY_ERROR(10004,"币种不存在"),
    BASE_DATE_ERROR(10005,"错误的日期格式"),
    ;


    private Integer code;
    private String msg;

    private ErrorCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
