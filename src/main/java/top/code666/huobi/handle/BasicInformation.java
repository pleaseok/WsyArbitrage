package top.code666.huobi.handle;

import com.fasterxml.jackson.core.type.TypeReference;
import top.code666.huobi.common.entity.ApiResponse;
import top.code666.huobi.common.entity.baseinfo.Symbol;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.List;

/**
 * @ClassName BasicInformation
 * @Description 基础信息的相关API操作
 * @Author Sean
 * @Date 2019/4/9 21:27
 **/
public class BasicInformation {
    private ConnectManager cm = ConnectManager.getInstant();

    /**
     * @Author Sean
     * @Description 获取所有交易对
     * @Date 21:59 2019/4/9
     * @Param []
     * @return java.util.List<top.code666.huobi.common.entity.baseinfo.Symbol>
    **/
    public List<Symbol> getAllSymbol(){
        ApiResponse<List<Symbol>> resp =
                cm.get("/v1/common/symbols", null, new TypeReference<ApiResponse<List<Symbol>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @Author Sean
     * @Description 获取所有币种
     * @Date 22:33 2019/4/9
     * @Param []
     * @return java.util.List<java.lang.String>
    **/
    public List<String> getAllBi(){
        ApiResponse<List<String>> resp =
                cm.get("/v1/common/currencys", null, new TypeReference<ApiResponse<List<String>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @Author Sean
     * @Description 从火币得到系统当前时间戳[1554820626567]
     * @Date 22:34 2019/4/9
     * @Param []
     * @return java.lang.String
    **/
    public String getHuoBiNow(){
        ApiResponse<String> resp =
                cm.get("/v1/common/timestamp", null, new TypeReference<ApiResponse<String>>() {
                });
        return resp.checkAndReturn();
    }
}
