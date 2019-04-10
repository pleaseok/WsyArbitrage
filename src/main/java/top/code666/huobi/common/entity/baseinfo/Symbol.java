package top.code666.huobi.common.entity.baseinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Symbol
 * @Description 交易对
 * @Author Sean
 * @Date 2019/4/9 21:30
 **/
@Data
public class Symbol implements Serializable {
    private static final long serialVersionUID = -6751287929325823496L;
    public String baseCurrency; // 交易对中的基础货币
    public String quoteCurrency; // 交易对中的报价币价
//    public int pricePrecision; // 交易对报价的精度  - 无用，可以注释
//    public int amountPrecision; // 交易对基础币种计数精度 - 无用，可以注释
    public String symbol;
}
