package greenfarm.sun.dao;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
@Mapper
public interface ProductDao {

    List<JSONObject> listPros();

    Integer savePro(JSONObject pro);
    Integer updatePro(JSONObject pro);
    Integer deletePro(JSONObject proId);

    Integer listTypeId(String proType);

    void polling();

    List<JSONObject> listProType();


}
