package com.zt.service.impl;

import com.zt.mapper.TbItemCatMapper;
import com.zt.pojo.TbItemCat;
import com.zt.pojo.TbItemCatExample;
import com.zt.service.ItemCatService;
import com.zt.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List <TreeNode> getItemCatLIST(Long id) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria().andParentIdEqualTo(id);
        List <TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        List <TreeNode> list = new ArrayList <>();
        for (TbItemCat tbItemCat : tbItemCats) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(tbItemCat.getId());
            treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
            treeNode.setText(tbItemCat.getName());
            list.add(treeNode);
        }
        return list;
    }
}
