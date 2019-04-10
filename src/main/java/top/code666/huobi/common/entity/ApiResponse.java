package top.code666.huobi.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import top.code666.huobi.common.error.ApiException;

/**
 * @ClassName ApiResponse
 * @Description
 * @Author Sean
 * @Date 2019/4/9 22:00
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    public String status; // 状态
    public String errCode; // 错误码
    public String errMsg;  // 错误信息
    public String ch; // 接口数据对应的数据流。部分接口没有对应数据流
    public long ts; // 北京时间的时间戳，单位毫秒
    public T data; // 数据体
    private T tick; // 数据体

    public T checkAndReturn() {
        if ("ok".equals(status)) {
            if (null != data) return data;
            if (null != tick) return tick;
        }
        throw new ApiException(errCode, errMsg);
    }
}
