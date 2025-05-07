package com.ruoyi.log.service;

import java.util.List;
import com.ruoyi.log.domain.AbnormalLog;
import org.springframework.transaction.annotation.Transactional;

/**
 * 家居入侵异常日志Service接口
 *
 * @author John5
 * @date 2025-04-29
 */
public interface IAbnormalLogService
{
    /**
     * 查询家居入侵异常日志
     *
     * @param logId 家居入侵异常日志主键
     * @return 家居入侵异常日志
     */
    public AbnormalLog selectAbnormalLogByLogId(Long logId);

    /**
     * 查询家居入侵异常日志列表
     *
     * @param abnormalLog 家居入侵异常日志
     * @return 家居入侵异常日志集合
     */
    public List<AbnormalLog> selectAbnormalLogList(AbnormalLog abnormalLog);

    /**
     * 新增家居入侵异常日志
     *
     * @param abnormalLog 家居入侵异常日志
     * @return 结果
     */
    public int insertAbnormalLog(AbnormalLog abnormalLog);

    /**
     * 修改家居入侵异常日志
     *
     * @param abnormalLog 家居入侵异常日志
     * @return 结果
     */
    public int updateAbnormalLog(AbnormalLog abnormalLog);

    /**
     * 批量删除家居入侵异常日志
     *
     * @param logIds 需要删除的家居入侵异常日志主键集合
     * @return 结果
     */
    public int deleteAbnormalLogByLogIds(Long[] logIds);

    /**
     * 删除家居入侵异常日志信息
     *
     * @param logId 家居入侵异常日志主键
     * @return 结果
     */
    public int deleteAbnormalLogByLogId(Long logId);

    /**
     * 自动生成居入侵异常日志信息
     */
    public int createAbnormalLogAuto(String remark);
}
