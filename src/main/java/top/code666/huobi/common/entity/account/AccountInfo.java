package top.code666.huobi.common.entity.account;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AccountInfo
 * @Description 查询当前用户的所有id及其相关信息
 * @Author Sean
 * @Date 2019/4/10 1:21
 **/
@Data
public class AccountInfo implements Serializable {
    private static final long serialVersionUID = -5952557692900426179L;

    private long id; // 账户id
    private String state; // 账户状态: working-正常 ; lock-账户被锁定
    private String type; // 账户类型: spot-现货账户 ; margin-杠杆账户 ; otc-OTC账户 ; point-点卡账户
}
