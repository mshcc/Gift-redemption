package com.siro.demo.controller.backstage;

import com.siro.demo.model.Gift;
import com.siro.demo.model.Picture;
import com.siro.demo.service.GiftService;
import com.siro.demo.service.PictureService;
import com.siro.demo.utils.FileNameUtils;
import com.siro.demo.utils.QiniuUtils;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.vo.GiftBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author mshcc
 * @date 2020/12/24
 */
@RestController
@RequestMapping("gift")
public class GiftController {
    @Autowired
    private GiftService giftService;
    @Autowired
    private PictureService pictureService;

    @PreAuthorize("hasAuthority('super')")
    @PostMapping("picUpload/{id}")
    public HttpResult upload(@RequestParam("fileName") MultipartFile file, @PathVariable int id) throws IOException {

        if (!file.isEmpty()) {
            FileInputStream inputStream = (FileInputStream) file.getInputStream();
            String path = QiniuUtils.uploadQNImg(inputStream, FileNameUtils.getFileName(file.getOriginalFilename()));
            Picture record = new Picture();
            record.setPicpath(path);
            record.setPicrange("gift");
            record.setRangeId(id);
            pictureService.insert(record);
            return HttpResult.ok("图片上传成功");
        }
        return HttpResult.error("上传失败");

    }

    @PreAuthorize("hasAuthority('super')")
    @PostMapping("addGift")
    public HttpResult addGift(@RequestParam("fileName") MultipartFile file, String name, String depict, int stock, long value) throws IOException {
        if (giftService.findByName(name) != null) {
            return HttpResult.error("商品已存在，请勿重复添加！");
        }
        Gift gift = new Gift();
        gift.setName(name);
        gift.setCreationtime(new Date());
        gift.setDepict(depict);
        gift.setValue(value);
        gift.setStock(stock);
        giftService.insertSelective(gift);
        if (!file.isEmpty()) {
            FileInputStream inputStream = (FileInputStream) file.getInputStream();
            String path = QiniuUtils.uploadQNImg(inputStream, FileNameUtils.getFileName(file.getOriginalFilename()));
            Picture record = new Picture();
            record.setPicpath(path);
            record.setPicrange("gift");
            record.setRangeId(gift.getId());
            pictureService.insert(record);
        }
        return HttpResult.ok("添加成功");
    }

    @PreAuthorize("hasAuthority('super')")
    @PostMapping("deleteGift/{id}")
    public HttpResult deleteGift(@PathVariable int id) {
        giftService.deleteByPrimaryKey(id);
        pictureService.deleteByRangeId(id);
        return HttpResult.ok("商品删除成功");
    }

    @PostMapping("updateGift/{id}")
    public HttpResult updateGift(@RequestBody GiftBean giftBean,@PathVariable int id) {
        Gift gift = giftService.selectByPrimaryKey(id);
        if (gift == null) {
            return HttpResult.error("商品不存在或已被删除！");
        }
        String name = giftBean.getName();
        String depict = giftBean.getDepict();
        Integer stock = giftBean.getStock();
        Long value = giftBean.getValue();
        gift.setName(name);
        gift.setDepict(depict);
        gift.setValue(value);
        gift.setStock(stock);
        giftService.updateByPrimaryKeySelective(gift);
        return HttpResult.ok("商品更新成功");
    }

}
