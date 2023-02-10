package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.IndustryResources;

/**
 * 产业资源Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface IndustryResourcesMapper 
{
    /**
     * 查询产业资源
     * 
     * @param id 产业资源主键
     * @return 产业资源
     */
    public IndustryResources selectIndustryResourcesById(Long id);

    /**
     * 查询产业资源列表
     * 
     * @param industryResources 产业资源
     * @return 产业资源集合
     */
    public List<IndustryResources> selectIndustryResourcesList(IndustryResources industryResources);

    /**
     * 新增产业资源
     * 
     * @param industryResources 产业资源
     * @return 结果
     */
    public int insertIndustryResources(IndustryResources industryResources);

    /**
     * 修改产业资源
     * 
     * @param industryResources 产业资源
     * @return 结果
     */
    public int updateIndustryResources(IndustryResources industryResources);

    /**
     * 删除产业资源
     * 
     * @param id 产业资源主键
     * @return 结果
     */
    public int deleteIndustryResourcesById(Long id);

    /**
     * 批量删除产业资源
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIndustryResourcesByIds(String[] ids);
}
