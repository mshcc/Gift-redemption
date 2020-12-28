package com.siro.demo.controller.backstage;

import com.siro.demo.service.LogisticsService;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.utils.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@RequestMapping("logisitics")
@RestController
public class LogisiticsController {

    @Autowired
    private LogisticsService logisticsService;

    @PostMapping("listLogistics")
    public HttpResult listLogistics(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(logisticsService.findPage(pageRequest));
    }
    @PostMapping("deleteLogistics/{id}")
    public HttpResult listLogistics(@PathVariable int id){
        logisticsService.deleteByPrimaryKey(id);
        return HttpResult.ok("删除成功");
    }
}
