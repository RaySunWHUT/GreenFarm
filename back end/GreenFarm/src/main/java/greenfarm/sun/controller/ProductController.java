package greenfarm.sun.controller;


import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.service.ProductService;
import greenfarm.sun.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = {"/business"}, method = RequestMethod.POST)
public class ProductController {

    private static Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/listPros"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPros(@RequestBody JSONObject jsonObject) {

        return productService.listPros(jsonObject);

    }

    @RequestMapping(value = {"/savePro"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject savePro(@RequestBody JSONObject jsonObject) {

        return productService.savePro(jsonObject);

    }


    @RequestMapping(value = {"/deletePro"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deletePro(@RequestBody JSONObject jsonObject) {

        return productService.deletePro(jsonObject);

    }


    @RequestMapping(value = {"/updatePro"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updatePro(@RequestBody JSONObject jsonObject) {

        return productService.updatePro(jsonObject);

    }


    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateUser(@RequestBody JSONObject jsonObject) {

        return userService.updateUser(jsonObject);

    }

    @RequestMapping(value = {"/listOneUser"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listOneUser(@RequestBody JSONObject message) {

        return userService.listOneUser(message);

    }


    @RequestMapping(value = {"/listProType"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listProType(@RequestBody JSONObject message) {

        return productService.listProType(message);

    }

}
