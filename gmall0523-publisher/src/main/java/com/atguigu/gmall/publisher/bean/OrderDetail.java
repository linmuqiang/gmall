package com.atguigu.gmall.publisher.bean;

import lombok.Data;

@Data
public class OrderDetail {
    private String order_detail_id;
    private String user_id;
    private String sku_name;
    private String sku_price;
    private String sku_num;
    private String benefit_reduce_amount;
    private String original_total_amount;
    private String feight_fee;
    private String final_total_amount;
    private String province_name;
    private String tm_name;
    private String category3_name;
    private String create_time;
}
