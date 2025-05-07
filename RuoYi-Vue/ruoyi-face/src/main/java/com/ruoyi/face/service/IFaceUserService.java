package com.ruoyi.face.service;

import java.util.List;
import com.ruoyi.face.domain.FaceUser;

/**
 * 用户人脸管理Service接口
 *
 * @author John5
 * @date 2025-04-29
 */
public interface IFaceUserService
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
     * 批量删除用户人脸管理
     *
     * @param ids 需要删除的用户人脸管理主键集合
     * @return 结果
     */
    public int deleteFaceUserByIds(Long[] ids);

    /**
     * 删除用户人脸管理信息
     *
     * @param id 用户人脸管理主键
     * @return 结果
     */
    public int deleteFaceUserById(Long id);
}
