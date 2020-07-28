package greenfarm.sun.service;

import com.alibaba.fastjson.JSONObject;

public interface ProductService {

    JSONObject listPros(JSONObject message);
    JSONObject savePro(JSONObject pro);
    JSONObject updatePro(JSONObject pro);
    JSONObject deletePro(JSONObject proId);

    JSONObject listProType(JSONObject message);

}
