package com.siro.consumer.controller.backstage;

import com.siro.consumer.service.LogisiticService;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
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
public class LogisiticsController {
    @Autowired
    private LogisiticService logisiticService;

    @PostMapping("listLogistics")
    public HttpResult listLogistics(@RequestBody PageRequest pageRequest){
        return logisiticService.listLogistics(pageRequest);
    }

    @PostMapping("deleteLogistics/{id}")
    public HttpResult deleteLogistics(@PathVariable int id){
        return logisiticService.deleteLogistics(id);
    }
}
