package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
* 分页查询结果封装类
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;  // 总条数
    private List rows;   // 查询的数据列表
}
