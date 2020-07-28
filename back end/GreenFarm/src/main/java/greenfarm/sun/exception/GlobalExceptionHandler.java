package greenfarm.sun.exception;

import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.util.JSONUtil;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕捉Shiro异常
    @ExceptionHandler({ShiroException.class})
    @ResponseBody
    public JSONObject ShiroHandler() {

        return JSONUtil.errorJSON("action failed!");

    }


    // 捕捉其他所有异常
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public JSONObject globalException() {

        return JSONUtil.errorJSON("global error!");
    }

}