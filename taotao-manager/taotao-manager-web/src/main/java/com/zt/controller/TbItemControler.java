package com.zt.controller;

import com.zt.TaotaoResult;
import com.zt.pojo.TbItem;
import com.zt.pojo.TbItemParam;
import com.zt.service.ItemService;
import com.zt.vo.ESUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TbItemControler {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemByid(@PathVariable Long itemId){
        TbItem tbItem = itemService.getitemById(itemId);
        return tbItem;
    }
    @RequestMapping("/item/list")
    @ResponseBody
    public ESUIResult getTbItemList(Integer page, Integer rows){
        ESUIResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }
    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult createItem(TbItem tbItem,String desc){
        TaotaoResult item = itemService.createItem(tbItem, desc);
        return item;
    }
    @RequestMapping("/item/param/list")
    @ResponseBody
    public List<TbItemParam> itemParamList(Integer page, Integer rows){
        List<TbItemParam> item = itemService.itemParamList(page, rows);
        return item;
    }

}
