package com.berg.dao.system.cp.service.impl;

import com.berg.dao.system.cp.entity.MediaTbl;
import com.berg.dao.system.cp.mapper.MediaTblMapper;
import com.berg.dao.system.cp.service.MediaTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;
import com.berg.dao.constant.DataSource;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

/**
 * <p>
 * 微信企业号素材表 服务实现类
 * </p>
 *
 * @author 
 * @since 2021-01-28
 */
@DS(DataSource.SYSTEM)
@Repository("system.MediaTblDaoImpl")
public class MediaTblDaoImpl extends ServiceImpl<MediaTblMapper, MediaTbl> implements MediaTblDao {

    @Override
    public MediaTblMapper getMapper(){
      DynamicDataSourceContextHolder.push(DataSource.SYSTEM);
      return this.getBaseMapper();
    }
}
