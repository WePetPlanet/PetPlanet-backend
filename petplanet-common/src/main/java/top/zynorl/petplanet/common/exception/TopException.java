package top.zynorl.petplanet.common.exception;

/**
 * 自定义顶级异常，项目所有异常都继承此异常
 */
public class TopException extends Exception{
    public TopException(String message) {
        super(message);
    }
}
