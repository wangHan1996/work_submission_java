package com.wh.workSubmission.util;

import com.wh.workSubmission.dto.Constant;

public class BaseUtil {

    public static String getStatusValue(String status) {
        switch (status) {
            case Constant.STATE_YTJ : {
                return "已提交";
            }
            case Constant.STATE_BHG : {
                return "不合格";
            }
            case Constant.STATE_WTJ : {
                return "未提交";
            }
            case Constant.STATE_YWC : {
                return "已完成";
            }
            default:{
                return "未提交";
            }
        }
    }
}
