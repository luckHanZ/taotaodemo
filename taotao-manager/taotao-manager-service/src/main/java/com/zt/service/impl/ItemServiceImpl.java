package com.zt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.IDUtils;
import com.zt.TaotaoResult;
import com.zt.mapper.TbItemDescMapper;
import com.zt.mapper.TbItemMapper;
import com.zt.mapper.TbItemParamMapper;
import com.zt.pojo.*;
import com.zt.service.ItemService;
import com.zt.vo.ESUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    TbItemMapper tbItemMapper;
    @Autowired
    TbItemDescMapper tbItemDescMapper;
    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public TbItem getitemById(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public ESUIResult getItemList(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        TbItemExample tbItemExample = new TbItemExample();
        tbItemExample.createCriteria();
        List <TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        PageInfo <TbItem> tbItemPageInfo = new PageInfo <>(tbItems);
        ESUIResult esuiResult = new ESUIResult();
        esuiResult.setRows(tbItemPageInfo.getList());
        esuiResult.setTotal(tbItemPageInfo.getTotal());
        return esuiResult;
    }

    @Override
    public TaotaoResult createItem(TbItem tbItem, String desc) {
        long genItemId = IDUtils.genItemId();
        tbItem.setId(genItemId);
        tbItem.setStatus((byte) 1);
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItemMapper.insert(tbItem);
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(genItemId);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDescMapper.insert(tbItemDesc);
        return TaotaoResult.ok();
    }

    @Override
    public List <TbItemParam> itemParamList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        TbItemParamExample example = new TbItemParamExample();
        example.createCriteria();
        return  tbItemParamMapper.selectByExample(example);
    }
}
