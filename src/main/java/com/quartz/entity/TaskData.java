package com.quartz.entity;

import java.util.Map;

/**
 *  任务接口，接口具体实现由调用者来实现
 *@author yubin
 *@date 2019/4/19
 */
public interface TaskData {
    /**
     * 任务具体的执行方法
     */
    public void execute(Map<String, Object> param);
}
