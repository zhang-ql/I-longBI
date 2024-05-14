package com.zql.longbi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.longbi.model.entity.Chart;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【chart(图表信息表)】的数据库操作Mapper
* @createDate 2024-05-05 16:00:13
* @Entity generator.domain.Chart
*/
public interface ChartMapper extends BaseMapper<Chart> {
    List<Map<String, Object>> queryChartData(String querySql);
}




