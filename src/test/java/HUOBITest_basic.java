import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import top.code666.huobi.common.entity.BaseApiResponse;
import top.code666.huobi.common.entity.baseinfo.Symbol;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.List;

/**
 * @ClassName HUOBITest_basic
 * @Description
 * @Author Sean
 * @Date 2019/4/9 22:14
 **/
public class HUOBITest_basic {
    private ConnectManager cm = ConnectManager.getInstant();

    @Test
    public void testSymbol(){
        BaseApiResponse<List<Symbol>> resp =
                cm.get("/v1/common/symbols", null, new TypeReference<BaseApiResponse<List<Symbol>>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void getAllBi(){
        BaseApiResponse<List<String>> resp =
                cm.get("/v1/common/currencys", null, new TypeReference<BaseApiResponse<List<String>>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void getHuoBiNow(){
        BaseApiResponse<String> resp =
                cm.get("/v1/common/timestamp", null, new TypeReference<BaseApiResponse<String>>() {
                });
        System.out.println(resp.checkAndReturn());;
    }
}
