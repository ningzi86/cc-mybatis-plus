package cn.golango.mybatis.controller;

import cn.golango.mybatis.pojo.Contents;
import cn.golango.mybatis.service.ContentsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description : Contents 控制器
 * ---------------------------------
 *
 * @author cc
 * @since 2018-06-14
 */
@Controller
@Api(value = "/contents", description = "")
@RequestMapping("/contents")
public class ContentsController {
    private final Logger logger = LoggerFactory.getLogger(ContentsController.class);

    @Autowired
    public ContentsService contentsService;


    @PostMapping("/save")
    public Contents addContents(@RequestBody Contents param) {
        contentsService.insert(param);
        return param;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        Model model) {

        PageHelper.startPage(page, 1);
        List<Contents> contents = contentsService.selectList(new EntityWrapper<Contents>());

        PageInfo<Contents> pageinfo = new PageInfo<>(contents);

        model.addAttribute("contents", contents);
        model.addAttribute("pageinfo", pageinfo);

        System.out.println(pageinfo);

        return "content/index";
    }

}
