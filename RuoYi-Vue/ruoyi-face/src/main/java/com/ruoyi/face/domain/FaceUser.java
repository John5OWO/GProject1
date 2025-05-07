package com.ruoyi.face.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户人脸管理对象 face_user
 *
 * @author John5
 * @date 2025-04-29
 */
public class FaceUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户编号 */
    private Long id;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String name;

    /** 通知邮箱 */
    @Excel(name = "通知邮箱")
    private String email;

    /** 人脸图片 */
    @Excel(name = "人脸图片")
    private String photoPath;

    /** 通知 */
    @Excel(name = "通知")
    private Integer isSubscribedAlarm;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPhotoPath(String photoPath)
    {
        this.photoPath = photoPath;
    }

    public String getPhotoPath()
    {
        return photoPath;
    }

    public void setIsSubscribedAlarm(Integer isSubscribedAlarm)
    {
        this.isSubscribedAlarm = isSubscribedAlarm;
    }

    public Integer getIsSubscribedAlarm()
    {
        return isSubscribedAlarm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("email", getEmail())
                .append("photoPath", getPhotoPath())
                .append("isSubscribedAlarm", getIsSubscribedAlarm())
                .append("createTime", getCreateTime())
                .toString();
    }
}
