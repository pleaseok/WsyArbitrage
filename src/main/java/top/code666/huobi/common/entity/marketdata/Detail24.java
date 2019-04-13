package top.code666.huobi.common.entity.marketdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName Detail24
 * @Description 最近24小时的行情数据汇总
 * @Author Sean
 * @Date 2019/4/10 1:13
 **/
@Data
public class Detail24 implements Serializable {
    private static final long serialVersionUID = -3791925736658784491L;
    private long id; // 响应id
    private long version; // 内部数据

    private float amount; // 以基础币种计量的交易量
    private long count; // 交易次数
    private float open; // 本阶段开盘价
    private float close; // 本阶段收盘价
    private float low; // 本阶段最低价
    private float hight; // 本阶段最高价
    private float vol; // 以报价币种计量的交易量
}
