package top.code666.huobi.common.entity.marketdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName Trade1
 * @Description 交易对最新的一个交易记录
 * @Author Sean
 * @Date 2019/4/10 1:00
 **/
@Data
public class Trade1 implements Serializable {
    private static final long serialVersionUID = -3763062828889276757L;
    private int id; // 唯一交易id
    private float amount; // 以基础币种为单位的交易量
    private float price; // 以报价币种为单位的成交价格
    private int ts; // 北京时间的时间戳，单位为毫秒
    private String direction; // 交易方向:"buy" "sell"
}
