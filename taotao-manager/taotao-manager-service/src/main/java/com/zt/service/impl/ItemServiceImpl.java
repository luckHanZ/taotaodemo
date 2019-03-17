package com.zt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.mapper.TbItemMapper;
import com.zt.pojo.TbItem;
import com.zt.pojo.TbItemExample;
import com.zt.service.ItemService;
import com.zt.vo.ESUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    TbItemMapper tbItemMapper;
    @Override
    public TbItem getitemById(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public ESUIResult getItemList(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        TbItemExample tbItemExample=new TbItemExample();
        tbItemExample.createCriteria();
        List <TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> tbItemPageInfo=new PageInfo <>(tbItems);
        ESUIResult esuiResult=new ESUIResult();
        esuiResult.setRows(tbItemPageInfo.getList());
        esuiResult.setTotal(tbItemPageInfo.getTotal());
        return esuiResult;
    }
}
