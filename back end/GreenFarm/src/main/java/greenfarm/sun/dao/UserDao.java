package greenfarm.sun.dao;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {

    User getUserByUserAccount(String userAccount);

    JSONObject getRoleByUserAccount(String userAccount);

    List<JSONObject> listUsers();

    Integer saveUser(JSONObject user);

    Integer updateUser(JSONObject jsonObject);

    JSONObject listOneUser(String userAccount);

}
