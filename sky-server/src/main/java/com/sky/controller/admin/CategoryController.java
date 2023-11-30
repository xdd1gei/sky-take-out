package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 新增分类
     *
     * @param categoryDTO
     * @return
     */
    @ApiOperation("新增分类")
    @PostMapping
    public Result newAdd(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类 {}", categoryDTO.getName());
        categoryService.newAdd(categoryDTO);
        return Result.success();
    }

    /**
     * 分页查询分类
     * @param categoryPageQueryDTO
     * @return
     */
    @ApiOperation("分页查询分类")
    @GetMapping("/page")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询");
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 启用禁用分类
     * @param status
     * @param id
     * @return
     */
    @ApiOperation("启用、禁用分类")
    @PostMapping("/status/{status}")
    public Result state(@PathVariable Integer status,Long id){
        log.info("设置分类状态");
        categoryService.state(status,id);
        return Result.success();
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @ApiOperation("删除分类")
    @DeleteMapping
    public Result delete(Long id){
        log.info("删除分类{}",id);
        categoryService.delete(id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @ApiOperation("修改分类")
    @PutMapping
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类");
        categoryService.update(categoryDTO);
        return Result.success();
    }
}
