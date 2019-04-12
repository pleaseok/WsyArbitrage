package top.code666.huobi.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import top.code666.huobi.common.error.ApiException;

/**
 * @ClassName BaseApiResponse
 * @Description
 * @Author Sean
 * @Date 2019/4/9 22:00
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseApiResponse<T> {

    private String status; // 状态
    private String errCode; // 错误码
    private String errMsg;  // 错误信息
    private T data; // 数据体

    public T checkAndReturn() {
        if ("ok".equals(status)) {
            if (null != data) return data;
        }
        throw new ApiException(errCode, errMsg);
    }
}
