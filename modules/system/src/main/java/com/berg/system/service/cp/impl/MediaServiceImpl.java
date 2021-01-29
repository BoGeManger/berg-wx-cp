package com.berg.system.service.cp.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.berg.auth.system.service.AbstractService;
import com.berg.common.exception.FailException;
import com.berg.dao.page.PageInfo;
import com.berg.dao.system.cp.entity.MediaTbl;
import com.berg.dao.system.cp.service.MediaTblDao;
import com.berg.system.service.cp.MediaService;
import com.berg.vo.cp.MediaVo;
import com.berg.vo.cp.in.GetMediaPageInVo;
import com.berg.wx.utils.WxCpUtil;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class MediaServiceImpl extends AbstractService implements MediaService {

    @Autowired
    MediaTblDao mediaTblDao;
    @Autowired
    MediaAsyncTask mediaAsyncTask;

    /**
     *  获取素材分页列表
     * @param input
     * @return
     */
    @Override
    public PageInfo<MediaVo> getMediaPage(GetMediaPageInVo input){
        return mediaTblDao.page(input,()->{
            LambdaQueryWrapper query = new LambdaQueryWrapper<MediaTbl>().
                    eq(MediaTbl::getCorpId,input.getCorpId());
            return mediaTblDao.list(query,MediaVo.class);
        });
    }

    /**
     * 上传临时素材
     * @param corpId
     * @param mediaType
     * @param remark
     * @param multipartFile
     * @return
     */
    @Override
    public String upload(String corpId,String mediaType, String remark, MultipartFile multipartFile){
        String mediaId = "";
        File file = null;
        String operator = getUsername();
        try{
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            file = File.createTempFile(filename[0], "."+filename[1]);
            multipartFile.transferTo(file);
            WxMediaUploadResult wxMediaUploadResult = WxCpUtil.getService("").getMediaService().upload(mediaType,file);
            //新增记录
            mediaAsyncTask.addMedia(corpId,wxMediaUploadResult.getMediaId(),null
                    ,wxMediaUploadResult.getCreatedAt(),mediaType,1,remark,operator);
            mediaId = wxMediaUploadResult.getMediaId();
        }catch (Exception ex){
            throw new FailException("调用企业号上传临时素材接口upload失败:"+ex.getMessage());
        }finally {
            file.deleteOnExit();
        }
        return mediaId;
    }

    /**
     * 上传图片（URL永久有效）
     * 每个企业每天最多可上传100张图片
     * @param corpId
     * @param remark
     * @param multipartFile
     */
    @Override
    public String uploadImg(String corpId, String remark, MultipartFile multipartFile){
        String url = "";
        File file = null;
        String operator = getUsername();
        try{
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            file = File.createTempFile(filename[0], "."+filename[1]);
            multipartFile.transferTo(file);
            url = WxCpUtil.getService("").getMediaService().uploadImg(file);
            //新增记录
            mediaAsyncTask.addMedia(corpId,null,url
                    ,null,"image",0,remark,operator);
        }catch (Exception ex){
            throw new FailException("调用企业号上传图片永久素材接口uploadImg失败:"+ex.getMessage());
        }finally {
            file.deleteOnExit();
        }
        return url;
    }
}
