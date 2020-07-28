package greenfarm.sun.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import greenfarm.sun.dao.ProductDao;
import greenfarm.sun.service.ProductService;
import greenfarm.sun.util.JSONUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);


    @Override
    public JSONObject listPros(JSONObject message) {

        String msg = message.getString("message");

        if (msg.equals("proList")) {

            List<JSONObject> proList = productDao.listPros();

            JSONObject jsonObject = new JSONObject();

//            productDao.polling();

            for (JSONObject json: proList) {

                if (json.getString("state").equals("0")) {

                    json.put("state", "审核中");

                } else {

                    json.put("state", "已上架");

                }

            }

            jsonObject.put("proList", proList);

            return JSONUtil.successJSON(jsonObject);

        } else {

            return JSONUtil.errorJSON("message字段错误！");

        }

    }


    @Override
    public JSONObject savePro(JSONObject pro) {

        String typeName = pro.getString("typeName");

        Integer typeId =  productDao.listTypeId(typeName);

        pro.remove("typeName");

        pro.put("typeId", typeId);

        pro.put("state", 0);

        Integer result = productDao.savePro(pro);

        if (result != 1) {

            return JSONUtil.errorJSON("插入异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }


    @Override
    public JSONObject updatePro(JSONObject pro) {

        String typeName = pro.getString("typeName");

        Integer typeId =  productDao.listTypeId(typeName);

        pro.remove("typeName");

        pro.put("typeId", typeId);

        Integer result = productDao.updatePro(pro);

        if (result != 1) {

            return JSONUtil.errorJSON("更新异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }


    @Override
    public JSONObject deletePro(JSONObject proId) {

        Integer result = productDao.deletePro(proId);

        if (result != 1) {

            return JSONUtil.errorJSON("删除异常!");

        } else {

            return JSONUtil.successJSON();

        }

    }


    @Override
    public JSONObject listProType(JSONObject message) {

        String msg = message.getString("message");

        if (msg.equals("typeList")) {

            List<JSONObject> typeList = productDao.listProType();

            return JSONUtil.successJSON(typeList);

        } else {

            return JSONUtil.errorJSON("message字段错误！");

        }



    }

}
