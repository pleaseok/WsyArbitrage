package top.code666.huobi.common.entity;

import lombok.Data;
import top.code666.huobi.common.error.ApiException;

/**
 * @ClassName TickersApiResponse
 * @Description
 * @Author Sean
 * @Date 2019/4/13 2:24
 **/
@Data
public class TickersApiResponse<T> {
    private String status;
    private String ch;
    private long ts;
    public String errCode;
    public String errMsg;
    private T tick;

    public T checkAndReturn() {
        if ("ok".equals(status)) {
            if (null != tick) return tick;
        }
        throw new ApiException(errCode, errMsg);
    }
}
