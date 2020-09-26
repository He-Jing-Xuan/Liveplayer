package com.example.test2.controller;

import com.example.test2.domain.Device;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.omg.CORBA.MARSHAL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Controller

public class LiveGbsTest2 {

    RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T>T json2POJO(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //得到设备列表
    @RequestMapping("/getList")
    public String getDeviceId(Model model)
    {
        String url = "http://202.115.139.137:20020/api/v1/device/list";
        String forObject = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject1 = JSONObject.fromString(forObject);
        JSONArray deviceList =  jsonObject1.getJSONArray("DeviceList");

        //model.addAttribute("lists",deviceList);
       /* for(int i=0;i<deviceList.length();i++)
        {
            JSONObject obj = deviceList.getJSONObject(i);
            String id = obj.getString("ID");
            String online =obj.getString("Online");
            String type = obj.getString("Type");
            model.addAttribute("id",id);
            model.addAttribute("online",online);
            model.addAttribute("type",type);



        }*/
        //model.addAttribute("lists",deviceList.toString());
       return deviceList.toString();
    }



    //开始直播
    @RequestMapping(value = "/startLive")
    @ResponseBody
    public Map<String, Object> startLive()
    {
        String url = "http://202.115.139.137:20020/api/v1/stream/start?serial=31011500991320000172";
        String forObject = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = jsonObject.fromString(forObject);
        Object flv = jsonObject1.get("FLV");
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("flv",flv.toString());

        return map;

    }
}
