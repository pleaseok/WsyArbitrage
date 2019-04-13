package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName OpenOrdersOut
 * @Description
 * @Author Sean
 * @Date 2019/4/13 23:51
 **/
@Data
public class OpenOrdersOut implements Serializable {
    private static final long serialVersionUID = 8627352478985657709L;
    private long id; // 订单id
    private String symbol; // 交易对 btcusdt
    private String price; // limit order的交易价格
    private long createAt; // 订单创建的北京时间戳 毫秒
    private String type; // 订单类型
    private String filledAmount; // 订单中已成交部分的数量
    private String filledCashAmount; // 订单中已成交部分的总价格
    private String filledfees; // 已交交易手续费总额
    private String source; // 现货填写api
    private String state; // 订单状态，包括submitted,partical-filled,cancelling
}
