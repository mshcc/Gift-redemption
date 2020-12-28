package com.siro.consumer.controller.backstage;

import com.siro.consumer.service.RecipientService;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import com.siro.vo.RecipientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class RecipientController {

    @Autowired
    private RecipientService recipientService;
    @PostMapping("listRecipients")
    public HttpResult listRecipients(@RequestBody PageRequest pageRequest){
        return recipientService.listRecipients(pageRequest);
    }

    @PostMapping("getRecipientById/{id}")
    public HttpResult getRecipientById(@PathVariable int id){
        return recipientService.getRecipientById(id);
    }


    @PostMapping("updateRecipirnt/{id}")
    public HttpResult updateRecipients(@RequestBody RecipientBean recipientBean, @PathVariable int id){
        return recipientService.updateRecipients(recipientBean,id);
    }
}
