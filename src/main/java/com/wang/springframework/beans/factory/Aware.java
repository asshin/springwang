package com.wang.springframework.beans.factory;

/**
 * @author zsw
 * @create 2022-08-04 15:35
 */
/*
* 在 Spring 中有特别多类似这样的标记接口的设计方式，它们的存在就像是一种标
签一样，可以方便统一摘取出属于此类接口的实现类，通常会有 instanceof 一起
判断使用。*/
public interface Aware {
}
