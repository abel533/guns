package com.stylefeng.guns.common.persistence.dao;

import com.stylefeng.guns.common.persistence.model.Notice;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 通知表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
public interface NoticeMapper extends Mapper<Notice> {

    List<Map<String, Object>> list(@Param("condition") String condition);

}