package com.jin.network;

import com.alibaba.fastjson.JSON;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jinpeng
 * @date 2019/5/14.
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] inetAddress=InetAddress.getAllByName("baidu.com");
        System.out.println(JSON.toJSONString(inetAddress));
        System.out.println(JSON.toJSONString(InetAddress.getLocalHost()));
    }
}
