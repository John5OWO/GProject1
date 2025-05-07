package com.ruoyi.log.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 家居入侵异常日志对象 abnormal_log
 *
 * @author John5
 * @date 2025-04-29
 */
public class AbnormalLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志编号 */
    @Excel(name = "日志编号")
    private Long logId;

    /** 异常时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @Excel(name = "异常时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date eventTime;

    /** 查询起始时间 */
    private String beginTime;

    /** 查询结束时间 */
    private String endTime;


    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer status;

    public void setLogId(Long logId)
    {
        this.logId = logId;
    }

    public Long getLogId()
    {
        return logId;
    }

    public void setEventTime(Date eventTime)
    {
        this.eventTime = eventTime;
    }

    public Date getEventTime()
    {
        return eventTime;
    }


    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("logId", getLogId())
                .append("eventTime", getEventTime())
                .append("status", getStatus())
                .append("remark", getRemark())
                .toString();
    }
}
