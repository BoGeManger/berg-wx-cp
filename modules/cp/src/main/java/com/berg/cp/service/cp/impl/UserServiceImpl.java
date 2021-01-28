package com.berg.cp.service.cp.impl;

import com.berg.common.exception.FailException;
import com.berg.cp.service.AbstractService;
import com.berg.cp.service.cp.UserService;
import com.berg.vo.cp.out.CpUserInfoOutVo;
import com.berg.wx.utils.WxCpUtil;
import me.chanjar.weixin.cp.bean.WxCpOauth2UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    /**
     * 获取用户信息
     * @param code
     * @return
     */
    @Override
    public CpUserInfoOutVo userInfo(String code){
        CpUserInfoOutVo result = new CpUserInfoOutVo();
        String corpId = getCorpId();
        try{
            WxCpOauth2UserInfo wxCpOauth2UserInfo = WxCpUtil.getService(corpId).getOauth2Service().getUserInfo(code);
            BeanUtils.copyProperties(wxCpOauth2UserInfo,result);
        }catch (Exception ex){
            throw new FailException("调用获取用户信息接口userInfo失败:"+ex.getMessage());
        }
        return result;
    }
}
