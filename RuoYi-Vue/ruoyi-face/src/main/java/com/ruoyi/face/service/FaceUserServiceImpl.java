package com.ruoyi.face.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.face.mapper.FaceUserMapper;
import com.ruoyi.face.domain.FaceUser;
import com.ruoyi.face.service.IFaceUserService;

/**
 * 用户人脸管理Service业务层处理
 *
 * @author John5
 * @date 2025-04-29
 */
@Service
public class FaceUserServiceImpl implements IFaceUserService
{
    @Autowired
    private FaceUserMapper faceUserMapper;

    /**
     * 查询用户人脸管理
     *
     * @param id 用户人脸管理主键
     * @return 用户人脸管理
     */
    @Override
    public FaceUser selectFaceUserById(Long id)
    {
        return faceUserMapper.selectFaceUserById(id);
    }

    /**
     * 查询用户人脸管理列表
     *
     * @param faceUser 用户人脸管理
     * @return 用户人脸管理
     */
    @Override
    public List<FaceUser> selectFaceUserList(FaceUser faceUser)
    {
        return faceUserMapper.selectFaceUserList(faceUser);
    }

    /**
     * 新增用户人脸管理
     *
     * @param faceUser 用户人脸管理
     * @return 结果
     */
    @Override
    public int insertFaceUser(FaceUser faceUser)
    {
        faceUser.setCreateTime(DateUtils.getNowDate());
        return faceUserMapper.insertFaceUser(faceUser);
    }

    /**
     * 修改用户人脸管理
     *
     * @param faceUser 用户人脸管理
     * @return 结果
     */
    @Override
    public int updateFaceUser(FaceUser faceUser)
    {
        return faceUserMapper.updateFaceUser(faceUser);
    }

    /**
     * 批量删除用户人脸管理
     *
     * @param ids 需要删除的用户人脸管理主键
     * @return 结果
     */
    @Override
    public int deleteFaceUserByIds(Long[] ids)
    {
        return faceUserMapper.deleteFaceUserByIds(ids);
    }

    /**
     * 删除用户人脸管理信息
     *
     * @param id 用户人脸管理主键
     * @return 结果
     */
    @Override
    public int deleteFaceUserById(Long id)
    {
        return faceUserMapper.deleteFaceUserById(id);
    }
}
