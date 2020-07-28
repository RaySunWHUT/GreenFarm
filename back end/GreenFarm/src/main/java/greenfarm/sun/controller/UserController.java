package greenfarm.sun.controller;

import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject jsonObject) {

        return userService.login(jsonObject);

    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject logout(@RequestBody JSONObject message) {     // 退出

        return userService.logout(message);

    }


    /**
     * 必须为GET方法
     *
     * @return
     */
    @RequestMapping(value = {"/notLogin"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONObject notLogin() {

        return userService.notLogin();

    }


    @RequestMapping(value = {"/updatePassword"}, method = RequestMethod.POST)
    public JSONObject updatePassword(@RequestBody JSONObject message) {

        return userService.updatePassword(message);

    }


    @RequestMapping(path = "/unauthorized/{message}", method = RequestMethod.GET)
    public JSONObject unauthorized(@PathVariable String message) {

        return userService.unauthorized(message);

    }

    @RequestMapping(value = {"/listUsers"}, method = RequestMethod.POST)
    public JSONObject listUsers(@RequestBody JSONObject message) {

        return userService.listUsers(message);

    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public JSONObject register(@RequestBody JSONObject message) {

        return userService.register(message);

    }

}