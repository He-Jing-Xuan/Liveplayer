package com.example.test2;


import com.example.test2.domain.Device;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.example.test2.controller.LiveGbsTest2.json2POJO;

@SpringBootTest
class Test2ApplicationTests {

    RestTemplate restTemplate = new RestTemplate();
    String host = "http://202.115.139.137:20020";
 /*   @Test
    public List<url> findLiveStream(String serial)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        Map<String, String> params = new HashMap<String, String>();
        params.put("serial", serial);
        String url = host + "/api/v1/stream/start?serial="+serial;
        ParameterizedTypeReference<List<url>> responseType = new ParameterizedTypeReference<List<url>>() {};
        ResponseEntity<List<url>> resp = restTemplate.exchange(url, HttpMethod.GET, entity, responseType,params);
        List<url> list = resp.getBody();
        System.out.println(list);
        return list;
    }*/

    @Test
    public void test()
    {
        String url = "http://202.115.139.137:20020/api/v1/stream/start?serial=31011500991320000172";
        String forObject = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = jsonObject.fromString(forObject);
        Object flv = jsonObject1.get("FLV");
        System.out.println(flv.toString());

    }

    @Test
    public void test1()
    {
        String url = "http://202.115.139.137:20020/api/v1/Device/list";
        String forObject = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject1 = JSONObject.fromString(forObject);
       JSONArray deviceList =  jsonObject1.getJSONArray("DeviceList");

        for(int i=0;i<deviceList.length();i++)
        {
            JSONObject obj = deviceList.getJSONObject(i);

           String id=obj.getString("ID");
            System.out.println(id);

        }
    }

    @Test
    public void test2()
    {
        String url = "http://202.115.139.137:20020/api/v1/device/list";
        String forObject = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject1 = JSONObject.fromString(forObject);
        JSONArray deviceList =  jsonObject1.getJSONArray("DeviceList");

        for(int i=0;i<deviceList.length();i++)
        {
            JSONObject obj = deviceList.getJSONObject(i);
            Device device = json2POJO(obj.toString(), Device.class);
            System.out.println(device.toString());

        }
    }
}
