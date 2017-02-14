/**
 * 
 */
package com.yue.enums;

/***
 * 
 * @author admin
 *	审核状态
 */
public enum VideoTaskApproveStatus {
	
	waitApprove(1),
	approved(2),
	approveNotThrough(3),
	;
    
    private int code;
    
    VideoTaskApproveStatus(int code){
        this.code = code;
    }
    
    public int getValue(){
        return code;
    }
}
