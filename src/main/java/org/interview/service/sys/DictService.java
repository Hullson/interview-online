package org.interview.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.entity.sys.Dict;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DictService extends IService<Dict> {
    void saveDict(Dict dict, HttpServletRequest request);
    void delDict(String id);
    void updateDict(Dict dict, HttpServletRequest request);

    Page<Dict> listPage(Dict dict, Integer pageNum, Integer pageSize);
    List<Dict> getListByType(String type);
    List<Dict> getListByLabel(String label);
    Dict getDictByValue(String value);
}
