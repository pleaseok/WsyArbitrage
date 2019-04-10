package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName WithdrawalIn
 * @Description 虚拟币提现入参
 * @Author Sean
 * @Date 2019/4/10 23:08
 **/
@Data
public class WithdrawalIn implements Serializable {
    private static final long serialVersionUID = 2354494108209032259L;
    private String address; // 提现地址
    private String amount; // 提币数量
    private String currency; // 资产类型
    // 以下为不必须
    private String fee; // 转账手续费
    private String chain; // 提 USDT-ERC20 时需要设置此参数为 "usdterc20"，其他币种提现不需要设置此参数
    private String addrTag; // 虚拟币共享地址tag,适用于xrp,xem,bts,steem,eos,xmr - 整数字符串
}
