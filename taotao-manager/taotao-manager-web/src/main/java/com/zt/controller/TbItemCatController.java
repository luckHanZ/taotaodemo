package com.zt.controller;

import com.zt.service.ItemCatService;
import com.zt.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(defaultValue = "0") Long id){
        List <TreeNode> itemCatLIST = itemCatService.getItemCatLIST(id);
        return itemCatLIST;

    }
}
