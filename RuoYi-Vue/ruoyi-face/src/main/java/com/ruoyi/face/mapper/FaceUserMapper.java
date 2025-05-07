package com.ruoyi.face.mapper;

import java.util.List;
import com.ruoyi.face.domain.FaceUser;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * 用户人脸管理Mapper接口
 *
 * @author John5
 * @date 2025-04-29
 */
public interface FaceUserMapper
{
    /**
     * 查询用户人脸管理
     *
     * @param id 用户人脸管理主键
     * @return 用户人脸管理
     */
    public FaceUser selectFaceUserById(Long id);

    /**
     * 查询用户人脸管理列表
     *
     * @param faceUser 用户人脸管理
     * @return 用户人脸管理集合
     */
    public List<FaceUser> selectFaceUserList(FaceUser faceUser);

    /**
     * 新增用户人脸管理
     *
     * @param faceUser 用户人脸管理
     * @return 结果
     */
    public int insertFaceUser(FaceUser faceUser);

    /**
     * 修改用户人脸管理
     *
     * @param faceUser 用户人脸管理
     * @return 结果
     */
    public int updateFaceUser(FaceUser faceUser);

    /**
     * 删除用户人脸管理
     *
     * @param id 用户人脸管理主键
     * @return 结果
     */
    public int deleteFaceUserById(Long id);

    /**
     * 批量删除用户人脸管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFaceUserByIds(Long[] ids);

    /**
     * 查询订阅报警的用户列表
     * @param isSubscribed 订阅状态（0表示已订阅）
     * @return 用户列表
     */
    public List<FaceUser> selectSubscribedUsers(@Param("isSubscribed") Integer isSubscribed);
}
