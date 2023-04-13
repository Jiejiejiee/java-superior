package com.superior.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest1 {

    public static void main(String[] args) {

        //1.获取Map,并遍历key集
        Map map = CityMap.model;

        Set provinces = map.keySet();
        for (Object province : provinces){
            System.out.print(province + "\t\t");
        }

        //2.获取输入的字符串,并和key集做比对.判断输入是否存在,存在则遍历其value集
        Scanner sc = new Scanner(System.in);

        String[] cities = null;

        while (true){

            System.out.println("\n请输入省份:");
            String province = sc.next();

            cities = (String[]) map.get(province);

            if (cities == null || cities.length == 0){
                System.out.println("请重新输入.");
            }else {
                break;//用户输入存在
            }

        }

        for (int i = 0; i < cities.length; i++) {
            System.out.print(cities[i] +"\t\t");
        }

        //3.获取键盘输入的城市,遍历城市数组,判断是否存在.
        lo:while (true){

            System.out.println("\n请选择城市");

            String city = sc.next();

            for (int i = 0; i < cities.length; i++) {
                if (city.equals(cities[i])){
                    System.out.println("信息登记完毕");
                    break lo;
                }
            }

            System.out.println("输入城市有误,请重新输入.");

        }


    }

}

class CityMap{

    public static Map model = new HashMap();

    static {

        model.put("北京",new String[]{"北京"});
        model.put("辽宁",new String[]{"沈阳","盘锦","铁岭","丹东"});
        model.put("吉林",new String[]{"长春","延边","吉林","白山"});
        model.put("江西",new String[]{"南昌","宜春","丰城","赣州"});

    }

}
