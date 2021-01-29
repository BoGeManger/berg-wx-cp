package com.berg.system.service.cp;

import com.berg.dao.page.PageInfo;
import com.berg.vo.cp.MediaVo;
import com.berg.vo.cp.in.GetMediaPageInVo;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {

    PageInfo<MediaVo> getMediaPage(GetMediaPageInVo input);

    String upload(String corpId,String mediaType, String remark, MultipartFile multipartFile);

    String uploadImg(String corpId, String remark, MultipartFile multipartFile);
}
