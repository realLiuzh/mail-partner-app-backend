package com.cqupt.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 帖子检索对象
 */
@Data
@AllArgsConstructor
public class PostQuery extends BaseQuery {
    //是否是最新
    @Range(min = 0, max = 1)
    private Integer isNewest;
    //是否是最热
    @Range(min = 0,max = 1)
    private Integer isByHot;
    //查询组别
    private Integer groupId;
    //查询关键字
//    private String keyWord;
}
