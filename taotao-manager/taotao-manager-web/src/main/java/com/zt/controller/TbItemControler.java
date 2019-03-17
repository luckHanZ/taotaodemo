package com.zt.controller;

import com.zt.pojo.TbItem;
import com.zt.service.ItemService;
import com.zt.vo.ESUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ESUIResult getTbItemList(Integer page, Integer rows, Model model){
        ESUIResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }

}
