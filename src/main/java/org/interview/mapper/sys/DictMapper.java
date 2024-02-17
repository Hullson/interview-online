package org.interview.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.interview.entity.sys.Dict;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
    void delDict(@Param("id") String id);
    void updateDict(@Param("dict")Dict dict);

    List<Dict> listPage(Page<Dict> page, @Param("dict") Dict dict);
    List<Dict> getListByType(@Param("type") String type);
    List<Dict> getListByLabel(@Param("label") String label);
    Dict getDictByValue(@Param("value") String value);
}
