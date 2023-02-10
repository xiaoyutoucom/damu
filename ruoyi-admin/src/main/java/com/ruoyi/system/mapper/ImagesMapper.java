package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Images;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-13
 */
public interface ImagesMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Images selectImagesById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param images 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Images> selectImagesList(Images images);

    /**
     * 新增【请填写功能名称】
     * 
     * @param images 【请填写功能名称】
     * @return 结果
     */
    public int insertImages(Images images);

    /**
     * 修改【请填写功能名称】
     * 
     * @param images 【请填写功能名称】
     * @return 结果
     */
    public int updateImages(Images images);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteImagesById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImagesByIds(String[] ids);
}
