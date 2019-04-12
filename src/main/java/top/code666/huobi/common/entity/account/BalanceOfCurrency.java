package top.code666.huobi.common.entity.account;

import lombok.Data;

/**
 * @ClassName BalanceOfCurrency
 * @Description 币种的余额
 * @Author Sean
 * @Date 2019/4/13 1:00
 **/
@Data
public class BalanceOfCurrency {
    private String currency; // 币种
    private String balance; // 余额
    private String type; // 类型  trade: 交易余额，frozen: 冻结余额
}
