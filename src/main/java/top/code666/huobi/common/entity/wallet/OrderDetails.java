package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName OrderDetails
 * @Description 订单详情
 * @Author Sean
 * @Date 2019/4/14 0:26
 **/
@Data
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = -8829732707747102775L;
    private long accountId; // 账户ID
    private String amount; // 订单数量
    private long cancelAt; // 订单撤销时间
    private long createdAt; // 订单创建时间
    private String fieldAmount; // 已成交数量
    private String fieldCashAmount; // 已成交总金额
    private String fieldFees; // 已成交手续费(买入为币，卖出为钱)
    private long finishedAt; // 订单变为终结状态的时间，包含已撤单
    private long id; // 订单id
    private String price; // 订单价格
}
