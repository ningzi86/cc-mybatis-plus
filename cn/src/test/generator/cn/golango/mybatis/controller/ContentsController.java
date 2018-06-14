package cn.golango.mybatis.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import cn.golango.mybatis.service.ContentsService;
import com.example.boot.utils.Result;
import com.example.boot.utils.ResultUtil;
import cn.golango.mybatis.pojo.Contents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.*;

/**
 *   description : Contents 控制器
 *   ---------------------------------
 * 	 @author cc
 *   @since 2018-06-14
 */
@Controller
@Api(value = "/contents", description = "Contents 控制器")
@RequestMapping("/contents")
public class ContentsController {
    private final Logger logger = LoggerFactory.getLogger(ContentsController.class);

    @Autowired
    public ContentsService contentsService;

    /**
     * description : 添加Contents
     * ---------------------------------
     * author : cc
     * @since : Create in 2018-06-14
     */
    @PostMapping("/addContents" )
    @ApiOperation(value = "/addContents", notes = "添加Contents" )
    public Result addContents(@ApiParam(name = "Contents", value = "Contents 实体类" ) @RequestBody Contents param){
        Result result;
        try{
            if(contentsService.insert(param)) {
                result = ResultUtil.success(param);
            }else {
                result = ResultUtil.error("添加失败");
            }
        }catch(Exception e){
            result = ResultUtil.error();
            logger.error("异常信息:{}",e.getMessage());
        }
        return result;
    }

    /**
     * description : 通过id更新Contents
     * ---------------------------------
     * author : cc
     * @since : Create in 2018-06-14
     */
    @PostMapping("/updateContentsById")
    @ApiOperation(value = "/updateContentsById", notes="通过id更新Contents 注意：需要在参数中增加主键")
    public Result updateContentsById(@ApiParam(name = "Contents",value = "Contents 实体类") @RequestBody Contents param) {
        Result result;
        try{
            if(null != param.getId()){
                result = ResultUtil.success(contentsService.updateById(param));
            }else {
                result = ResultUtil.error("参数错误");
            }
        }catch (Exception e) {
            result = ResultUtil.error();
            logger.error("异常信息:{}",e.getMessage());
        }
        return result;
    }

    /**
     * description : 获取分页列表
     * ---------------------------------
     * author : cc
     * @since : Create in 2018-06-14
     */
    @PostMapping("/getContentsListToPage")
    @ApiOperation(value = "/getContentsListToPage", notes="获取分页列表")
    public Result getContentsList(@ApiParam(name = "Contents", value = "Contents 实体类") @RequestBody Contents param ,
                                @ApiParam(name = "size", value = "页大小",defaultValue = "10") @RequestParam(value="size", defaultValue="10", required = false) Integer size,
                                @ApiParam(name = "current", value = "页数",defaultValue = "1") @RequestParam(value="current", defaultValue="1", required = false) Integer current) {
            Result result;
            try {
                EntityWrapper<Contents> entityWrapper = new EntityWrapper<Contents>(param);
                Page<Contents> page=new Page<Contents>(current,size);
                contentsService.selectPage(page, entityWrapper);
                result = ResultUtil.success(page);
            }catch (Exception e){
                result = ResultUtil.error();
                logger.error("异常信息:{}",e.getMessage());
            }
            return result;
    }

    /**
     * description : 通过id获取Contents
     * ---------------------------------
     * author : cc
     * @since : Create in 2018-06-14
     */
    @GetMapping("/getContentsById")
    @ApiOperation(value = "/getContentsById", notes = "通过id获取Contents")
    public Result getContentsById(@ApiParam(name = "id", value = "ContentsID", required = true) @RequestParam("id") Long id) {
            Result result;
            try {
                result = ResultUtil.success(contentsService.selectById(id));
            }catch (Exception e) {
                result = ResultUtil.error();
                logger.error("异常信息:{}",e.getMessage());
            }
            return result;
    }

    /**
     * description : 通过id删除Contents
     * ---------------------------------
     * author : cc
     * @since : Create in 2018-06-14
     */
    @GetMapping("/deleteContentsById")
    @ApiOperation(value = "/deleteContentsById", notes = "通过id删除Contents")
    public Result deleteContentsById(@ApiParam(name = "id",value="ContentsID", required = true) @RequestParam("id") Long id) {
            Result result;
            try{
                result = ResultUtil.success(contentsService.deleteById(id));
            }catch (Exception e) {
                result = ResultUtil.error();
                logger.error("异常信息:{}",e.getMessage());
            }
            return result;
    }

}
