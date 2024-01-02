package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.CommentInfo;
import top.zynorl.petplanet.post.sqlServer.mapper.CommentInfoMapper;
import top.zynorl.petplanet.post.sqlServer.service.ICommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements ICommentInfoService {

}
