package top.code666.huobi.common.entity.account;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * @ClassName Balance
 * @Description 查询指定账户余额: spot\margin\otc\point
 * @Author Sean
 * @Date 2019/4/10 1:27
 **/
@Data
public class Balance implements Serializable {
    private static final long serialVersionUID = -3351992630753455319L;

    private long id; // 账户ID
    private String state; // 账户状态 working \ lock
    private String type; // 账户类型 spot\margin\otc\point
    private Array list; // 子账号数组

}
