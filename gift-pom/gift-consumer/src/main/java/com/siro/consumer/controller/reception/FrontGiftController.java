package com.siro.consumer.controller.reception;

import com.siro.consumer.service.FrontGiftService;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class FrontGiftController {
    @Autowired
    private FrontGiftService frontGiftService;

    @PostMapping("front/showGifts")
    public HttpResult listGifts(@RequestBody PageRequest pageRequest){
        return frontGiftService.listGifts(pageRequest);
    }

    @GetMapping("front/showGiftDetails/{id}")
    public HttpResult showGiftDetails(@PathVariable int id){
        return frontGiftService.showGiftDetails(id);
    }
}
