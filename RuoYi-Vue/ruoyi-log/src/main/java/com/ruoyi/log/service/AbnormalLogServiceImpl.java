package com.ruoyi.log.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.face.domain.FaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.log.mapper.AbnormalLogMapper;
import com.ruoyi.log.domain.AbnormalLog;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.face.mapper.FaceUserMapper;


/**
 * 家居入侵异常日志Service业务层处理
 *
 * @author John5
 * @date 2025-04-29
 */
@Service
public class AbnormalLogServiceImpl implements IAbnormalLogService {
    @Autowired
    private AbnormalLogMapper abnormalLogMapper;

    @Autowired
    private FaceUserMapper faceUserMapper;

    @Autowired
    private MailService mailService;


    /**
     * 查询家居入侵异常日志
     *
     * @param logId 家居入侵异常日志主键
     * @return 家居入侵异常日志
     */
    @Override
    public AbnormalLog selectAbnormalLogByLogId(Long logId) {
        return abnormalLogMapper.selectAbnormalLogByLogId(logId);
    }

    /**
     * 查询家居入侵异常日志列表
     *
     * @param abnormalLog 家居入侵异常日志
     * @return 家居入侵异常日志
     */
    @Override
    public List<AbnormalLog> selectAbnormalLogList(AbnormalLog abnormalLog) {
        return abnormalLogMapper.selectAbnormalLogList(abnormalLog);
    }

    /**
     * 新增家居入侵异常日志
     *
     * @param abnormalLog 家居入侵异常日志
     * @return 结果
     */
    @Override
    public int insertAbnormalLog(AbnormalLog abnormalLog) {
        return abnormalLogMapper.insertAbnormalLog(abnormalLog);
    }

    /**
     * 修改家居入侵异常日志
     *
     * @param abnormalLog 家居入侵异常日志
     * @return 结果
     */
    @Override
    public int updateAbnormalLog(AbnormalLog abnormalLog) {
        return abnormalLogMapper.updateAbnormalLog(abnormalLog);
    }

    /**
     * 批量删除家居入侵异常日志
     *
     * @param logIds 需要删除的家居入侵异常日志主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalLogByLogIds(Long[] logIds) {
        return abnormalLogMapper.deleteAbnormalLogByLogIds(logIds);
    }

    /**
     * 删除家居入侵异常日志信息
     *
     * @param logId 家居入侵异常日志主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalLogByLogId(Long logId) {
        return abnormalLogMapper.deleteAbnormalLogByLogId(logId);
    }


    // 新增自动创建方法
    @Override
    @Transactional
    public int createAbnormalLogAuto(String remark) {
        AbnormalLog log = new AbnormalLog();
        log.setEventTime(new Date());  // 自动设置当前时间
        log.setStatus(0);              // 默认未处理状态
        log.setRemark(remark);
//        return this.insertAbnormalLog(log); // 复用已有插入方法

        int result = abnormalLogMapper.insertAbnormalLog(log);

        // 查询订阅邮件的用户并发送邮件
        List<FaceUser> users = faceUserMapper.selectSubscribedUsers(0);
        String subject = "家居异常告警";
        String content = "摄像头监测到异常。";

        for (FaceUser user : users) {
            try {
                mailService.sendSimpleMail(user.getEmail(), subject, content);
            } catch (Exception e) {
                System.err.println("邮件发送失败，收件人：" + user.getEmail());
                e.printStackTrace();
            }
        }

        return result;
    }
}