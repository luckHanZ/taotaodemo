package com.zt.service;

import com.zt.TaotaoResult;
import com.zt.pojo.TbItem;
import com.zt.pojo.TbItemParam;
import com.zt.vo.ESUIResult;

import java.util.List;

public interface ItemService {
    TbItem getitemById(Long itemId);

    ESUIResult getItemList(Integer pageNuma, Integer pageSize);

    TaotaoResult createItem(TbItem tbItem, String desc);

    List<TbItemParam> itemParamList(Integer page, Integer rows);
}
