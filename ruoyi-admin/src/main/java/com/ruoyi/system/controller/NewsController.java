package com.ruoyi.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.IndustryResources;
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
import com.ruoyi.system.domain.News;
import com.ruoyi.system.service.INewsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻管理Controller
 * 
 * @author ruoyi
 * @date 2022-10-17
 */
@Controller
@RequestMapping("/system/news")
public class NewsController extends BaseController
{
    private String prefix = "system/news";

    @Autowired
    private INewsService newsService;
    /**
     *
     */
    @GetMapping("/get")
    @ResponseBody
    public R<News> getUser(long id)
    {
        return R.ok(newsService.selectNewsById(id));
    }
    //@RequiresPermissions("system:news:view")
    @GetMapping()
    public String news()
    {
        return prefix + "/news";
    }

    /**
     * 查询新闻管理列表
     */
    //@RequiresPermissions("system:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(News news)
    {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    /**
     * 导出新闻管理列表
     */
    //@RequiresPermissions("system:news:export")
    @Log(title = "新闻管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(News news)
    {
        List<News> list = newsService.selectNewsList(news);
        ExcelUtil<News> util = new ExcelUtil<News>(News.class);
        return util.exportExcel(list, "新闻管理数据");
    }

    /**
     * 新增新闻管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻管理
     */
    //@RequiresPermissions("system:news:add")
    @Log(title = "新闻管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(News news)
    {
        try {
            news.setDetail(java.net.URLDecoder.decode(news.getDetail(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改新闻管理
     */
    //@RequiresPermissions("system:news:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        News news = newsService.selectNewsById(id);
        mmap.put("news", news);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻管理
     */
    //@RequiresPermissions("system:news:edit")
    @Log(title = "新闻管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(News news)
    {
        try {
            news.setDetail(java.net.URLDecoder.decode(news.getDetail(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 删除新闻管理
     */
    //@RequiresPermissions("system:news:remove")
    @Log(title = "新闻管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newsService.deleteNewsByIds(ids));
    }
}
