package top.code666.huobi.common.entity.wallet;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BatchCancelOpenOrdersOut
 * @Description
 * @Author Sean
 * @Date 2019/4/14 0:11
 **/
@Data
public class BatchCancelOpenOrdersOut implements Serializable {
    private static final long serialVersionUID = 339991449703467214L;
    private long successCount; // 成功取消的订单数
    private long failedCount; // 取消失败的订单数
    private long nextId; // 下一个符合取消条件的订单号
}
