package com.quartz.task;
import com.quartz.entity.TaskData;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Map;

/**
 *
 *  定时任务
 * @author yubin
 * @date 2019/4/19
 */
public class QuartzTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //执行任务
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        TaskData quartzTask = (TaskData)dataMap.get("task");
        Map<String,Object> param = (Map<String, Object>) dataMap.get("param");
        // 调用接口函数
        quartzTask.execute(param);
    }
}
