package com.quartz.service;


import com.quartz.config.QuartzManager;
import com.quartz.entity.TaskData;
import com.quartz.task.QuartzTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Date;
import java.util.Map;

/**
 *
 * 任务调度服务
 * @author yubin
 * @date 2019/4/19
 */
@Component
public class QuartzService {
    public void setQuartzManager(QuartzManager quartzManager) {
        this.quartzManager = quartzManager;
    }
    @Autowired
    private QuartzManager quartzManager;

    /**
     * 启动定时任务
     * @param jobName 定时任务名称
     * @param cron 定时任务的表达式
     * @param quartzTask 定时任务具体执行任务接口
     * @param param 执行定时任务所需要的参数
     */
    public void startTask(String jobName, String cron, TaskData quartzTask, Map<String,Object> param){
        quartzManager.addJob(jobName, jobName, jobName, jobName, QuartzTask.class, cron, quartzTask,param);
    }

    /**
     * 修改定时任务时间
     * @param jobName 任务的task名称
     * @param cron 定时任务的表达式
     */
    public void updateTaskTime(String jobName, String cron){
        quartzManager.modifyJobTime(jobName,jobName,jobName,jobName, cron);
    }

    /**
     * 移除定时任务
     * @param jobName 任务的task名称
     */
    public void removeTask(String jobName){
        quartzManager.removeJob(jobName,jobName,jobName,jobName);
    }

    /**
     * 关闭定时任务容器
     * 慎用
     */
    public void shutdownJobs(){
        // 关掉任务调度容器
        quartzManager.shutdownJobs();
    }

    /**
     * 获取正在执行的任务信息
     * @return
     * @throws
     */
    public List<String> getStartTaskJob(){
        return quartzManager.getStartTaskJob();
    }

    /**
     * 通过开始时间和结束时间开启定时任务
     * @param jobName
     * @param beginDate
     * @param endDate
     * @param repeatInterval
     */
    public void startTaskJobByTime(String jobName, Date beginDate, Date endDate, int repeatInterval, String groupName, TaskData taskData, Map<String,Object> param){
        quartzManager.startTaskJobByTime(jobName,beginDate,endDate,0,repeatInterval,groupName,taskData,param,QuartzTask.class);
    }

    public void updateRepeatInterval(String jobName,String groupName,Date startTime,Date endTime,long time){
        quartzManager.restJob(jobName,groupName,startTime,endTime,time);
    }
}
