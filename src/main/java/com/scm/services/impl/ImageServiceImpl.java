package com.scm.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.scm.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String uploadImage(MultipartFile contactImage) {
        // TEMP implementation (you can later add Cloudinary / AWS logic)
        if (contactImage == null || contactImage.isEmpty()) {
            return null;
        }
        return contactImage.getOriginalFilename();
    }
}
