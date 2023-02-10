package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VideosMapper;
import com.ruoyi.system.domain.Videos;
import com.ruoyi.system.service.IVideosService;
import com.ruoyi.common.core.text.Convert;

/**
 * 视频管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-17
 */
@Service
public class VideosServiceImpl implements IVideosService 
{
    @Autowired
    private VideosMapper videosMapper;

    /**
     * 查询视频管理
     * 
     * @param id 视频管理主键
     * @return 视频管理
     */
    @Override
    public Videos selectVideosById(Long id)
    {
        return videosMapper.selectVideosById(id);
    }

    /**
     * 查询视频管理列表
     * 
     * @param videos 视频管理
     * @return 视频管理
     */
    @Override
    public List<Videos> selectVideosList(Videos videos)
    {
        return videosMapper.selectVideosList(videos);
    }

    /**
     * 新增视频管理
     * 
     * @param videos 视频管理
     * @return 结果
     */
    @Override
    public int insertVideos(Videos videos)
    {
        return videosMapper.insertVideos(videos);
    }

    /**
     * 修改视频管理
     * 
     * @param videos 视频管理
     * @return 结果
     */
    @Override
    public int updateVideos(Videos videos)
    {
        return videosMapper.updateVideos(videos);
    }

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的视频管理主键
     * @return 结果
     */
    @Override
    public int deleteVideosByIds(String ids)
    {
        return videosMapper.deleteVideosByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视频管理信息
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    @Override
    public int deleteVideosById(Long id)
    {
        return videosMapper.deleteVideosById(id);
    }
}
