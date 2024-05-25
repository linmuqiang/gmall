package com.atguigu.gmall.publisher.service;

import java.util.List;
import java.util.Map;

/**
 * Desc:
 */
public interface MySQLService {
    List<Map> getTradeAmount(String startTime,String endTime,int topN);
}
