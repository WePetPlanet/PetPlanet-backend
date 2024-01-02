package top.zynorl.petplanet.post.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 评论信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@TableName("comment_info")
@ApiModel(value = "CommentInfo对象", description = "评论信息表")
public class CommentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("帖子ID")
    private Long postId;

    @ApiModelProperty("评论人的ID")
    private Long userId;

    @ApiModelProperty("评论人名称")
    private String username;

    @ApiModelProperty("评论的内容")
    private String text;

    @ApiModelProperty("点赞数")
    private Integer likeNum;

    @ApiModelProperty("回复数")
    private Integer replyNum;

    @ApiModelProperty("0:不可见，1:可见")
    private Byte status;

    @ApiModelProperty("发表ip")
    private String ip;

    @ApiModelProperty("上级ID，如果为0表示文章的顶级评论")
    private Long parentId;

    @ApiModelProperty("评论的创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("评论的更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
            "id = " + id +
            ", postId = " + postId +
            ", userId = " + userId +
            ", username = " + username +
            ", text = " + text +
            ", likeNum = " + likeNum +
            ", replyNum = " + replyNum +
            ", status = " + status +
            ", ip = " + ip +
            ", parentId = " + parentId +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", isDelete = " + isDelete +
        "}";
    }
}
