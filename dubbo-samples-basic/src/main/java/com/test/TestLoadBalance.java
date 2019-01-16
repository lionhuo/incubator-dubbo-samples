/**
 * Copyright (c) 2012 Conversant Solutions. All rights reserved.
 * <p>
 * Created on 2019/1/16.
 */
package com.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;
import com.alibaba.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;

import java.util.List;

public class TestLoadBalance extends RandomLoadBalance implements LoadBalance {
    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> list, URL url, Invocation invocation) {
        for(Invoker invoker : list){
            int weight = getWeight(invoker, invocation);
            System.out.println("weight====>" + weight);
        }
        return super.doSelect(list, url, invocation);
    }
}
