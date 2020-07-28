package greenfarm.sun.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyUtil {

    /**
     * @discription 获取一个时间串
     * @return String
     */
    public static String getStringId() {

        String id = null;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        id = sdf.format(date);

        return id;

    }


    @SuppressWarnings("unchecked")
    public static <T> List<T> deepCopy(List<T> srcList) {           // 深拷贝, 学到了

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

        try {

            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(srcList);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream inStream = new ObjectInputStream(byteIn);

            final List<T> destList = (List<T>) inStream.readObject();

            return destList;

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        }

        return null;

    }

}