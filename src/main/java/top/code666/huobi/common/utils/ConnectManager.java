package top.code666.huobi.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.*;
import top.code666.huobi.common.constant.ApiClient;
import top.code666.huobi.common.error.ApiException;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassName ConnectManager
 * @Description 配置一个公共的连接管理
 * @Author Sean
 * @Date 2019/4/9 21:41
 **/
public class ConnectManager {
    public final static String API_HOST = getHost();
    public final static MediaType JSON = MediaType.parse("application/json");
    public final static OkHttpClient client = createOkHttpClient();
    private static ConnectManager getConnect;

    private ConnectManager(){}

    public static ConnectManager getInstant(){
        if(getConnect == null) getConnect = new ConnectManager();
        return getConnect;
    }

    // 发送一个get请求
    public <T> T get(String uri, Map<String, String> params, TypeReference<T> ref) {
        if (params == null) {
            params = new HashMap<>();
        }
        return call("GET", uri, null, params, ref);
    }

    // 发送一个post请求
    public <T> T post(String uri, Object object, TypeReference<T> ref) {
        return call("POST", uri, object, new HashMap<String, String>(), ref);
    }

    // call api by endpoint.
    public <T> T call(String method, String uri, Object object, Map<String, String> params,
               TypeReference<T> ref) {
        ApiSignature sign = new ApiSignature();
        sign.createSignature(ApiClient.HUOBI_ACCESSKEY_ID,ApiClient.HUOBI_ACCESSKEY_SECRET,method,API_HOST,uri,params);
        try {
            Request.Builder builder = null;
            if ("POST".equals(method)) {
                RequestBody body = RequestBody.create(JSON, JsonUtil.writeValue(object));
                builder = new Request.Builder().url(ApiClient.HUOBI_API_URL + uri + "?" + toQueryString(params)).post(body);
            } else {
                builder = new Request.Builder().url(ApiClient.HUOBI_API_URL + uri + "?" + toQueryString(params)).get();
            }
            if (ApiClient.HUOBI_ACCESS_PWD != null) {
                builder.addHeader("AuthData", authData());
            }
            Request request = builder.build();
            Response response = client.newCall(request).execute();
            String s = response.body().string();
            return JsonUtil.readValue(s, ref);
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }

    // Encode as "a=1&b=%20&c=&d=AAA"
    String toQueryString(Map<String, String> params) {
        return String.join("&", params.entrySet().stream().map((entry) -> {
            return entry.getKey() + "=" + ApiSignature.urlEncode(entry.getValue());
        }).collect(Collectors.toList()));
    }

    String authData() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(ApiClient.HUOBI_ACCESS_PWD.getBytes(StandardCharsets.UTF_8));
        md.update("hello, moto".getBytes(StandardCharsets.UTF_8));
        Map<String, String> map = new HashMap<>();
        map.put("assetPwd", DatatypeConverter.printHexBinary(md.digest()).toLowerCase());
        try {
            return ApiSignature.urlEncode(JsonUtil.writeValue(map));
        } catch (IOException e) {
            throw new RuntimeException("Get json failed: " + e.getMessage());
        }
    }

    private static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(ApiClient.CONN_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ApiClient.READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(ApiClient.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    private static String getHost() {
        String host = null;
        try {
            host = new URL(ApiClient.HUOBI_API_URL).getHost();
        } catch (MalformedURLException e) {
            System.err.println("parse API_URL error,system exit!,please check API_URL:" + ApiClient.HUOBI_API_URL );
            System.exit(0);
        }
        return host;
    }
}
