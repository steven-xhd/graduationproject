package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.UserMapper;
import com.example.waterpurifiermanagementsystem.pojo.User;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Result result;
    /*
     * 传值分页查询
     * 不传值不分页
     * */
    public Result findAll(Integer page,Integer rows){
        if(userMapper.findAll() != null && userMapper.findAll().size() > 0){

            if(page == null && rows == null){
                return result.message(200,"success",userMapper.findAll());
            }
           //若前台未传值，默认rows等于6
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<UserExample> userinfo = new PageInfo<>(userMapper.findAll());
            int totalpage = (int) userinfo.getTotal();
            return result.pageMessage(200,"success",totalpage,userinfo.getList());
        }
        return result.message(500,"fail");
    }
    //插入数据
    public Result insert(User record){
        if(userMapper.insertSelective(record) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    //删除数据
    @Transactional
    public Result delete(Integer[] ids){
        int i;
        if(ids == null){
            return result.message(500,"没有按照规定传值");
        }
        for (i=0;i<ids.length;i++){
            userMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
    //修改数据，可以修改全部，可以修改部分
    public Result update(User record){
        if(userMapper.updateByPrimaryKeySelective(record) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }


    /*
    * 登录
    * */
    public Result login(User user){
        if(userMapper.findByLogin(user) > 0){
            return result.message(200,"login success");
        }
        return result.message(500,"login fail");
    }
}
