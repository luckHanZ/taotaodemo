package com.zt.service.impl;

import com.zt.IDUtils;
import com.zt.service.PictureService;
import com.zt.vo.ImageResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureServiceImpl implements PictureService {


    @Override
    public ImageResult uploadPic(MultipartFile multipartFile) {
        String genImageName = IDUtils.genImageName();
        ImageResult imageResult=new ImageResult();
        imageResult.setError(0);
        imageResult.setMessage(genImageName);
        imageResult.setUrl("http://img.youxiniao.com/uploads/allimg/160428/63-16042R34430.jpg");
        return imageResult;
    }
}
