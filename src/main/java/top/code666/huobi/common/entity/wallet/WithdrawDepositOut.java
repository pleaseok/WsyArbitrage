package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName WithdrawDepositOut
 * @Description 充题记录出参
 * @Author Sean
 * @Date 2019/4/10 23:17
 **/
@Data
public class WithdrawDepositOut implements Serializable {
    private static final long serialVersionUID = 6668330791315461486L;
    private long id;
    private String type; // 类型 deposit\withdraw
    private String currency; // 币种
    private String txHash; // 交易哈希
    private long amount; // 个数
    private String address; // 地址
    private String addressTag; // 地址标签
    private long fee; // 手续费
    private String state; // 状态
    private long createdAt; // 发起时间
    private long updatedAt; // 最后更新时间

    /*虚拟币充值状态定义：
    unknown	状态未知
    confirming	确认中
    confirmed	确认中
    safe	已完成
    orphan	待确认
    虚拟币提现状态定义：
    submitted	已提交
    reexamine	审核中
    canceled	已撤销
    pass	审批通过
    reject	审批拒绝
    pre-transfer	处理中
    wallet-transfer	已汇出
    wallet-reject	钱包拒绝
    confirmed	区块已确认
    confirm-error	区块确认错误
    repealed	已撤销
    */
}
