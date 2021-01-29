package com.berg.dao.system.cp.service;

import com.berg.dao.system.cp.entity.MediaTbl;
import com.berg.dao.base.IService;
import com.berg.dao.system.cp.mapper.MediaTblMapper;

/**
 * <p>
 * 微信企业号素材表 服务类
 * </p>
 *
 * @author 
 * @since 2021-01-28
 */
public interface MediaTblDao extends IService<MediaTbl> {
   MediaTblMapper getMapper();
}
