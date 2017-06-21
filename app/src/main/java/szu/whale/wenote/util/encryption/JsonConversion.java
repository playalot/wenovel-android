package szu.whale.wenote.util.encryption;


import com.google.gson.Gson;

import java.lang.reflect.Type;

import szu.whale.wenote.util.StringUtils;

public class JsonConversion {

    private static Gson gson;

    public static Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * Gson  object to Json
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:26
     */
    public static String toJSON(Object object) throws Exception {
        if (object == null) {
            return null;
        }
        try {
            return getGsonInstance().toJson(object);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }


    /**
     * Gson  Json str to  Object
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:26
     */
    public static <T> T Json2Bean(String json, Class<T> t) throws Exception {
        if (StringUtils.isEmpty(json) || t == null) {
            return null;
        }
        try {
            return getGsonInstance().fromJson(json, t);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }


    /**
     * Gson  Json str to  ListObject
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:26
     */
    public static <T> T json2List(String json, Type typeOfT) throws Exception {
        if (StringUtils.isEmpty(json) || typeOfT == null) {
            return null;
        }
        try {
            return getGsonInstance().fromJson(json, typeOfT);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

}
