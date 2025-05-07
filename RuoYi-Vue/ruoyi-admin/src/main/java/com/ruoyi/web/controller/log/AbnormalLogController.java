package com.ruoyi.web.controller.log;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.log.domain.AbnormalLog;
import com.ruoyi.log.service.IAbnormalLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 家居入侵异常日志Controller
 *
 * @author John5
 * @date 2025-04-29
 */
@RestController
@RequestMapping("/log/log")
public class AbnormalLogController extends BaseController
{
    @Autowired
    private IAbnormalLogService abnormalLogService;

    /**
     * 查询家居入侵异常日志列表
     */
    @PreAuthorize("@ss.hasPermi('log:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbnormalLog abnormalLog)
    {
        startPage();
        List<AbnormalLog> list = abnormalLogService.selectAbnormalLogList(abnormalLog);
        return getDataTable(list);
    }

    /**
     * 导出家居入侵异常日志列表
     */
    @PreAuthorize("@ss.hasPermi('log:log:export')")
    @Log(title = "家居入侵异常日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbnormalLog abnormalLog)
    {
        List<AbnormalLog> list = abnormalLogService.selectAbnormalLogList(abnormalLog);
        ExcelUtil<AbnormalLog> util = new ExcelUtil<AbnormalLog>(AbnormalLog.class);
        util.exportExcel(response, list, "家居入侵异常日志数据");
    }

    /**
     * 获取家居入侵异常日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('log:log:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable("logId") Long logId)
    {
        return success(abnormalLogService.selectAbnormalLogByLogId(logId));
    }

    /**
     * 新增家居入侵异常日志
     */
    @PreAuthorize("@ss.hasPermi('log:log:add')")
    @Log(title = "家居入侵异常日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbnormalLog abnormalLog)
    {
        return toAjax(abnormalLogService.insertAbnormalLog(abnormalLog));
    }

    /**
     * 修改家居入侵异常日志
     */
    @PreAuthorize("@ss.hasPermi('log:log:edit')")
    @Log(title = "家居入侵异常日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbnormalLog abnormalLog)
    {
        return toAjax(abnormalLogService.updateAbnormalLog(abnormalLog));
    }

    /**
     * 删除家居入侵异常日志
     */
    @PreAuthorize("@ss.hasPermi('log:log:remove')")
    @Log(title = "家居入侵异常日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{logIds}")
    public AjaxResult remove(@PathVariable Long[] logIds)
    {
        return toAjax(abnormalLogService.deleteAbnormalLogByLogIds(logIds));
    }

    /**
     * 自动触发新增日志接口
     */
    @PreAuthorize("@ss.hasPermi('log:log:autoAdd')")
    @PostMapping("/autoAdd")
    public AjaxResult autoAddLog() {
        int result = abnormalLogService.createAbnormalLogAuto("监测到未知人脸");
        return toAjax(result);
    }

}
