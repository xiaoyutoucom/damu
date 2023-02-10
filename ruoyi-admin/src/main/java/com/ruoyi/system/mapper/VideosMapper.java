package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Videos;

/**
 * 视频管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-17
 */
public interface VideosMapper 
{
    /**
     * 查询视频管理
     * 
     * @param id 视频管理主键
     * @return 视频管理
     */
    public Videos selectVideosById(Long id);

    /**
     * 查询视频管理列表
     * 
     * @param videos 视频管理
     * @return 视频管理集合
     */
    public List<Videos> selectVideosList(Videos videos);

    /**
     * 新增视频管理
     * 
     * @param videos 视频管理
     * @return 结果
     */
    public int insertVideos(Videos videos);

    /**
     * 修改视频管理
     * 
     * @param videos 视频管理
     * @return 结果
     */
    public int updateVideos(Videos videos);

    /**
     * 删除视频管理
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    public int deleteVideosById(Long id);

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVideosByIds(String[] ids);
}
