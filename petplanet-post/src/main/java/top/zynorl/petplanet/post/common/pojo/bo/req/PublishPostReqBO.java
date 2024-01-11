package top.zynorl.petplanet.post.common.pojo.bo.req;

import lombok.Data;
import top.zynorl.petplanet.post.common.pojo.req.PublishPostReq;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/02
 **/
@Data
public class PublishPostReqBO {
    /**
     * 关联用户id
     */
    private Long userId;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子的正文
     */
    private String content;
    /**
     * 图片url列表
     */
    private List<String> pictures;
    /**
     * 视频url列表
     */
    private List<String> videos;
    /**
     * 帖子标签的名称, 比如狗狗、猫咪
     */
    private String tagName;
    /**
     * 发布ip
     */
    private String ip;
    /**
     * 帖子权限类型
     */
    private String permissionType;
    /**
     * 是否为定时发布
     */
    private Boolean isTiming;
    /**
     * 发布时间
     */
    private Long publishTime;
    /**
     * 首次开始编写帖子的时间
     */
    private LocalDateTime startEditTime;
    /**
     * 最近帖子修改时间
     */
    private LocalDateTime lastEditTime;
    /**
     * 地点信息
     */
    private PublishPostReq.LocationReq locationReq;

    @Data
    public static class LocationReq {
        /**
         * 地点名称
         */
        private String name;
        /**
         * 地点位置
         */
        private String address;
        /**
         * 国家
         */
        private String nation;
        /**
         * 省份
         */
        private String province;
        /**
         * 城市
         */
        private String city;
        /**
         * 区域
         */
        private String district;
        /**
         * 纬度
         */
        private Double lat;
        /**
         * 经度
         */
        private Double lng;
    }
}
