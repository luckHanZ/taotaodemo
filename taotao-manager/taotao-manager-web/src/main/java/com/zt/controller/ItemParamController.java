package com.zt.controller;

import com.zt.TaotaoResult;
import com.zt.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;
    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult queruItemByCid(@PathVariable Long cid){
        TaotaoResult itemParamById = itemParamService.getItemParamById(cid);
        return itemParamById;

    }
    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
        TaotaoResult itemParamById = itemParamService.insertItemParam(cid,paramData);
        return itemParamById;

    }

}
