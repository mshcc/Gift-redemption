package com.siro.consumer.controller.reception;

import com.siro.consumer.service.FrontRecipientService;
import com.siro.http.HttpResult;
import com.siro.vo.RecipientBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class FrontRecipientController {
    private FrontRecipientService frontRecipientService;


    @PostMapping("addRecipient")
    public HttpResult addRecipient(@RequestBody RecipientBean recipientBean) {
        return frontRecipientService.addRecipient(recipientBean);
    }
}
