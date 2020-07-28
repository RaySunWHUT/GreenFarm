package greenfarm.sun.dao;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("farmDao")
@Mapper
public interface FarmDao {

    List<JSONObject> listFarms();

    Integer saveFarm(JSONObject farm);
    Integer updateFarm(JSONObject farm);
    Integer deleteFarm(JSONObject farmId);

}
