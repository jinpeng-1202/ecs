package com.jin.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author jinpeng
 * @date 2019/4/27.
 */
@FunctionalInterface
public interface LamInterface {
    String process(BufferedReader br) throws IOException;
}
