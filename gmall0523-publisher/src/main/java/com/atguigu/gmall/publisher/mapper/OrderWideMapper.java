package com.atguigu.gmall.publisher.mapper;

import com.atguigu.gmall.publisher.bean.OrderDetail;
import com.atguigu.gmall.publisher.bean.Pie;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Desc: 对订单宽表进行操作的接口
 */
public interface OrderWideMapper {
    //获取指定日期的交易额
    BigDecimal selectOrderAmountTotal(String date);

    //获取指定日期的分时交易额
    List<Map> selectOrderAmountHour(String date);

    Long getOrderCount(String date);

    List<Pie> getSexPie(String date);

    List<Pie> getAgePie(String date);

    List<OrderDetail> getOrderDetail(@Param("date") String date, @Param("keyword") String keyword);
}
