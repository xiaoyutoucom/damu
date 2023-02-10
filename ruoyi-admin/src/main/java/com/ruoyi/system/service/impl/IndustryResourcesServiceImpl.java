package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IndustryResourcesMapper;
import com.ruoyi.system.domain.IndustryResources;
import com.ruoyi.system.service.IIndustryResourcesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产业资源Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class IndustryResourcesServiceImpl implements IIndustryResourcesService 
{
    @Autowired
    private IndustryResourcesMapper industryResourcesMapper;

    /**
     * 查询产业资源
     * 
     * @param id 产业资源主键
     * @return 产业资源
     */
    @Override
    public IndustryResources selectIndustryResourcesById(Long id)
    {
        return industryResourcesMapper.selectIndustryResourcesById(id);
    }

    /**
     * 查询产业资源列表
     * 
     * @param industryResources 产业资源
     * @return 产业资源
     */
    @Override
    public List<IndustryResources> selectIndustryResourcesList(IndustryResources industryResources)
    {
        return industryResourcesMapper.selectIndustryResourcesList(industryResources);
    }

    /**
     * 新增产业资源
     * 
     * @param industryResources 产业资源
     * @return 结果
     */
    @Override
    public int insertIndustryResources(IndustryResources industryResources)
    {
        return industryResourcesMapper.insertIndustryResources(industryResources);
    }

    /**
     * 修改产业资源
     * 
     * @param industryResources 产业资源
     * @return 结果
     */
    @Override
    public int updateIndustryResources(IndustryResources industryResources)
    {
        return industryResourcesMapper.updateIndustryResources(industryResources);
    }

    /**
     * 批量删除产业资源
     * 
     * @param ids 需要删除的产业资源主键
     * @return 结果
     */
    @Override
    public int deleteIndustryResourcesByIds(String ids)
    {
        return industryResourcesMapper.deleteIndustryResourcesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产业资源信息
     * 
     * @param id 产业资源主键
     * @return 结果
     */
    @Override
    public int deleteIndustryResourcesById(Long id)
    {
        return industryResourcesMapper.deleteIndustryResourcesById(id);
    }
}
