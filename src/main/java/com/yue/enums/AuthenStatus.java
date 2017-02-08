/**
 *
 */
package com.yue.enums;

/**
 * @author maxjcs
 */
public enum AuthenStatus {

    waitAuthen(0), unAuthen(1), authenOK(2), authenFail(3);

    private int status;

    AuthenStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return status;
    }


    public static boolean isExist(int status) {
        for (AuthenStatus a : AuthenStatus.values()) {
            if (a.getValue() == status)
                return true;
        }
        return false;
    }

}
