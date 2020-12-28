package com.siro.back.controller.backstage;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import com.siro.back.service.LogisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@RequestMapping("logisitics")
@RestController
@Api(tags = "物流查询删除")
public class LogisiticsController {

    @Autowired
    private LogisticsService logisticsService;

    @ApiOperation(value = "该接口用于分页查询物流")
    @PostMapping("listLogistics")
    public HttpResult listLogistics(@ApiParam(value = "分页请求", required = true)@RequestBody PageRequest pageRequest){
        return HttpResult.ok(logisticsService.findPage(pageRequest));
    }
    @ApiOperation(value = "该接口用于删除物流")
    @PostMapping("deleteLogistics/{id}")
    public HttpResult deleteLogistics(@ApiParam(value = "分页请求", required = true,example = "1")@PathVariable int id){
        logisticsService.deleteByPrimaryKey(id);
        return HttpResult.ok("删除成功");
    }
}
