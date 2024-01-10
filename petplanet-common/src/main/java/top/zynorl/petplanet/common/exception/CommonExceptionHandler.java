package top.zynorl.petplanet.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.zynorl.petplanet.common.response.Resp;

@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Resp commonException(Exception e) {
        return new Resp().FAIL(e.getMessage());
    }

    @ExceptionHandler(value = TopException.class)
    @ResponseBody
    public Resp topException(TopException topException) {
        return new Resp().FAIL(topException.getMessage());
    }


    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public Resp illegalArgumentException(IllegalArgumentException e) {
        return new Resp().FAIL(e.getMessage());
    }
}
