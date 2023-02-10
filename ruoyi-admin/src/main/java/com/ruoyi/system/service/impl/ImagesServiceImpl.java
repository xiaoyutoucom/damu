package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ImagesMapper;
import com.ruoyi.system.domain.Images;
import com.ruoyi.system.service.IImagesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-13
 */
@Service
public class ImagesServiceImpl implements IImagesService 
{
    @Autowired
    private ImagesMapper imagesMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Images selectImagesById(Long id)
    {
        return imagesMapper.selectImagesById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param images 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Images> selectImagesList(Images images)
    {
        return imagesMapper.selectImagesList(images);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param images 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertImages(Images images)
    {
        return imagesMapper.insertImages(images);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param images 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateImages(Images images)
    {
        images.setModified(new Date());
        return imagesMapper.updateImages(images);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteImagesByIds(String ids)
    {
        return imagesMapper.deleteImagesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteImagesById(Long id)
    {
        return imagesMapper.deleteImagesById(id);
    }
}
