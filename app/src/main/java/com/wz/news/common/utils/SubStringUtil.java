package com.wz.news.common.utils;

/**
 * Created by wz on 17-6-1.
 */

public class SubStringUtil {

    public static String subString(String string, String prefix,String endfix){

        /**
         * <\/span><\/p>丢失了优雅的捷豹路虎仅剩下焦虑<\/span><\/p>

         来源：界面<\/p>

         隐藏在捷豹路虎光鲜数据和媒体报道的背后是无奈的大面积大幅度降价和库存指数高到惊人的经销商。很明显，这种畸形的价格策略和经销商关系不会，也不可能持续太久。<\/p>

         “大哥只要您今天来店里下订，我就再把优惠多给1万，贴膜脚垫啥的照送，行不行？”电话那头捷豹路虎的销售顾问毫无顾忌地表达着他的焦虑不安。这样的急功近利的销售方式也让这个总部位于沃里克郡盖顿村的百年英国汽车品牌所蕴藏的优雅荡然无存。<\/p>

         这种焦灼也同样炙烤着其它捷豹路虎经销商。<\/p>",
         */

        String content = "";
        String[] split = string.split(prefix);
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(endfix);
            for (int j = 0; j < split1.length; j++) {
                content += split1[i];
            }
        }

        return content;
    }
}
