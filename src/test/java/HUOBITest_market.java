import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import top.code666.huobi.common.entity.BaseApiResponse;
import top.code666.huobi.common.entity.MarketApiResponse;
import top.code666.huobi.common.entity.TickersApiResponse;
import top.code666.huobi.common.entity.marketdata.*;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HUOBITest_market
 * @Description
 * @Author Sean
 * @Date 2019/4/13 16:45
 **/
public class HUOBITest_market {
    private ConnectManager cm = ConnectManager.getInstant();

    @Test
    public void testKLine(){
        Map<String,String> params = new HashMap<>();
        params.put("symbol","topusdt");
        params.put("period","1min");
        params.put("size","5");
        MarketApiResponse<List<KLine>> resp =
                cm.get("/market/history/kline", params, new TypeReference<MarketApiResponse<List<KLine>>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void testMergedDetails(){
        Map<String,String> params = new HashMap<>();
        params.put("symbol","topusdt");
        TickersApiResponse<Ticker> resp =
                cm.get("/market/detail/merged", params, new TypeReference<TickersApiResponse<Ticker>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void testNewTickers(){
        System.out.println(cm.get("/market/tickers", null, new TypeReference<MarketApiResponse<List<Tickers>>>() {
        }));
    }

    @Test
    public void getNewTrade1(){
        Map<String,String> param = new HashMap<>();
        param.put("symbol","topusdt");
        TickersApiResponse<Trade1> resp =
                cm.get("/market/trade", param, new TypeReference<TickersApiResponse<Trade1>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    @Test
    public void testNewTradeAll(){
        Map<String,String> params = new HashMap<>();
        params.put("symbol","topusdt");
        params.put("size","3");
        MarketApiResponse<List<TradeAll>> resp =
                cm.get("/market/history/trade", params, new TypeReference<MarketApiResponse<List<TradeAll>>>() {
                });
        System.out.println(resp);
    }

    @Test
    public void getTrade24(){
        Map<String,String> param = new HashMap<>();
        param.put("symbol","topusdt");
        TickersApiResponse<Detail24> resp =
                cm.get("/market/detail", param, new TypeReference<TickersApiResponse<Detail24>>() {
                });
        System.out.println(resp.checkAndReturn());
    }
}
