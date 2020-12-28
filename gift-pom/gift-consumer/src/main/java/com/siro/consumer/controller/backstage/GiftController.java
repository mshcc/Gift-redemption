package com.siro.consumer.controller.backstage;

import com.siro.consumer.service.GiftService;
import com.siro.http.HttpResult;
import com.siro.vo.GiftBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mshcc
 * @date 2020/12/27
 */
public class GiftController {
    @Autowired
    private GiftService giftService;
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("picUpload/{id}")
    public HttpResult upload(@RequestParam("fileName") MultipartFile file, @PathVariable int id){
        return giftService.upload(file,id);
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("addGift")
    public HttpResult addGift(@RequestParam("fileName") MultipartFile file, @RequestBody GiftBean giftBean){
        return giftService.addGift(file,giftBean.getName(),giftBean.getDepict(),giftBean.getStock(),giftBean.getValue());
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("deleteGift/{id}")
    public HttpResult deleteGift(@PathVariable int id){
        return giftService.deleteGift(id);
    }
    @PostMapping("updateGift/{id}")
    @PreAuthorize("hasAuthority('super')")
    public HttpResult updateGift(@RequestBody GiftBean giftBean, @PathVariable int id){
        return giftService.updateGift(giftBean,id);
    }
}
