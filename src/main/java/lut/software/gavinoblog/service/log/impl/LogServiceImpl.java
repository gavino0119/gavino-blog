package lut.software.gavinoblog.service.log.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lut.software.gavinoblog.mapper.LogMapper;
import lut.software.gavinoblog.pojo.Log;
import lut.software.gavinoblog.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/7 17:20
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public void addLog(String action, String data, String ip, Integer authorId) {
        Log log = new Log();
        log.setAuthorId(authorId);
        log.setIp(ip);
        log.setData(data);
        log.setAction(action);
        logMapper.addLog(log);
    }

    @Override
    public PageInfo<Log> getLogs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Log> logs = logMapper.getLogs();
        PageInfo<Log> pageInfo = new PageInfo<>(logs);
        return pageInfo;
    }
}
