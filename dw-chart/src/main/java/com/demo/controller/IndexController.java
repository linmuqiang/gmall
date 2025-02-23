package com.demo.controller;

import com.demo.utils.GetDate;
import com.demo.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@Controller
@RequestMapping(value = "/")
@PropertySource({"classpath:config/config.properties"})
public class IndexController {

    @Value("${my.totalUrl}")
    private String totalUrl;

    @Value("${my.hourUrl}")
    private String hourUrl;

    @Value("${my.esDataUrl}")
    private String esDataUrl;

    @Value("${my.sexUrl}")
    private String sexUrl;

    /*@Autowired
    private IndexService indexService;*/
    //测试
    @RequestMapping(value = "index1", method = RequestMethod.GET)
    public String index1() {
        return "index1";
    }

    //页面显示
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "table", method = RequestMethod.GET)
    public String table() {
        return "table";
    }

    @RequestMapping(value = "map", method = RequestMethod.GET)
    public String map() {
        return "map";
    }


    @RequestMapping(value = "getTotal", method = RequestMethod.GET)
    @ResponseBody
    public String getTotal() {
        String sysDate = GetDate.getSysDate();
        return HttpClientUtil.doGet(totalUrl + "?date=" + sysDate);
//        return "[{'id':'l0','name':'每日统计','yesData':100,'toData':50},{'id':'l1','name':'每日日活','yesData':500,'toData':50},{'id':'l2','name':'活跃度','yesData':100,'toData':50}]";
    }

    //获取统计数据
    @RequestMapping(value = "getAnalysisData", method = RequestMethod.GET)
    @ResponseBody
    public String getList(String tag) throws IOException {
        System.err.println(tag);
//        return  "{'yesterday':{'00':110,'01':110,'02':25,'03':40,'07':87,'08':65,'09':32,'10':45,'11':35,'12':87,'13':34,'14':78,'15':54,'16':110,'17':100,'18':100,'19':56,'20':89,'21':88,'22':87,'23':86},'today':{'00':122,'01':122,'02':110,'03':105,'04':100,'05':46,'06':24,'07':24,'08':123,'09':221,'10':222,'11':100,'12':100,'13':78,'14':87,'15':67,'16':44,'17':77,'18':120,'19':100,'20':100,'21':108,'22':80,'23':55}}";
        String sysDate = GetDate.getSysDate();
        return HttpClientUtil.doGet(hourUrl + "?id=" + tag + "&&date=" + sysDate);
    }

    @RequestMapping(value = "getData", method = RequestMethod.GET)
    @ResponseBody
    public String getData(HttpServletRequest req) {

        String level = req.getParameter("level");
        String draw = req.getParameter("draw");
        String start = req.getParameter("start");
        String length = req.getParameter("length");
        //System.out.println(time+level+text);

        String time = req.getParameter("time");
        String text = req.getParameter("text");
        int d = Integer.parseInt(draw);
        int s = Integer.parseInt(start) + 1;
        int l = Integer.parseInt(level);
        int size = Integer.parseInt(length);
        String sysDate = GetDate.getSysDate();
        String url = esDataUrl + "?startpage=" + s + "&&size=" + size;
        if (time != null && !"".equals(time)) {
            url = url + "&&date=" + time;
        } else {
            url = url + "&&date=" + sysDate;
        }
        if (text != null && !"".equals(text)) {
            url = url + "&&keyword=" + text;
        } else {
            url = url + "&&keyword=" + "";
        }
        System.err.println(url);

        /*//获取前台额外传递过来的查询条件
        String extra_search = req.getParameter("extra_search");*/
        return HttpClientUtil.doGet(url);
//        return "{'draw':" + draw + ",'data':" + json + "}";
/*        return "{'data':{'draw':" + draw + ",'total':20," +
                "'rows':[{'user_id':'123'," +
                "'sku_id':'123'," +
                "'user_gender':'M'," +
                "'user_age':12," +
                "'user_level':1," +
                "'order_price':123.2," +
                "'sku_name':'asd'," +
                "'sku_tm_id':'234'," +
                "'sku_category1_id':'435'," +
                "'sku_category2_id':'3465'," +
                "'sku_category3_id':'56'," +
                "'sku_category1_name':'dfg'," +
                "'sku_category2_name':'hg'," +
                "'sku_category3_name':'bc'," +
                "'spu_id':'876'," +
                "'sku_num':234," +
                "'order_count':234," +
                "'order_amount':654," +
                "'dt':'hgdff'},{'user_id':'123'," +
                "'sku_id':'123'," +
                "'user_gender':'M'," +
                "'user_age':12," +
                "'user_level':1," +
                "'order_price':123.2," +
                "'sku_name':'asd'," +
                "'sku_tm_id':'234'," +
                "'sku_category1_id':'435'," +
                "'sku_category2_id':'3465'," +
                "'sku_category3_id':'56'," +
                "'sku_category1_name':'dfg'," +
                "'sku_category2_name':'hg'," +
                "'sku_category3_name':'bc'," +
                "'spu_id':'876'," +
                "'sku_num':234," +
                "'order_count':234," +
                "'order_amount':654," +
                "'dt':'hgdff'},{'user_id':'123'," +
                "'sku_id':'123'," +
                "'user_gender':'M'," +
                "'user_age':12," +
                "'user_level':1," +
                "'order_price':123.2," +
                "'sku_name':'asd'," +
                "'sku_tm_id':'234'," +
                "'sku_category1_id':'435'," +
                "'sku_category2_id':'3465'," +
                "'sku_category3_id':'56'," +
                "'sku_category1_name':'dfg'," +
                "'sku_category2_name':'hg'," +
                "'sku_category3_name':'bc'," +
                "'spu_id':'876'," +
                "'sku_num':234," +
                "'order_count':234," +
                "'order_amount':654," +
                "'dt':'hgdff'}," +
                "{'user_id':'123'," +
                "'sku_id':'123'," +
                "'user_gender':'M'," +
                "'user_age':12," +
                "'user_level':1," +
                "'order_price':123.2," +
                "'sku_name':'asd'," +
                "'sku_tm_id':'234'," +
                "'sku_category1_id':'435'," +
                "'sku_category2_id':'3465'," +
                "'sku_category3_id':'56'," +
                "'sku_category1_name':'dfg'," +
                "'sku_category2_name':'hg'," +
                "'sku_category3_name':'bc'," +
                "'spu_id':'876'," +
                "'sku_num':234," +
                "'order_count':234," +
                "'order_amount':654," +
                "'dt':'hgdff'}" +
                "]}}";*/
    }

    @RequestMapping(value = "getSexData", method = RequestMethod.GET)
    @ResponseBody
    public String getSexData(HttpServletRequest req) {
        String time = req.getParameter("time");
        String type = req.getParameter("type");
        if (time == null || "".equals(time)) {
            time = GetDate.getSysDate();
        }
        return HttpClientUtil.doGet(sexUrl + "?dt=" + time + "&&type=" + type);
//        return "{'stat':[{'group':[{'name':'20岁以下','value':300},{'name':'20-30岁','value':200},{'name':'30岁以上','value':100}]},{'group':[{'name':'男','value':200},{'name':'女','value':200}]}]}";
    }

    //获取地图数据
    @RequestMapping(value = "getChinaOrderData", method = RequestMethod.GET)
    @ResponseBody
    public String getChinaOrderData() {
        return "";
    }
}
