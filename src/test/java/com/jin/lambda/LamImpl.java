package com.jin.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author jinpeng
 * @date 2019/4/28.
 */
public class LamImpl {

    public void testLam(LamInterface lam) throws IOException {
        System.out.println("testLam");
        BufferedReader br = new BufferedReader(
                new FileReader("D:\\code\\ecs\\src\\test\\java\\com\\jin\\lambda\\aaa.txt"));
        System.out.println(lam.process(br));
        br.close();
    }

    public List<String> filter (List<String> list, Predicate<String> predicate){
        List<String> result=new ArrayList<>();
        for(String item:list){
            if(predicate.test(item)){
                result.add(item);
            }
        }
        return result;
    }
}
