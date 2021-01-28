package com.berg.system.service.miniapp.impl;

import com.berg.system.service.miniapp.AppService;
import com.berg.vo.cp.CpAppVo;
import com.berg.wx.properties.WxCpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    WxCpProperties properties;

    /**
     * 获取小程序应用列表
     * @return
     */
    @Override
    public List<CpAppVo> getAppList(){
        List<CpAppVo> list = new ArrayList<>();
        properties.getConfigs().forEach(item->{
            CpAppVo maAppVo = new CpAppVo();
            maAppVo.setAgentId(item.getAgentId());
            maAppVo.setCorpId(item.getCorpId());
            maAppVo.setName(item.getName());
        });
        return list;
    }
}
