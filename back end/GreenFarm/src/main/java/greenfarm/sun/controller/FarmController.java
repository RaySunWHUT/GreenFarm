package greenfarm.sun.controller;


import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.service.FarmService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = {"/business"}, method = RequestMethod.POST)
public class FarmController {

    private static Logger logger = Logger.getLogger(FarmController.class);

    @Autowired
    private FarmService farmService;

    @RequestMapping(value = {"/listFarms"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listFarms(@RequestBody JSONObject jsonObject) {

        return farmService.listFarms(jsonObject);

    }

    @RequestMapping(value = {"/saveFarm"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saveFarm(@RequestBody JSONObject jsonObject) {

        return farmService.saveFarm(jsonObject);

    }


    @RequestMapping(value = {"/deleteFarm"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteFarm(@RequestBody JSONObject jsonObject) {

        return farmService.deleteFarm(jsonObject);

    }


    @RequestMapping(value = {"/updateFarm"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateFarm(@RequestBody JSONObject jsonObject) {

        return farmService.saveFarm(jsonObject);

    }

}
