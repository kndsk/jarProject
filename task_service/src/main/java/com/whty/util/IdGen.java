
package com.whty.util;

import java.util.UUID;

/**
 * @description id生成工具
 * @author xus
 * @date 2016年8月24日
 */
public class IdGen {

    /**
     * 基于UUID生成复杂字符串
     * 
     * @Description
     * @return
     */
    public static String get() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
