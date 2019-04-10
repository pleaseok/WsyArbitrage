package top.code666.huobi.common.error;

/**
 * @ClassName ApiException
 * @Description
 * @Author Sean
 * @Date 2019/4/9 21:44
 **/
public class ApiException extends RuntimeException {

    final String errCode;

    public ApiException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public ApiException(Exception e) {
        super(e);
        this.errCode = e.getClass().getName();
    }

    public String getErrCode() {
        return this.errCode;
    }

}
