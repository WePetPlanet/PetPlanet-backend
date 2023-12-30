package top.zynorl.petplanet.gateway.vo;

public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    UNAUTHONICATION(401, "无效的授权信息");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
