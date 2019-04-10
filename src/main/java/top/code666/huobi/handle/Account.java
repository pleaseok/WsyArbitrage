package top.code666.huobi.handle;

import com.fasterxml.jackson.core.type.TypeReference;
import top.code666.huobi.common.entity.ApiResponse;
import top.code666.huobi.common.entity.account.AccountInfo;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.List;

/**
 * @ClassName Account
 * @Description 账户信息的相关API操作
 * @Author Sean
 * @Date 2019/4/9 21:28
 **/
public class Account {
    private ConnectManager cm = ConnectManager.getInstant();

    /**
     * @Author Sean
     * @Description 查询当前用户的所有账户ID及其相关信息
     * @Date 0:33 2019/4/11
     * @Param []
     * @return java.util.List<top.code666.huobi.common.entity.account.AccountInfo>
    **/
    public List<AccountInfo> getInfo(){
        ApiResponse resp =
                cm.get("/v1/account/accounts", null, new TypeReference<ApiResponse<List<AccountInfo>>>() {
                });
        return (List<AccountInfo>) resp.checkAndReturn();
    }
}
