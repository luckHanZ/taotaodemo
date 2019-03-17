package com.zt.service.impl;

import com.zt.TaotaoResult;
import com.zt.mapper.TbItemParamMapper;
import com.zt.pojo.TbItemParam;
import com.zt.pojo.TbItemParamExample;
import com.zt.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public TaotaoResult getItemParamById(Long id) {
        TbItemParamExample example = new TbItemParamExample();
        example.createCriteria().andItemCatIdEqualTo(id);
        List <TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if (tbItemParams != null && tbItemParams.size() > 0) {
            return TaotaoResult.ok(tbItemParams.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(Long cid, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        Date date = new Date();
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);
        tbItemParamMapper.insert(tbItemParam);
        return TaotaoResult.ok();
    }
}
