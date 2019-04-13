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
public class MarketApiResponse<T> {
    private String status; // 状态
    private String ch; // 接口数据对应的数据流。部分接口没有对应数据流因此不返回此字段
    private long ts; // 北京时间的时间戳
    private T data; // 数据
    private String errCode; // 错误码
    private String errMsg; // 错误信息

    public T checkAndReturn() {
        if ("ok".equals(status)) {
            if (null != data) return data;
        }
        throw new ApiException(errCode, errMsg);
    }
}
