package com.dreamchaser.utils;

import com.dreamchaser.pojo.Blog;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用于归档的处理，把blog集合处理后以map形式返回，把blog根据年份分
 * @author 金昊霖
 */
public class ArchivesUtil {
    public static Map<Integer, List<Blog>> handle(List<Blog> blogs){
        Map<Integer, List<Blog>> map=new HashMap<>();
        for (Blog blog:blogs){
            //标记该blog的年份是否在map中存在
            Boolean flag=false;
            for (Integer year:map.keySet()){
                if (DateToInterger("yyyy",blog.getDate()).equals(year)){
                    map.get(year).add(blog);
                    flag=true;
                }
            }
            if (!flag){
                List<Blog> blogList=new ArrayList<>(6);
                blogList.add(blog);
                map.put(DateToInterger("yyyy",blog.getDate()),blogList);
            }
        }
        return map;
    }
    public static Integer DateToInterger(String format,Date date){
        String s=new SimpleDateFormat(format).format(date);

        return Integer.parseInt(s);
    }
}
