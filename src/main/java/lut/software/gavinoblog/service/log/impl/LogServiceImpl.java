package lut.software.gavinoblog.service.log.impl;

import lut.software.gavinoblog.mapper.LogMapper;
import lut.software.gavinoblog.pojo.Log;
import lut.software.gavinoblog.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
