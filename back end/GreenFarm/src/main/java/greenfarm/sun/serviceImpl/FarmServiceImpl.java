package greenfarm.sun.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.dao.FarmDao;
import greenfarm.sun.service.FarmService;
import greenfarm.sun.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("farmService")
@Transactional
public class FarmServiceImpl implements FarmService {

    @Autowired
    private FarmDao farmDao;

    @Override
    public JSONObject listFarms(JSONObject message) {

        String msg = message.getString("message");

        if (msg.equals("farmList")) {

            List<JSONObject> proList = farmDao.listFarms();

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("farmList", proList);

            return JSONUtil.successJSON(jsonObject);

        } else {

            return JSONUtil.errorJSON("message字段错误！");

        }

    }


    @Override
    public JSONObject saveFarm(JSONObject farm) {


        Integer result = farmDao.saveFarm(farm);

        if (result != 1) {

            return JSONUtil.errorJSON("插入异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }

    @Override
    public JSONObject updateFarm(JSONObject farm) {

        Integer result = farmDao.saveFarm(farm);

        if (result != 1) {

            return JSONUtil.errorJSON("更新异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }

    @Override
    public JSONObject deleteFarm(JSONObject farmId) {

        Integer result = farmDao.deleteFarm(farmId);

        if (result != 1) {

            return JSONUtil.errorJSON("删除异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }

}
