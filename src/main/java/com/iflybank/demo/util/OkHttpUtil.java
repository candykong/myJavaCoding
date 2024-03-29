package com.iflybank.demo.util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 基于OkHttp简单封装.
 * Created by kongzhibing on 2021/07/04.
 */
public class OkHttpUtil {

    private static Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);

    private static final OkHttpClient client  = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookieStore.put(url, cookies);
                    for(Cookie cookie:cookies){
                        System.out.println("cookie Name:"+cookie.name());
                        System.out.println("cookie Path:"+cookie.path());
                    }
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get(url);
                    if(cookies==null){
                        System.out.println("没加载到cookie！");
                    }
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            })
            .connectTimeout(60, TimeUnit.SECONDS)       //设置连接超时
            .readTimeout(120, TimeUnit.SECONDS)          //设置读超时
            .writeTimeout(60,TimeUnit.SECONDS)          //设置写超时
            .retryOnConnectionFailure(true)             //是否自动重连
            .build();

    /**
     * get请求同步.
     * @param url
     * @param headers
     * @return
     */
    public static Response httpGet(String url, Map<String, String> headers) {
        Headers.Builder headersBuilder = new Headers.Builder();
        if(headers!=null){
            for (Map.Entry<String, String> e : headers.entrySet()) {
                headersBuilder.add(e.getKey(), e.getValue());
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .headers(headersBuilder.build())
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * get请求异步.
     * @param url
     * @param headers
     * @param callback
     */
    public static void httpGet(String url, Map<String, String> headers,Callback callback) {
        Headers.Builder headersBuilder = new Headers.Builder();
        if(headers!=null){
            for (Map.Entry<String, String> e : headers.entrySet()) {
                headersBuilder.add(e.getKey(), e.getValue());
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .headers(headersBuilder.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    /**
     * post请求同步.
     * @param url
     * @param headers
     * @param body
     * @return
     */
    public static Response httpPost(String url, Map<String, String> headers,RequestBody body) {
        Headers.Builder headersBuilder = new Headers.Builder();
        if(headers!=null){
            for (Map.Entry<String, String> e : headers.entrySet()) {
                headersBuilder.add(e.getKey(), e.getValue());
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .headers(headersBuilder.build())
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * post请求异步.
     * @param url
     * @param headers
     * @param body
     * @param callback
     */
    public static void httpPost(String url, Map<String, String> headers,RequestBody body,Callback callback) {
        Headers.Builder headersBuilder = new Headers.Builder();
        if(headers!=null){
            for (Map.Entry<String, String> e : headers.entrySet()) {
                headersBuilder.add(e.getKey(), e.getValue());
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .headers(headersBuilder.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    /**
     * post json请求同步.
     * @param url
     * @param headers
     * @param json
     * @return
     */
    public static Response httpPost(String url, Map<String, String> headers, JSON json) {
        Headers.Builder headersBuilder = new Headers.Builder();
        if(headers!=null){
            for (Map.Entry<String, String> e : headers.entrySet()) {
                headersBuilder.add(e.getKey(), e.getValue());
            }
        }

        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json.toJSONString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .headers(headersBuilder.build())
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * post json请求异步.
     * @param url
     * @param headers
     * @param json
     * @param callback
     */
    public static void httpPost(String url, Map<String, String> headers,JSON json,Callback callback) {
        Headers.Builder headersBuilder = new Headers.Builder();
        if(headers!=null){
            for (Map.Entry<String, String> e : headers.entrySet()) {
                headersBuilder.add(e.getKey(), e.getValue());
            }
        }

        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json.toJSONString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .headers(headersBuilder.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
