package com.berg.system.service.cp.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.berg.dao.system.cp.entity.MediaTbl;
import com.berg.dao.system.cp.service.MediaTblDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MediaAsyncTask {

    @Autowired
    MediaTblDao mediaTblDao;

    /**
     * 新增素材
     * @param corpId
     * @param mediaId
     * @param url
     * @param createAt
     * @param mediaType
     * @param type
     * @param remark
     * @param user
     */
    @Async
    public void addMedia(String corpId,String mediaId,String url,Long createAt,String mediaType,Integer type,String remark,String user){
        LocalDateTime now = LocalDateTime.now();
        MediaTbl mediaTbl = new MediaTbl();
        mediaTbl.setCorpId(corpId);
        mediaTbl.setMediaId(mediaId);
        mediaTbl.setUrl(url);
        mediaTbl.setCreatedAt(createAt.intValue());
        mediaTbl.setMediaType(mediaType);
        mediaTbl.setType(type);
        mediaTbl.setRemark(remark);
        mediaTbl.setCreateTime(now);
        mediaTbl.setCreateUser(user);
        mediaTblDao.save(mediaTbl);
    }
}
