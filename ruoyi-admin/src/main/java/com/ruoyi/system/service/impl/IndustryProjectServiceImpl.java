package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IndustryProjectMapper;
import com.ruoyi.system.domain.IndustryProject;
import com.ruoyi.system.service.IIndustryProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产业项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class IndustryProjectServiceImpl implements IIndustryProjectService 
{
    @Autowired
    private IndustryProjectMapper industryProjectMapper;

    /**
     * 查询产业项目
     * 
     * @param id 产业项目主键
     * @return 产业项目
     */
    @Override
    public IndustryProject selectIndustryProjectById(Long id)
    {
        return industryProjectMapper.selectIndustryProjectById(id);
    }

    /**
     * 查询产业项目列表
     * 
     * @param industryProject 产业项目
     * @return 产业项目
     */
    @Override
    public List<IndustryProject> selectIndustryProjectList(IndustryProject industryProject)
    {
        return industryProjectMapper.selectIndustryProjectList(industryProject);
    }

    /**
     * 新增产业项目
     * 
     * @param industryProject 产业项目
     * @return 结果
     */
    @Override
    public int insertIndustryProject(IndustryProject industryProject)
    {
        return industryProjectMapper.insertIndustryProject(industryProject);
    }

    /**
     * 修改产业项目
     * 
     * @param industryProject 产业项目
     * @return 结果
     */
    @Override
    public int updateIndustryProject(IndustryProject industryProject)
    {
        return industryProjectMapper.updateIndustryProject(industryProject);
    }

    /**
     * 批量删除产业项目
     * 
     * @param ids 需要删除的产业项目主键
     * @return 结果
     */
    @Override
    public int deleteIndustryProjectByIds(String ids)
    {
        return industryProjectMapper.deleteIndustryProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产业项目信息
     * 
     * @param id 产业项目主键
     * @return 结果
     */
    @Override
    public int deleteIndustryProjectById(Long id)
    {
        return industryProjectMapper.deleteIndustryProjectById(id);
    }
}
