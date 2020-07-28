package com.dreamchaser.utils;

import java.util.Map;

/**
 * @author 金昊霖
 */
public class MapUtil {
    /**
     * 用于处理前端传递的数据，将分页查询的数据转换成Integer类，因为limit后面只能跟数字，否则会报错
     * @param map
     * @return
     */
    public static Map<String,Object> handle(Map<String,Object> map){
        Object begin=map.get("begin");
        Object size=map.get("size");
        map.replace("begin",Integer.parseInt(String.valueOf(begin)));
        map.replace("size",Integer.parseInt(String.valueOf(size)));
        return map;
    }
}
