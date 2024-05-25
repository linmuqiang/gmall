package com.atguigu.gmall.publisher.service;

import java.util.Map;

/**
 * Desc: 操作ES的接口
 */
public interface ESService {
    //查询某天的日活数
    Long getDauTotal(String date);

    //查询某天某时段的日活数
    Map<String, Long> getDauHour(String date);
}
