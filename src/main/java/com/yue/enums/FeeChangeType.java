/**
 *
 */
package com.yue.enums;

/**
 * @author maxjcs
 */
public enum FeeChangeType {

    task(1),
    selfbuy(2),
    reduceCash(3),//提现
    addCash(4),//充值
    vipReCharge(5),
    servicePrice(6),
    videoTask(7),//发布短视频(冻结)
    signVideo(8),//报名参加短视频活动(冻结)
    videoFinal(9),//终结整个单子(解冻)
    selectMoteForSeller(10), //选择模特商家退回佣金(解冻)
    selectMoteForMote(11),//选择模特模特释放保证金(解冻)
    videoMoteTaskComplete(12),//模特完成视频任务(获取酬劳解冻)
    cancelSign(13),//模特取消报名(解冻)
    sellerCancelTask(14),//商家取消短视频任务(冻结金解冻)
    ;

    private int type;

    FeeChangeType(int type) {
        this.type = type;
    }

    public int getValue() {
        return type;
    }

}
