package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.Images;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.IndustryProject;
import com.ruoyi.system.service.IIndustryProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产业项目Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/project")
public class IndustryProjectController extends BaseController
{
    private String prefix = "system/project";

    @Autowired
    private IIndustryProjectService industryProjectService;


    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }
    /**
     *
     */
    @ApiOperation("获取列表")
    @GetMapping("/get")
    @ResponseBody
    public R<IndustryProject> getUser(long id)
    {
        return R.ok(industryProjectService.selectIndustryProjectById(id));
    }
    /**
     * 查询产业项目列表
     */
    //@RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IndustryProject industryProject)
    {
        startPage();
        List<IndustryProject> list = industryProjectService.selectIndustryProjectList(industryProject);
        return getDataTable(list);
    }

    /**
     * 导出产业项目列表
     */
    @RequiresPermissions("system:project:export")
    @Log(title = "产业项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IndustryProject industryProject)
    {
        List<IndustryProject> list = industryProjectService.selectIndustryProjectList(industryProject);
        ExcelUtil<IndustryProject> util = new ExcelUtil<IndustryProject>(IndustryProject.class);
        return util.exportExcel(list, "产业项目数据");
    }

    /**
     * 新增产业项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产业项目
     */
    @RequiresPermissions("system:project:add")
    @Log(title = "产业项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(IndustryProject industryProject)
    {
        return toAjax(industryProjectService.insertIndustryProject(industryProject));
    }

    /**
     * 修改产业项目
     */
    @RequiresPermissions("system:project:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        IndustryProject industryProject = industryProjectService.selectIndustryProjectById(id);
        mmap.put("industryProject", industryProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存产业项目
     */
    @RequiresPermissions("system:project:edit")
    @Log(title = "产业项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(IndustryProject industryProject)
    {
        return toAjax(industryProjectService.updateIndustryProject(industryProject));
    }

    /**
     * 删除产业项目
     */
    @RequiresPermissions("system:project:remove")
    @Log(title = "产业项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(industryProjectService.deleteIndustryProjectByIds(ids));
    }
}
