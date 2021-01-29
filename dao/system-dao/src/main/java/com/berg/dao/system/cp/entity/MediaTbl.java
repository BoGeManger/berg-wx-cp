package com.berg.dao.system.cp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信企业号素材表
 * </p>
 *
 * @author 
 * @since 2021-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_media_tbl")
public class MediaTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信企业号素材表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 微信企业号corpId
     */
    private String corpId;

    /**
     * 素材媒体id
     */
    private String mediaId;

    /**
     * 素材链接
     */
    private String url;

    /**
     * 素材文件上传时间戳
     */
    private Integer createdAt;

    /**
     * 素材文件类型(image 图片 voice 语音 video 视频 thumb 缩略图)
     */
    private String mediaType;

    /**
     * 素材类型(0 临时素材 1 永久素材)
     */
    private Integer type;

    /**
     * 描述
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    private String createUser;


}
