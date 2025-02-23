package com.atguigu.gmall.publisher.service;

import com.atguigu.gmall.publisher.bean.OrderDetail;
import com.atguigu.gmall.publisher.bean.Pie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Desc: ClickHourse相关相关的业务接口
 */
public interface ClickHouseService {
    //获取指定日期总的交易额
    BigDecimal getOrderAmountTocal(String date);

    Long getOrderCount(String date);

    //获取指定日期的分时交易额

    /*
     * 从Mapper获取的分时交易额格式  List<Map{hr->11,am->10000}> ==>Map{11->10000,12->2000}
     * @param date
     * @return
     */
    Map<String, BigDecimal> getOrderAmountHour(String date);


    List<Pie> getSexPie(String date);

    List<Pie> getAgePie(String date);

    List<OrderDetail> getOrderDetail(String date, String keyword);
}
