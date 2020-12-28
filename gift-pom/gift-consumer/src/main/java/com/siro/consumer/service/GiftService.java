package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.vo.GiftBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "gift-back-producer")
public interface GiftService {
    @PostMapping("gift/picUpload/{id}")
    public HttpResult upload(@RequestParam("fileName") MultipartFile file, @PathVariable int id);

    @PostMapping("gift/addGift")
    public HttpResult addGift(
            @RequestParam("fileName") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("depict") String depict,
            @RequestParam("stock") int stock,
            @RequestParam("num") long value
//        @ApiParam(value = "商品", required = true)@RequestBody GiftBean giftBean
    );

    @PostMapping("gift/deleteGift/{id}")
    public HttpResult deleteGift(@PathVariable int id);
    @PostMapping("gift/updateGift/{id}")
    public HttpResult updateGift(@RequestBody GiftBean giftBean,  @PathVariable int id);
}
