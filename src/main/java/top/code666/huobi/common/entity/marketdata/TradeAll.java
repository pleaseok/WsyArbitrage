package top.code666.huobi.common.entity.marketdata;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TradeAll
 * @Description 近期的所有交易记录
 * @Author Sean
 * @Date 2019/4/10 1:07
 **/
@Data
public class TradeAll implements Serializable {
    private static final long serialVersionUID = -6769706770144357227L;

    private int id; // 唯一交易id
    private float amount; // 以基础币种为单位的交易量
    private float price; // 以报价币种为单位的成交价格
    private int ts; // 北京时间的时间戳，单位为毫秒
    private String direction; // 交易方向,"sell" "buy"
}
