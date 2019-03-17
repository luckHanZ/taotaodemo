package com.zt.service;

import com.zt.pojo.TbItem;
import com.zt.vo.ESUIResult;

public interface ItemService {
    TbItem getitemById(Long itemId);
    ESUIResult getItemList(Integer pageNuma, Integer pageSize);

}
