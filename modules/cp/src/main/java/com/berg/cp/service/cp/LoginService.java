package com.berg.cp.service.cp;

import com.berg.vo.cp.in.CpGetAuthUrlInVo;

public interface LoginService {

    String getAuthUrl(CpGetAuthUrlInVo input);
}
