package top.zynorl.petplanet.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.zynorl.petplanet.common.response.Resp;

@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Resp commonException(Exception e) {
        return new Resp().FAIL(e.getMessage());
    }

    @ExceptionHandler(value = TopException.class)
    public Resp topException(TopException topException) {
        return new Resp().FAIL(topException.getMessage());
    }
}
