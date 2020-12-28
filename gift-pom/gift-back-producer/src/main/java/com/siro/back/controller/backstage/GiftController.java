package com.siro.back.controller.backstage;

import com.siro.back.service.GiftService;
import com.siro.back.service.PictureService;
import com.siro.back.utils.FileNameUtils;
import com.siro.back.utils.QiniuUtils;
import com.siro.http.HttpResult;
import com.siro.model.Gift;
import com.siro.model.Picture;
import com.siro.vo.GiftBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "礼品的增删改")
public class GiftController {
    @Autowired
    private GiftService giftService;
    @Autowired
    private PictureService pictureService;

    @PostMapping("picUpload/{id}")
    @ApiOperation(value = "该接口用于上传礼品图片，一次只能上传一张(暂时)")
    public HttpResult upload(@ApiParam(value = "图片", required = true) @RequestParam("fileName") MultipartFile file, @ApiParam(value = "id", required = true, example = "1")  @PathVariable int id) throws IOException {

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

    @PostMapping("addGift")
    @ApiOperation(value = "该接口用于上传礼品，图片只能上传一张(暂时)")
    public HttpResult addGift(@ApiParam(value = "图片", required = true)
                                  @RequestParam("fileName") MultipartFile file,
                              @ApiParam(value = "商品名", required = true,example = "五常大米")String name,
                              @ApiParam(value = "商品描述", required = true,example = "好大米，我选五常")String depict,
                              @ApiParam(value = "商品数量", required = true,example = "1000")int stock,
                              @ApiParam(value = "商品价值", required = true,example = "9999")long value
//        @ApiParam(value = "商品", required = true)@RequestBody GiftBean giftBean
    ) throws IOException {
//        String name = giftBean.getName();
//        String depict = giftBean.getDepict();
//        Integer stock = giftBean.getStock();
//        Long value = giftBean.getValue();
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

    @PostMapping("deleteGift/{id}")
    @ApiOperation(value = "该接口用于删除礼品")
    public HttpResult deleteGift(@ApiParam(value = "图片", required = true, example = "1")@PathVariable int id) {
        giftService.deleteByPrimaryKey(id);
        pictureService.deleteByRangeId(id);
        return HttpResult.ok("商品删除成功");
    }

    @PostMapping("updateGift/{id}")
    @ApiOperation(value = "该接口用于更新礼品")
    public HttpResult updateGift(@ApiParam(value = "礼品信息", required = true)@RequestBody GiftBean giftBean,@ApiParam(value = "图片", required = true,example = "1") @PathVariable int id) {
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
