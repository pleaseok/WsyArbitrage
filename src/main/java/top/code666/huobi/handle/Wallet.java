package top.code666.huobi.handle;

import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.code666.huobi.common.entity.BaseApiResponse;
import top.code666.huobi.common.entity.wallet.*;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Wallet
 * @Description 我的钱包的相关API操作
 * @Author Sean
 * @Date 2019/4/9 21:29
 **/
public class Wallet {
    ConnectManager cm = ConnectManager.getInstant();
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @return java.lang.String
     * @Author Sean
     * @Description 虚拟币提现
     * @Date 23:12 2019/4/13
     * @Param [address, amount, currency, fee, chain, addrTag]
     **/
    public String createWithDraw(String address, String amount, String currency, String fee, String chain, String addrTag) {
        Map<String, String> params = new HashMap<>();
        params.put("address", address); // 提现地址，注意，仅支持官网中相应币种的地址
        params.put("amount", amount); // 提币数量
        params.put("currency", currency); // 资产类型
        params.put("fee", fee); // 转账手续费
        if (null != chain && currency.toUpperCase().contentEquals("USDT"))
            params.put("chain", "usdterc20"); // 提 USDT-ERC20 时需要设置此参数为 "usdterc20"，其他币种提现不需要设置此参数
        params.put("addr-tag", addrTag); // 虚拟币共享地址tag,适用于xrp,xem,bts,steem,eos,xmr - 整数字符串
        String data = cm.post("/v1/dw/withdraw/api/create", params, new TypeReference<String>() {
        });
        logger.info("提币id为:" + data);
        return data;
    }

    /**
     * @return java.lang.String
     * @Author Sean
     * @Description 取消提现
     * @Date 23:25 2019/4/13
     * @Param [withdrawId] 提现id
     **/
    public String cancelWithdraw(long withdrawId) {
        String data = cm.post("/v1/dw/withdraw-virtual/" + withdrawId + "/cancel", null, new TypeReference<String>() {
        });
        logger.info("提现id:" + data);
        return data;
    }

    /**
     * @return java.util.List<top.code666.huobi.common.entity.wallet.WithdrawDepositOut>
     * @Author Sean
     * @Description 重提记录
     * @Date 23:37 2019/4/13
     * @Param [currency, type, from, size]
     **/
    public List<WithdrawDepositOut> depositWithdraw(String currency, String type, String from, String size) {
        Map<String, String> params = new HashMap<>();
        params.put("currency", currency); // 币种
        params.put("type", type); // 充值或提现 deposit/withdraw
        params.put("from", from); // 查询起始ID
        params.put("size", size); // 查询记录大小
        BaseApiResponse<List<WithdrawDepositOut>> resp =
                cm.get("/v1/query/deposit-withdraw", params, new TypeReference<BaseApiResponse<List<WithdrawDepositOut>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @return java.lang.String
     * @Author Sean
     * @Description 创建订单
     * @Date 23:42 2019/4/13
     * @Param [accountId, symbol, type, amount, price, place]
     **/
    public String createOrder(String accountId, String symbol, String type, String amount, String price, String place) {
        Map<String, String> params = new HashMap<>();
        params.put("account-id", accountId); // 账户id
        params.put("symbol", symbol); // 交易对,例如btcusdt
        params.put("type", type); // 订单类型 buy-market\sell-market\buy-limit..
        /**
         * buy-limit 限价买入
         * sell-limit 限价卖出
         * buy-market 市价买入
         * sell-market 市价卖出
         * buy-limit-maker 当“下单价格”>=“市场最低卖出价”，订单提交后，系统将拒绝接受此订单；
         *                 当“下单价格”<“市场最低卖出价”，提交成功后，此订单将被系统接受。
         * sell-limit-maker 当“下单价格”<=“市场最高买入价”，订单提交后，系统将拒绝接受此订单；
         *                  当“下单价格”>“市场最高买入价”，提交成功后，此订单将被系统接受。
         **/
        params.put("amount", amount);
        params.put("price", price);
        params.put("place", place);
        BaseApiResponse<String> resp =
                cm.post("/v1/order/place", params, new TypeReference<BaseApiResponse<String>>() {
                });
        return resp.checkAndReturn(); // 下单单号
    }

    /**
     * @Author Sean
     * @Description 撤销订单
     * @Date 23:50 2019/4/13
     * @Param [orderId]
     * @return java.lang.String
    **/
    public String submitCancel(String orderId){
        String data =
                cm.post("/v1/order/orders/" + orderId + "/submitcancel", null, new TypeReference<String>() {
                });
        return data; // 下单单号
    }

    /**
     * @Author Sean
     * @Description 此接口发送批量撤销订单的请求
     * @Date 0:21 2019/4/14
     * @Param [accountId, symbol, side, size]
     * @return top.code666.huobi.common.entity.wallet.BatchCancelOpenOrdersOut
    **/
    public BatchCancelOpenOrdersOut BatchCancelOpenOrders(String accountId,String symbol,String side,String size){
        Map<String,String> params = new HashMap<>();
        params.put("account-id",accountId); // 账户ID
        params.put("symbol",symbol); // 交易对  |  单个交易对字符串，缺省将返回所有符合条件尚未成交订单
        params.put("side",side); // 主动交易方向	| “buy”或“sell”，缺省将返回所有符合条件尚未成交订单
        params.put("size",size); // 所需返回的记录数 默认100 [0,100]
        BaseApiResponse<BatchCancelOpenOrdersOut> resp =
                cm.post("/v1/order/orders/batchCancelOpenOrders", params, new TypeReference<BaseApiResponse<BatchCancelOpenOrdersOut>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @Author Sean
     * @Description 此接口同时为多个订单(基于id)发送取消请求
     * @Date 0:24 2019/4/14
     * @Param [orderIds]
     * @return java.util.Map
    **/
    public Map batchCancel(List orderIds){
        BaseApiResponse<Map<String,Object>> resp =
                cm.post("/v1/order/orders/batchcancel", orderIds, new TypeReference<BaseApiResponse<Map<String, Object>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @Author Sean
     * @Description 查询当前未成交订单
     * @Date 0:09 2019/4/14
     * @Param [accountId, symbol, side, size]
     * @return java.util.List<top.code666.huobi.common.entity.wallet.OpenOrdersOut>
    **/
    public List<OpenOrdersOut> openOrders(String accountId,String symbol,String side,String size){
        Map<String,String> params = new HashMap<>();
        params.put("account-id",accountId); // 账户ID,使用 GET /v1/account/accounts接口获得 现货交易用spot的id
        params.put("symbol",symbol); // 交易对 btcusdt
        params.put("side",side); // 指定只返回某一个方向的订单: buy\sell
        params.put("size",size); // 返回订单的数量，最大2000
        BaseApiResponse<List<OpenOrdersOut>> resp =
                cm.get("/v1/order/openOrders", params, new TypeReference<BaseApiResponse<List<OpenOrdersOut>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @Author Sean
     * @Description 此接口返回指定订单的最新状态和详情
     * @Date 0:31 2019/4/14
     * @Param [orderId]
     * @return top.code666.huobi.common.entity.wallet.OrderDetails
    **/
    public OrderDetails getOrderDetails(String orderId){
        BaseApiResponse<OrderDetails> resp =
                cm.get("/v1/order/orders/" + orderId, null, new TypeReference<BaseApiResponse<OrderDetails>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * @Author Sean
     * @Description 此接口返回指定订单的成交明细
     * @Date 0:39 2019/4/14
     * @Param [orderId]
     * @return java.util.List<top.code666.huobi.common.entity.wallet.DealDetail>
    **/
    public List<DealDetail> getDealDetail(String orderId){
        BaseApiResponse<List<DealDetail>> resp =
                cm.get("/v1/order/orders/" + orderId + "/matchresults", null, new TypeReference<BaseApiResponse<List<DealDetail>>>() {
                });
        return resp.checkAndReturn();
    }

    public List<MatchResults> getMatchResults(String symbol,String types,String startDate,String endDate,String from,String direct,String size){
        // 为什么参数要用map形式？只能怪这个火币的接口写的真坑爹！！参数名加个“-” ！
        Map<String,String> params = new HashMap<>();
        params.put("symbol",symbol); // 交易对
        params.put("types",types); // 查询的订单类型组合，使用','分割
        params.put("start-date",startDate); // 查询开始日期, 日期格式yyyy-mm-dd
        params.put("end-date",endDate); // 查询结束日期, 日期格式yyyy-mm-dd
        params.put("from",from); // 查询起始 ID
        params.put("direct",direct); // 查询方向
        params.put("size",size); // 查询记录大小 默认100 范围[0,100]
        BaseApiResponse<List<MatchResults>> resp =
                cm.get("/v1/order/matchresults", params, new TypeReference<BaseApiResponse<List<MatchResults>>>() {
                });
        return resp.checkAndReturn();
    }
}
