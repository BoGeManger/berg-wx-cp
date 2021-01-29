CREATE TABLE `cp_media_tbl` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微信企业号素材表id',
`app_id` varchar(120) NOT NULL COMMENT '微信公众号corpId',
`media_id` varchar(255) DEFAULT NULL COMMENT '素材媒体id',
`url` varchar(255) DEFAULT NULL COMMENT '素材链接',
`created_at` int(11) DEFAULT NULL COMMENT '素材文件上传时间戳',
`media_type` varchar(10) NOT NULL COMMENT '素材文件类型(image 图片 voice 语音 video 视频 thumb 缩略图)',
`type` tinyint(5) NOT NULL DEFAULT '0' COMMENT '素材类型(0 临时素材 1 永久素材)',
`remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
`create_time` datetime NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建用户',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信企业号素材表';