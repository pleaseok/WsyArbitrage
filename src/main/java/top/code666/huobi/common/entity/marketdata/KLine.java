package top.code666.huobi.common.entity.marketdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName KLine
 * @Description K线数据
 * @Author Sean
 * @Date 2019/4/10 0:41
 **/
@Data
public class KLine implements Serializable {
    private static final long serialVersionUID = -5835946875532510384L;
    private int id; // 北京时间时间戳，单位秒，K线柱id
    private float amount; // 以基础币种计量的交易量
    private int count; // 交易次数
    private float open; // 本阶段开盘价
    private float close; // 本阶段收盘价
    private float low; // 本阶段最低价
    private float hight; // 本阶段最高价
    private float vol; // 以报价币种计量的交易量
}
