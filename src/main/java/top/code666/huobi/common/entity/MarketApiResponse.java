package top.code666.huobi.common.entity;

import lombok.Data;
import top.code666.huobi.common.error.ApiException;

/**
 * @ClassName MarketApiResponse
 * @Description
 * @Author Sean
 * @Date 2019/4/13 1:19
 **/
@Data
public class MarketApiResponse {
    private String status;
    private String ch;
    private long ts;
    /*private T data;
    private String errCode;
    private String errMsg;

    public T checkAndReturn() {
        if ("ok".equals(status)) {
            if (null != data) return data;
        }
        throw new ApiException(errCode, errMsg);
    }*/
}
