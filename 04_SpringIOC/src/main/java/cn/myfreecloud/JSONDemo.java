package cn.myfreecloud;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhangyang
 * @date: 2020/4/7 18:48
 * @description:
 */
public class JSONDemo {
    static String JSONSTR = "{\"sites\":[{\"name\":\"666\",\"url\":\"www.baidu.com\"},{\"name\":\"ali\",\"url\":\"http://alibaba.com/\"}]}";

    /**
     *
     * {
     *     "sites":[
     *         {
     *             "name":"666",
     *             "url":"www.baidu.com"
     *         },
     *         {
     *             "name":"ali",
     *             "url":"http://alibaba.com/"
     *         }
     *     ]
     * }
     */
    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();

        // 将json字符串转为jsonbject
        JSONObject jsonStrObject = jsonObject.parseObject(JSONSTR);

        JSONArray jsonArray = jsonStrObject.getJSONArray("sites");

        for (Object object : jsonArray) {
            JSONObject stObject = (JSONObject) object;
            String name = stObject.getString("name");
            String url = stObject.getString("url");
            System.out.println(name + "---" + url);
        }


        // 组装json对象
        JSONObject assembleJsonObject = new JSONObject();
        JSONArray assembleJsonArray = new JSONArray();

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("1", "alibaba");
        jsonObject1.put("url", "http://www.alibaba.com");
        assembleJsonArray.add(jsonObject1);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("2", "qq");
        jsonObject2.put("url", "http://www.qq.com");


        assembleJsonArray.add(jsonObject2);

        assembleJsonObject.put("sites", assembleJsonArray);

        System.out.println(assembleJsonObject.toJSONString());

    }


}
