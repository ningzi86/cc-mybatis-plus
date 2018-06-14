package cn.golango.mybatis.dao;

import cn.golango.mybatis.pojo.Contents;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 *   @description : Contents Mapper 接口
 *   ---------------------------------
 * 	 @author cc
 *   @since 2018-06-14
 */
@Repository
public interface ContentsMapper extends BaseMapper<Contents> {

}