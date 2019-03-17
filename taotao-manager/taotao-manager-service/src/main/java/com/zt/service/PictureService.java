package com.zt.service;

import com.zt.vo.ImageResult;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    ImageResult uploadPic(MultipartFile multipartFile);
}
