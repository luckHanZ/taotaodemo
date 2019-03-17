package com.zt.service;

import com.zt.TaotaoResult;

public interface ItemParamService {
    TaotaoResult getItemParamById(Long id);
    TaotaoResult insertItemParam(Long cid,String paramData);
}
