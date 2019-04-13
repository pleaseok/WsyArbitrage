import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import top.code666.huobi.common.entity.BaseApiResponse;
import top.code666.huobi.common.entity.account.AccountInfo;
import top.code666.huobi.common.entity.account.Balance;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.List;

/**
 * @ClassName HUOBITest_account
 * @Description
 * @Author Sean
 * @Date 2019/4/13 18:29
 **/
public class HUOBITest_account {
    ConnectManager cm = ConnectManager.getInstant();

    /**
     * @Author Sean
     * @Description 查询当前用户的所有账户ID及其相关信息 - 未测试
     * @Date 0:33 2019/4/11
     * @Param []
     * @return java.util.List<top.code666.huobi.common.entity.account.AccountInfo>
     **/
    @Test
    public void getInfo(){
        BaseApiResponse<List<AccountInfo>> resp =
                cm.get("/v1/account/accounts", null, new TypeReference<BaseApiResponse<List<AccountInfo>>>() {
                });
        System.out.println(resp.checkAndReturn());
    }

    /**
     * @Author Sean
     * @Description 查询账户的余额
     * @Date 0:58 2019/4/13
     * @Param []
     * @return java.util.List<top.code666.huobi.common.entity.account.Balance>
     **/
    @Test
    public void getBlance(){
        String accountId = "6782358";
        BaseApiResponse<Balance> resp =
                cm.get("/v1/account/accounts/"+ accountId +"/balance", null, new TypeReference<BaseApiResponse<Balance>>() {
                });
        System.out.println(resp.checkAndReturn());
    }
}
