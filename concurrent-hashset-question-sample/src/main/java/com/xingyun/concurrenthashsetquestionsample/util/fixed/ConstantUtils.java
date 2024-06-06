package com.xingyun.concurrenthashsetquestionsample.util.fixed;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xing yun
 */
public class ConstantUtils {

    private static final Set<String> goodApiList=new HashSet<>();

    static {
        if(goodApiList.isEmpty()){
            goodApiList.add("A");
            goodApiList.add("B");
            goodApiList.add("C");
            goodApiList.add("D");
            goodApiList.add("E");
            goodApiList.add("F");
            goodApiList.add("G");
            goodApiList.add("H");
            goodApiList.add("I");
            goodApiList.add("J");
            goodApiList.add("K");
        }
    }

    public static Set<String> getGoodApiList() {
        return goodApiList;
    }
    /**
     * 静态工具类应该禁用其构造方法
     */
    private ConstantUtils(){}
}