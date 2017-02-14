package com.yue.enums;

public enum VideoMoteTaskStatus {
    no_sign(0),
    sign(1),//报名
    select(2),//被选中
    upload(3),//上传视频
    complete(4),//完成
    failure(5),//失败
    ;
    private int value;

    VideoMoteTaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static boolean containStatus(int value) {
        for (VideoMoteTaskStatus status : VideoMoteTaskStatus.values()) {
            if (status.getValue() == value) {
                return true;
            }
        }
        return false;
    }

}
