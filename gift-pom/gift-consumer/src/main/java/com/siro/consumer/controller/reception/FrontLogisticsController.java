package com.siro.consumer.controller.reception;

import com.siro.consumer.service.FrontLogisticsService;
import com.siro.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
@RequestMapping("front")
public class FrontLogisticsController {
    @Autowired
    private FrontLogisticsService frontLogisticsService;

    @PostMapping("addLogistic/{exchangeId}")
    public HttpResult addLogistic(@RequestParam int giftId,
                                  @RequestParam int recipientId,
                                  @PathVariable int exchangeId) {
        return frontLogisticsService.addLogistic(giftId, recipientId, exchangeId);
    }
}
