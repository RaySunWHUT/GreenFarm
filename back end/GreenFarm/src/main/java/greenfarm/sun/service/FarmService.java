package greenfarm.sun.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface FarmService {

    JSONObject listFarms(JSONObject message);

    JSONObject saveFarm(JSONObject farm);
    JSONObject updateFarm(JSONObject farm);
    JSONObject deleteFarm(JSONObject farmId);

}
