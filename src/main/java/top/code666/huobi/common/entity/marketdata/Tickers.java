package top.code666.huobi.common.entity.marketdata;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Tickers
 * @Description 获取所有交易对的tickers,数据取值时间区间为24小时滚动
 * @Author Sean
 * @Date 2019/4/10 0:57
 **/
@Data
public class Tickers implements Serializable {
    private static final long serialVersionUID = 5522243957598033786L;
    private String symbol; // 交易对，例如btcusdt,*ethbtc

    private float amount; // 以基础币种计量的交易量
    private int count; // 交易次数
    private float open; // 本阶段开盘价
    private float close; // 本阶段收盘价
    private float low; // 本阶段最低价
    private float hight; // 本阶段最高价
    private float vol; // 以报价币种计量的交易量

}
