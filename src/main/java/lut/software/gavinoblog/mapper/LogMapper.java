package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/8 18:28
 */
@Repository
//@Mapper
public interface LogMapper {
    /**
     * 添加日志
     * @param log
     * @return
     */
    int addLog(Log log);

    /**
     * 获取日志
     * @return
     */
//    @Select("SELECT l.id, l.action, l.data, l.authorId, l.ip, l.created FROM t_logs AS l ORDER BY l.id DESC")
    List<Log> getLogs();
}
