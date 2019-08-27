package com.cn.springthreadpool.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOZi on 2019/2/25.
 */
@Data
public class Page<T> implements Serializable {

    private int pageSize; // 每页显示多少条记录

    private int pageNum; //当前第几页数据

    private int totalCount; // 一共多少条记录

    private List<T> list; //要显示的数据
}
