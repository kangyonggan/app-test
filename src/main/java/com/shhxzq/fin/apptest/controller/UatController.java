package com.shhxzq.fin.apptest.controller;

import com.alibaba.fastjson.JSONObject;
import com.shhxzq.fin.apptest.util.GsonUtil;
import com.shhxzq.fin.bankengine.model.RedeemPrivateRequest;
import com.shhxzq.fin.bankengine.model.RedeemPrivateResponse;
import com.shhxzq.fin.bankengine.service.BankEngineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kangyonggan
 * @since 4/25/17
 */
@Controller
@RequestMapping("uat")
@Log4j2
public class UatController extends BaseController {

    @Resource
    private BankEngineService bankEngineService;

    /**
     * 赎回
     *
     * @return
     */
    @RequestMapping(value = "redeem", method = RequestMethod.GET)
    private String redeem() {
        return getPathRoot() + "/redeem";
    }

    /**
     * 赎回
     * 1. bankNo
     * 2. receiverBankNo
     * 3. amount
     * 4. receiverAccountNo
     * 5. receiverAccountName
     * 6. receiverIdNo
     * 7. routeCode
     *
     * @param redeemPrivateRequest
     * @param model
     * @return
     */
    @RequestMapping(value = "redeem", method = RequestMethod.POST)
    public String redeem(@ModelAttribute("redeemPrivateRequest") RedeemPrivateRequest redeemPrivateRequest, Model model) {
        redeemPrivateRequest.setMerTranCode("29");
        redeemPrivateRequest.setProductId("000330");
        redeemPrivateRequest.setProductName("项目测试");
        redeemPrivateRequest.setProductType(null);
        redeemPrivateRequest.setCurrency("156");
        redeemPrivateRequest.setAppKind("952");
        redeemPrivateRequest.setReceiverIdType("0");
        redeemPrivateRequest.setReceiverCity("");
        redeemPrivateRequest.setHuiLu("");//已废弃，汇路由be自己判断

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        redeemPrivateRequest.setRefAppNo(dateFormat.format(new Date()));
        redeemPrivateRequest.setCurrWorkingDate(new Date());

        // 需要改动的
//        redeemPrivateRequest.setBankNo("218");
//        redeemPrivateRequest.setReceiverBankNo("218");
//        redeemPrivateRequest.setAmount(new BigDecimal(0.03));
//        redeemPrivateRequest.setReceiverAccountNo("300113085110013");
//        redeemPrivateRequest.setReceiverAccountName("测试客户3001130851");
//        redeemPrivateRequest.setReceiverIdNo("620111198506020014");// 随意
        redeemPrivateRequest.setAccountId(redeemPrivateRequest.getRouteCode());//027,999,005
//        redeemPrivateRequest.setRouteCode("218");//027,999,005
        redeemPrivateRequest.setCapitalMode("H");

        log.info("请求信息:{}", redeemPrivateRequest);
        RedeemPrivateResponse response = bankEngineService.redeemPrivate(redeemPrivateRequest);
        log.info("响应信息:{}", response);

        model.addAttribute("result", GsonUtil.format(JSONObject.toJSONString(response)));
        return getPathRoot() + "/redeem";
    }

}
