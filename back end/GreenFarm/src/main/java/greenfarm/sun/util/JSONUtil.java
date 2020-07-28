package greenfarm.sun.util;

import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.constants.Constants;

public class JSONUtil {

    public static JSONObject successJSON() {

        JSONObject resultJson = new JSONObject();
        resultJson.put("msg", Constants.QUERY_SUCCESS);
        resultJson.put("code", Constants.SUCCESS_CODE);

        return resultJson;

    }


    public static JSONObject successJSON(Object info) {

        JSONObject resultJson = new JSONObject();
        resultJson.put("info", info);
        resultJson.put("msg", Constants.QUERY_SUCCESS);
        resultJson.put("code", Constants.SUCCESS_CODE);

        return resultJson;

    }


    public static JSONObject errorJSON(Object info) {

        JSONObject resultJson = new JSONObject();

        resultJson.put("info", info);
        resultJson.put("msg", Constants.QUERY_FAILED);
        resultJson.put("code", Constants.EROOR_CODE);

        return resultJson;

    }

}
