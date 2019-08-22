package com.vcanus.controller;

import com.vcanus.model.FirstArray;
import com.vcanus.model.SecondArr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomeController {

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    @ResponseBody
    public String apiRoot() {
        //아래 범위 주석은 2중 리스트 혹은 2중 맵
        //현재 활성화된 코드는 리스트나 맵
        double[] firArr = FirstArray.MakeArray();
        double[] secArr = SecondArr.MakeArray(firArr);
        double[] thiArr = {1,2,0,0,3,4,0,0,5,6,0,0};
        double[] fourArr = {0,0,-1,-2,0,0,-3,-4,0,0,-5,-6};

        //List
        ArrayList<double[]> list = new ArrayList<double[]>();
        list.add(firArr);
        list.add(secArr);
        list.add(thiArr);
        list.add(fourArr);

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(double[] values : list){
            JSONArray childJArray = new JSONArray();
            for(double value : values){
                childJArray.add(value);
            }
            Object objChild = childJArray;
            jsonArray.add(objChild);
        }

        Object obj = jsonArray;
        jsonObject.put("resultSet", jsonArray);

        String json = jsonObject.toJSONString();

        //HashMap
//        HashMap<String, double[]> map = new HashMap<String, double[]>();
//        map.put("firArr", firArr);
//        map.put("secArr", secArr);
//        map.put("thiArr", thiArr);
//        map.put("fourArr", fourArr);
//
//        JSONObject jsonObject = new JSONObject();
//        JSONObject jsonMap = new JSONObject();
//        List<String> keys = new ArrayList<String>(map.keySet());
//        for(int i = 0; i < keys.size(); i++){
//            JSONArray jsonArray = new JSONArray();
//            for(double value : map.get(keys.get(i))){
//                jsonArray.add(value);
//            }
//            Object objChild = jsonArray;
//            jsonMap.put(keys.get(i), objChild);
//        }
//        Object obj = jsonMap;
//        jsonObject.put("resultSet", jsonMap);
//
//        String json = jsonObject.toJSONString();

        /*
        //여기부터 이중
        //HashMap < List
        double[] firArr = FirstArray.MakeArray();
        double[] secArr = SecondArr.MakeArray(firArr);
//        double[] firArr = {1,2,0,0,3,4,0,0,5,6,0,0};
//        double[] secArr = {0,0,-1,-2,0,0,-3,-4,0,0,-5,-6};

        ArrayList<Map> arr = new ArrayList<Map>();
        for(int i = 0; i < 10; i++){
            Map<String, double[]> wrapMap = new HashMap<String, double[]>();
            double[] firArrAdjust = new double[firArr.length];
            double[] secArrAdjust = new double[secArr.length];

            for(int j = 0; j < firArr.length; j++){
                if(firArr[j]==0){
                    firArrAdjust[j] = 0;
                }else{
                    firArrAdjust[j] = firArr[j]+(double)(i)*(double)(j)/10d;
                    //firArrAdjust[j] = firArr[j]+i+j;
                }
                if(secArr[j]==0){
                    secArrAdjust[j] = 0;
                }else{
                    secArrAdjust[j] = secArr[j]+(double)(i)*(double)(j)/10d;
                    //secArrAdjust[j] = secArr[j]-j-i;
                }
            }
            wrapMap.put("firArr", firArrAdjust);
            wrapMap.put("secArr", secArrAdjust);
            arr.add(wrapMap);
        }

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        int i = 0;
        for(Map<String, double[]> element : arr){
            if(0 <= i && i < arr.size()){
                JSONObject jsonChild = new JSONObject();
                for(Map.Entry<String, double[]> entry : element.entrySet()){
                    JSONArray jsonArrayChild = new JSONArray();
                    int j = 0;
                    for(double subElement : entry.getValue()){
                        jsonArrayChild.add(j, subElement);
                        j++;
                    }
                    Object entryObj = jsonArrayChild;
                    jsonChild.put(entry.getKey(), entryObj);
                }
                jsonArray.add(jsonChild);
            }
            i++;
        }
        jsonObject.put("resultSet", jsonArray);

        String result = jsonObject.toJSONString();
        return result;*/
        return json;
    }

    @RequestMapping(
            value = "/api1",
            method = RequestMethod.GET)
    @ResponseBody
    public String api1(
            @RequestParam("para1") String _para1,
            @RequestParam("para2") String _para2) {
        return "api test, /api1";
    }
}