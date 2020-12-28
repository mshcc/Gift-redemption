package com.siro.producer.controller.backstage;

import com.siro.http.HttpResult;
import com.siro.model.Recipient;
import com.siro.page.PageRequest;
import com.siro.producer.service.RecipientService;
import com.siro.vo.RecipientBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * @author mshcc
 * @date 2020/12/25
 */
@RestController
@RequestMapping("recipient")
@Api(tags = "收件人信息改查")
public class RecipientController {
    @Autowired
    private RecipientService recipientService;

    @ApiOperation(value = "该接口用于分页查询物流")
    @PostMapping("listRecipients")
    public HttpResult listRecipients(@ApiParam(value = "分页请求", required = true)@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(recipientService.findPage(pageRequest));
    }

    @ApiOperation(value = "该接口用于查询收件人详情")
    @PostMapping("getRecipientById/{id}")
    public HttpResult getRecipientById(@ApiParam(value = "id", required = true,example = "1")@PathVariable int id){
        return HttpResult.ok(recipientService.selectByPrimaryKey(id));
    }


    @PreAuthorize("hasAuthority('super')")
    @PostMapping("updateRecipirnt/{id}")
    @ApiOperation(value = "该接口用于更新收件人")
    public HttpResult updateRecipients(@ApiParam(value = "收件人", required = true,example = "1")@RequestBody RecipientBean recipientBean, @ApiParam(value = "id", required = true,example = "1")@PathVariable int id) {
        String name = recipientBean.getName();
        String address = recipientBean.getAddress();
        String phone = recipientBean.getPhone();
        Recipient recipient = recipientService.selectByPrimaryKey(id);
        recipient.setName(name);
        recipient.setAddress(address);
        recipient.setPhone(phone);
        recipientService.updateByPrimaryKeySelective(recipient);
        return HttpResult.ok("收件人信息更新成功");
    }
}
