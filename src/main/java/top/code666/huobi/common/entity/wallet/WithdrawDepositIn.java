package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName WithdrawDepositIn
 * @Description 充题记录请求参数
 * @Author Sean
 * @Date 2019/4/10 23:14
 **/
@Data
public class WithdrawDepositIn implements Serializable {
    private static final long serialVersionUID = -461124407775173692L;
    private String currency; // 币种
    private String type; // 充值或提现  deposit\withdraw
    private String from; // 查询起始ID
    private String size; // 查询记录大小
}
