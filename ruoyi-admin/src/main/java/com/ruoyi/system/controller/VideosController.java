package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.News;
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
import com.ruoyi.system.domain.Videos;
import com.ruoyi.system.service.IVideosService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频管理Controller
 * 
 * @author ruoyi
 * @date 2022-10-17
 */
@Controller
@RequestMapping("/system/videos")
public class VideosController extends BaseController
{
    private String prefix = "system/videos";

    @Autowired
    private IVideosService videosService;

    //@RequiresPermissions("system:videos:view")
    @GetMapping()
    public String videos()
    {
        return prefix + "/videos";
    }
    /**
     *
     */
    @GetMapping("/get")
    @ResponseBody
    public R<Videos> getUser( long id)
    {
        return R.ok(videosService.selectVideosById(id));
    }
    /**
     * 查询视频管理列表
     */
    //@RequiresPermissions("system:videos:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Videos videos)
    {
        startPage();
        List<Videos> list = videosService.selectVideosList(videos);
        return getDataTable(list);
    }

    /**
     * 导出视频管理列表
     */
    //@RequiresPermissions("system:videos:export")
    @Log(title = "视频管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Videos videos)
    {
        List<Videos> list = videosService.selectVideosList(videos);
        ExcelUtil<Videos> util = new ExcelUtil<Videos>(Videos.class);
        return util.exportExcel(list, "视频管理数据");
    }

    /**
     * 新增视频管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存视频管理
     */
    //@RequiresPermissions("system:videos:add")
    @Log(title = "视频管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Videos videos)
    {
        return toAjax(videosService.insertVideos(videos));
    }

    /**
     * 修改视频管理
     */
    //@RequiresPermissions("system:videos:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Videos videos = videosService.selectVideosById(id);
        mmap.put("videos", videos);
        return prefix + "/edit";
    }

    /**
     * 修改保存视频管理
     */
    //@RequiresPermissions("system:videos:edit")
    @Log(title = "视频管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Videos videos)
    {
        return toAjax(videosService.updateVideos(videos));
    }

    /**
     * 删除视频管理
     */
    //@RequiresPermissions("system:videos:remove")
    @Log(title = "视频管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(videosService.deleteVideosByIds(ids));
    }
}
