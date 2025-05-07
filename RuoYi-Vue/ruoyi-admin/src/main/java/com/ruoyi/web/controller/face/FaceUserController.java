package com.ruoyi.face.controller;

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
import com.ruoyi.face.domain.FaceUser;
import com.ruoyi.face.service.IFaceUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户人脸管理Controller
 *
 * @author John5
 * @date 2025-04-29
 */
@RestController
@RequestMapping("/face/user")
public class FaceUserController extends BaseController
{
    @Autowired
    private IFaceUserService faceUserService;

    /**
     * 查询用户人脸管理列表
     */
    @PreAuthorize("@ss.hasPermi('face:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(FaceUser faceUser)
    {
        startPage();
        List<FaceUser> list = faceUserService.selectFaceUserList(faceUser);
        return getDataTable(list);
    }

    /**
     * 导出用户人脸管理列表
     */
    @PreAuthorize("@ss.hasPermi('face:user:export')")
    @Log(title = "用户人脸管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FaceUser faceUser)
    {
        List<FaceUser> list = faceUserService.selectFaceUserList(faceUser);
        ExcelUtil<FaceUser> util = new ExcelUtil<FaceUser>(FaceUser.class);
        util.exportExcel(response, list, "用户人脸管理数据");
    }

    /**
     * 获取用户人脸管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('face:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(faceUserService.selectFaceUserById(id));
    }

    /**
     * 新增用户人脸管理
     */
    @PreAuthorize("@ss.hasPermi('face:user:add')")
    @Log(title = "用户人脸管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FaceUser faceUser)
    {
        return toAjax(faceUserService.insertFaceUser(faceUser));
    }

    /**
     * 修改用户人脸管理
     */
    @PreAuthorize("@ss.hasPermi('face:user:edit')")
    @Log(title = "用户人脸管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FaceUser faceUser)
    {
        return toAjax(faceUserService.updateFaceUser(faceUser));
    }

    /**
     * 删除用户人脸管理
     */
    @PreAuthorize("@ss.hasPermi('face:user:remove')")
    @Log(title = "用户人脸管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(faceUserService.deleteFaceUserByIds(ids));
    }
}
