package top.zynorl.petplanet.post.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 宠物与帖子的映射表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@TableName("post_pet_relation")
@ApiModel(value = "PostPetRelation对象", description = "宠物与帖子的映射表")
public class PostPetRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("帖子的id")
    private Long postId;

    @ApiModelProperty("宠物的id")
    private Long petId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
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

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
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
        return "PostPetRelation{" +
            "id = " + id +
            ", postId = " + postId +
            ", petId = " + petId +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", isDelete = " + isDelete +
        "}";
    }
}
