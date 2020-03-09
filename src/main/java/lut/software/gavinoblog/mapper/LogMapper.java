package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/8 18:28
 */
@Repository
@Mapper
public interface LogMapper {
    /**
     * 添加日志
     * @param log
     * @return
     */
    int addLog(Log log);
}
