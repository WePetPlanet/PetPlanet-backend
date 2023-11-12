package top.zynorl.petplanet.user.common.pojo.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zynorl.petplanet.common.common.base.BaseReqPage;

/**
 * Created by zynorl on 2023/11/12 14:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetUserListReqBO extends BaseReqPage {

    /**
     * 按用户名检索
     */
    private String keyword;

    /**
     * 当前系统用户id
     */
    private String system_user_id;

}
