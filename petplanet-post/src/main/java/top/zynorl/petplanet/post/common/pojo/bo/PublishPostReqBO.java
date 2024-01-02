package top.zynorl.petplanet.post.common.pojo.bo;

import lombok.Data;
import top.zynorl.petplanet.post.common.pojo.req.PublishPostReq;

import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/02
 **/
@Data
public class PublishPostReqBO {
    private String username;
    private String title;
    private String content;
    private List<String> pictures;
    private List<String> videos;
    private String tag;
    private String ip;
    private String permission;
    private String publicType;
    private Long editTime;
    private Long createTime;
    private PublishPostReq.LocationReq locationReq;

    @Data
    public static class LocationReq{
        private String name;
        private String address;
        private String nation;
        private String province;
        private String city;
        private String district;
        private Double lat;
        private Double lng;
    }
}
