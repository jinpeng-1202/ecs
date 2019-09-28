package com.jin.lambda;

import com.jin.model.TUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jinpeng
 * @date 2019/4/27.
 */
public class Test {

    private static int n = 0;

    public static void main(String[] args) throws IOException {

        List<String> list= Arrays.asList("r","v","a");
        list.sort((s1,s2)->s1.compareTo(s2));
        list.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        list.sort(String::compareTo);
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);

        List<TUser> users=new ArrayList<>();
        users.sort((u1,u2)->u1.compareTo(u2));
        users.sort(TUser::compareTo2);

    }


}
