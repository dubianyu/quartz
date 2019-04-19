package com.quartz.task.job;

import com.quartz.entity.TaskData;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * @author yubin
 * @date 2019/4/19
 */

@Component
public class TestJob implements TaskData {

    @Override
    public void execute(Map<String, Object> param) {
        if(param != null) {
            String actId = (String) param.get("testId");
            System.out.println("TestJob定时任务执行了,参数是："+actId);
        }else {
            System.out.println("TestJob定时任务执行了,没有参数");
        }
    }
}
