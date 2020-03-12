package lut.software.gavinoblog.service.log;

import com.github.pagehelper.PageInfo;
import lut.software.gavinoblog.pojo.Log;

/**
 * @author ywg
 * @version 1.0
 * @description 日志相关Service接口
 * @date 2020/3/7 17:19
 */
public interface LogService {
    /**
     * 添加日志
     * @param action    触发动作
     * @param data      产生数据
     * @param ip        产生IP
     * @param authorId  产生人
     */
    void addLog(String action, String data, String ip, Integer authorId);

    /**
     * 获取日志
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Log> getLogs(int pageNum, int pageSize);
}
