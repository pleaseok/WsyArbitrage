package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName MatchResults
 * @Description 当前和历史成交
 * @Author Sean
 * @Date 2019/4/14 0:44
 **/
@Data
public class MatchResults implements Serializable {
    private static final long serialVersionUID = 1866252557143669036L;
    private long createAt; // 成交时间
    private String filledAmount; // 成交数量
    private String filledFees; // 成交手续费
    private long id; // 订单成交记录
    private long matchId; // 撮合id
    private long orderId; // 订单id
    private String price; // 成交价格
    private String source; // 订单来源 api
    private String symbol; // 交易对
    private String type; // 订单类型 buy-market：市价买, sell-market：市价卖, buy-limit：限价买, sell-limit：限价卖, buy-ioc：IOC买单, sell-ioc：IOC卖单

}
