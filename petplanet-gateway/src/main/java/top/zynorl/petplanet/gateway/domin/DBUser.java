package top.zynorl.petplanet.gateway.domin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DBUser implements Serializable {
    private long id;
    private String username;
    private String phoneNumber;
    private String password;
    private String introduction;
    private String email;
    private String address;
    private String url;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private int isDelete;


}
