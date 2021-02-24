package com.berg.system.controller.cp;

import com.berg.common.constant.Result;
import com.berg.common.controller.AbstractController;
import com.berg.dao.page.PageInfo;
import com.berg.system.service.cp.MediaService;
import com.berg.vo.cp.MediaVo;
import com.berg.vo.cp.in.GetMediaPageInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/media")
@Api(tags = "微信企业号素材管理")
public class MediaController extends AbstractController {

    @Autowired
    MediaService mediaService;

    @ApiOperation("获取素材分页列表")
    @GetMapping(value = "getMediaPage")
    public Result<PageInfo<MediaVo>> getMediaPage(@Validated GetMediaPageInVo input){
        return success("请求成功",()->mediaService.getMediaPage(input));
    }


    @ApiOperation("上传临时素材")
    @PostMapping(value = "mediaUpload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> mediaUpload(@ApiParam(value = "文件",required = true) @RequestPart(value = "file") MultipartFile file,
                                       @ApiParam(value = "微信企业号corpId",required = true) @RequestParam(value = "corpId") String corpId,
                                       @ApiParam(value = "素材类型(image 图片 voice 语音 video 视频 thumb 缩略图)",required = true) @RequestParam(value = "mediaType") String mediaType,
                                       @ApiParam(value = "描述") @RequestParam(value = "remark",required = false)String remark){
        return success("请求成功",()->mediaService.upload(corpId,mediaType,remark,file));
    }

    @ApiOperation("上传图片")
    @PostMapping(value = "uploadImg",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadImg(@ApiParam(value = "文件",required = true) @RequestPart(value = "file") MultipartFile file,
                                       @ApiParam(value = "微信企业号corpId",required = true) @RequestParam(value = "corpId") String corpId,
                                       @ApiParam(value = "描述") @RequestParam(value = "remark",required = false)String remark){
        return success("请求成功",()->mediaService.uploadImg(corpId,remark,file));
    }
}
