package cn.lesion.hello.start.variableLengthArgs;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created for Intellij IDEA.
 * Author:e.le.lee.
 * Date: 2016/12/4.
 */
public class VariableArgument4Java {

    /**
     * 打印参数
     * @param strings 参数的一个数组
     */
    private static void ArgumentsInfo(String... strings){
        for(int i=0;i<strings.length;i++){
            System.out.println("参数"+(i+1)+" : "+strings[i]);
        }
    }

    public static void main(String[] args) {
        ArgumentsInfo("aaa","bbb","ccc","ddd","eee");
    }

}