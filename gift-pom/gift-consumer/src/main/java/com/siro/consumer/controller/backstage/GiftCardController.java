package com.siro.consumer.controller.backstage;

import com.siro.consumer.service.GiftCardService;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class GiftCardController {
    @Autowired
    private GiftCardService giftCardService;

    @PostMapping("addGiftCard")
    @PreAuthorize("hasAuthority('super')")
    public HttpResult addGiftCard(@RequestParam("num") int num) {
        return giftCardService.addGiftCard(num);
    }

    @PostMapping("listGiftCard")
    public HttpResult listGiftCard(@RequestBody PageRequest pageRequest) {
        return giftCardService.listGiftCard(pageRequest);
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("deleteGiftCard/{id}")
    public HttpResult delete(@PathVariable int id) {
        return giftCardService.delete(id);
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("updateGiftCardDate/{id}")
    public HttpResult updateDate(@PathVariable int id) {
        return giftCardService.updateDate(id);
    }
}
