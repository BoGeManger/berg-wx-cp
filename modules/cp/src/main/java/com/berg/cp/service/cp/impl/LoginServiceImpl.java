package com.berg.cp.service.cp.impl;

import com.berg.common.exception.FailException;
import com.berg.cp.service.AbstractService;
import com.berg.cp.service.cp.LoginService;
import com.berg.vo.cp.in.CpGetAuthUrlInVo;
import com.berg.wx.utils.WxCpUtil;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends AbstractService implements LoginService {

    /**
     * 获取微信网页授权地址
     * @param input
     * @return
     */
    @Override
    public String getAuthUrl(CpGetAuthUrlInVo input){
        String corpId = getCorpId();
        String url = null;
        try{
            url = WxCpUtil.getService(corpId).getOauth2Service().buildAuthorizationUrl(input.getRedirectUri(),input.getState());
        }catch (Exception ex){
            throw new FailException("调用企业号获取网页授权地址接口getAuthUrl失败:"+ex.getMessage());
        }
        return url;
    }
}
