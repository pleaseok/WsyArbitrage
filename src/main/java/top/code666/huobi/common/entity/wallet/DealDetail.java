package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName DealDetail
 * @Description 成交明细
 * @Author Sean
 * @Date 2019/4/14 0:35
 **/
@Data
public class DealDetail implements Serializable {
    private static final long serialVersionUID = -4607058435947412630L;
    private long createdAt; // 成交明细
    private String filledAmount; // 成交数量
    private String filledFees; // 成交手续费
    private long id; // 订单成交记录id
    private long matchId; // 撮合id
    private String price; // 成交价格
    private String source; // 订单来源 api
    private String symbol; // 交易对 btcusdt
    private String type; // 订单类型 buy-market：市价买, sell-market：市价卖, buy-limit：限价买, sell-limit：限价卖, buy-ioc：IOC买单, sell-ioc：IOC卖单
}
