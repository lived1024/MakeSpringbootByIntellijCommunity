package com.vcanus.controller;

import com.vcanus.model.FirstArray;
import com.vcanus.model.SecondArr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    @ResponseBody
    public String apiRoot() {
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


//        JSONArray firstJsonArray = new JSONArray();
//        for(int i = 0; i < firArr.length; i++){
//            firstJsonArray.add(firArr[i]);
//        }
//        JSONArray secondJsonArray = new JSONArray();
//        for(int i = 0; i < secArr.length; i++){
//            secondJsonArray.add(secArr[i]);
//        }
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("first",firstJsonArray);
//        jsonObject.put("second",secondJsonArray);
//
//        String result = jsonObject.toJSONString();
//
//        return result;
        return result;
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