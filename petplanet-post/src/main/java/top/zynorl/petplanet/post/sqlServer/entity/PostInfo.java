package top.zynorl.petplanet.post.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 帖子信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@TableName("post_info")
@ApiModel(value = "PostInfo对象", description = "帖子信息表")
public class PostInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联用户id")
    private Long userId;

    @ApiModelProperty("帖子的正文")
    private String content;

    @ApiModelProperty("博客标题")
    private String title;

    @ApiModelProperty("点赞数")
    private Integer likeNum;

    @ApiModelProperty("收藏数")
    private Integer collectNum;

    @ApiModelProperty("转发数")
    private Integer forwardNumber;

    @ApiModelProperty("浏览数")
    private Integer lookNum;

    @ApiModelProperty("文章状态,0可见，1不可见")
    private Byte status;

    @ApiModelProperty("帖子权限类型")
    private String permissionType;

    @ApiModelProperty("帖子标签的名称, 比如狗狗、猫咪")
    private String tagName;

    @ApiModelProperty("发布ip")
    private String ip;

    @ApiModelProperty("帖子发表的地址")
    private String locId;

    @ApiModelProperty("最后评论时间")
    private LocalDateTime lastReviewTime;

    @ApiModelProperty("首次开始编写帖子的时间")
    private LocalDateTime startEditTime;

    @ApiModelProperty("最近帖子修改时间")
    private LocalDateTime lastEditTime;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("最后一次修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getForwardNumber() {
        return forwardNumber;
    }

    public void setForwardNumber(Integer forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public LocalDateTime getLastReviewTime() {
        return lastReviewTime;
    }

    public void setLastReviewTime(LocalDateTime lastReviewTime) {
        this.lastReviewTime = lastReviewTime;
    }

    public LocalDateTime getStartEditTime() {
        return startEditTime;
    }

    public void setStartEditTime(LocalDateTime startEditTime) {
        this.startEditTime = startEditTime;
    }

    public LocalDateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
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
        return "PostInfo{" +
            "id = " + id +
            ", userId = " + userId +
            ", content = " + content +
            ", title = " + title +
            ", likeNum = " + likeNum +
            ", collectNum = " + collectNum +
            ", forwardNumber = " + forwardNumber +
            ", lookNum = " + lookNum +
            ", status = " + status +
            ", permissionType = " + permissionType +
            ", tagName = " + tagName +
            ", ip = " + ip +
            ", locId = " + locId +
            ", lastReviewTime = " + lastReviewTime +
            ", startEditTime = " + startEditTime +
            ", lastEditTime = " + lastEditTime +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", isDelete = " + isDelete +
        "}";
    }
}
