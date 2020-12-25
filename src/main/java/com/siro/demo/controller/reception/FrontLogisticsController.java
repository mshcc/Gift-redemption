package com.siro.demo.controller.reception;

import com.siro.demo.model.Logistics;
import com.siro.demo.service.LogisticsService;
import com.siro.demo.utils.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@RestController
@RequestMapping("front")
public class FrontLogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @PostMapping("addLogistic/{exchangeId}")
    public HttpResult addLogistic(int giftId,int recipientId,@PathVariable int exchangeId){
        Logistics logistics = new Logistics();
        logistics.setGifId(giftId);
        logistics.setRecipientid(recipientId);
        logistics.setExchangeid(exchangeId);
        logisticsService.insertSelective(logistics);
        return HttpResult.ok("商品已打包，等待发货");
    }
}
