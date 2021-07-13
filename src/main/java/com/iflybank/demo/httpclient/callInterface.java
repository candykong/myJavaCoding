package com.iflybank.demo.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iflybank.demo.util.OkHttpUtil;
import okhttp3.Response;

import java.util.Objects;


public class callInterface {
   public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        jsonObject.put("age","20");
        jsonObject.put("sex","男");
        String requestParams = jsonObject.toJSONString();
        System.out.println("requestParams:"+requestParams);
        Response response = OkHttpUtil.httpPost("http://localhost:8080/demo/test2", null,jsonObject);
        if (response!=null&&response.isSuccessful() && response.body() != null){
            String responseBody = Objects.requireNonNull(response.body()).toString();
            System.out.println("请求响应的数据为："+responseBody);
            JSONObject jsonObject1 = JSON.parseObject(responseBody);
            String name = jsonObject1.getString("name");
            System.out.println("name:"+name);
            response.close();
        }


    }
}
