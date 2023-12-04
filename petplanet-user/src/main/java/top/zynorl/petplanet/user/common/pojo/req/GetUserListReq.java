package top.zynorl.petplanet.user.common.pojo.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zynorl.petplanet.common.base.BaseReqPage;

/**
 * Created by zynorl on 2023/11/12 14:36
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class GetUserListReq extends BaseReqPage {

    /**
     * 按用户名检索
     */
    private String keyword;

}
