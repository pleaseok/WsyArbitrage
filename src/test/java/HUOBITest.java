import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import top.code666.huobi.common.entity.ApiResponse;
import top.code666.huobi.common.entity.baseinfo.Symbol;
import top.code666.huobi.common.entity.marketdata.KLine;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HUOBITest
 * @Description
 * @Author Sean
 * @Date 2019/4/9 22:14
 **/
public class HUOBITest {
    private ConnectManager cm = ConnectManager.getInstant();

    @Test
    public void testSymbol(){
        ApiResponse<List<Symbol>> resp =
                cm.get("/v1/common/symbols", null, new TypeReference<ApiResponse<List<Symbol>>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void getAllBi(){
        ApiResponse<List<String>> resp =
                cm.get("/v1/common/currencys", null, new TypeReference<ApiResponse<List<String>>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void getHuoBiNow(){
        ApiResponse<String> resp =
                cm.get("/v1/common/timestamp", null, new TypeReference<ApiResponse<String>>() {
                });
        System.out.println(resp.checkAndReturn());;
    }

    @Test
    public void getKLine(){
        Map<String,String> params = new HashMap<>();
        params.put("symbol","topusdt");
        params.put("period","1min");
        params.put("size","5");
        ApiResponse<List<KLine>> resp =
                cm.get("/market/history/kline", params, new TypeReference<ApiResponse<List<KLine>>>() {
                });
        System.out.println(resp);
    }
}
