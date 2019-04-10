package top.code666.huobi.common.entity.marketdata;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Ticker
 * @Description 聚合行情
 * @Author Sean
 * @Date 2019/4/10 0:53
 **/
@Data
public class Ticker implements Serializable {
    private static final long serialVersionUID = -3917769210504386252L;
    private int id;
    private Object bid; // 当前的最高卖价[price,quote volume]
    private Object ask; // 当前的最低买价[price,quote volume]

    private float amount; // 以基础币种计量的交易量
    private int count; // 交易次数
    private float open; // 本阶段开盘价
    private float close; // 本阶段收盘价
    private float low; // 本阶段最低价
    private float hight; // 本阶段最高价
    private float vol; // 以报价币种计量的交易量
}
