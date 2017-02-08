package com.yue.validator;


import com.yue.exception.ValidateException;
import com.yue.util.ValidateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


/**
 * @author czl
 */
public class Validator {
    // 允许图片类型
    private static String[] fileType = new String[]{"png", "jpg", "jpeg", "bmp", "aae"};
    private static String[] videoType = new String[]{"mp4", "mp3"};

    // 文件大小 20M
    private static final long IMG_MAX_SIZE = 20 * 1024 * 1024;

    private static final long VIDEO_MAX_SIZE = 20 * 1024 * 1024;

    public static void validateLtZero(Number num, String msg) {
        if (num == null || num.longValue() < 1) {
            throw new ValidateException(msg);
        }
    }

    public static void validateBlank(String str, String msg) {
        if (StringUtils.isBlank(str)) {
            throw new ValidateException(msg);
        }
    }

    public static void validateMinLength(String str, int length, String msg) {
        if (StringUtils.isBlank(str) || StringUtils.length(str) < length) {
            throw new ValidateException(msg);
        }
    }

    public static void validateBlank(Long value, String msg) {
        if (value == null) {
            throw new ValidateException(msg);
        }
    }

    public static void validateBlank(Integer value, String msg) {
        if (value == null) {
            throw new ValidateException(msg);
        }
    }

    public static void validateBlank(Double value, String msg) {
        if (value == null) {
            throw new ValidateException(msg);
        }
    }


    public static void validateBlank(BigDecimal value, String msg) {
        if (value == null) {
            throw new ValidateException(msg);
        }
    }

    @SuppressWarnings("rawtypes")
    public static void validateCollectionEmpty(Collection value, String msg) {
        if (value == null || value.isEmpty()) {
            throw new ValidateException(msg);
        }
    }

    public static void validateArrayEmpty(Object[] value, String msg) {
        if (value == null || value.length == 0) {
            throw new ValidateException(msg);
        }
    }

    public static void validateMobile(String str, String msg) {
        validateBlank(str, "手机号不能为空.");
        if (!ValidateUtil.isMobile(str)) {
            throw new ValidateException(msg);
        }
    }

    /* public static void validateImageFile(MultipartFile file) {
         if (file == null || file.isEmpty()) {
             throw new ValidateException("文件为空");
         }
         if (file.getSize() > IMG_MAX_SIZE) {
             throw new ValidateException("文件太大，不能超过20M");
         }
         if (!FileUtil.isAllowType(fileType, file.getOriginalFilename())) {
             throw new ValidateException("图片类型不对，只能上传png,jpg,jpeg");
         }
     }

     public static void validateVideoFile(MultipartFile file) {
         if (file == null || file.isEmpty()) {
             throw new ValidateException("文件为空");
         }
         if (file.getSize() > VIDEO_MAX_SIZE) {
             throw new ValidateException("文件太大，不能超过20M");
         }
         if (!FileUtil.isAllowType(videoType, file.getOriginalFilename())) {
             throw new ValidateException("视频类型不对，只能上传mp4格式的文件");
         }
     }
 */
    public static void validateFile(MultipartFile file, String msg) {
        if (file == null || file.isEmpty()) {
            throw new ValidateException(msg);
        }
    }

    public static void validateContainsEnum(List<?> all, Object item, String msg) {
        if (!all.contains(item)) {
            throw new ValidateException(msg);
        }
    }
}
