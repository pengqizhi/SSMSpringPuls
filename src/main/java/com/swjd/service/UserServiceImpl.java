package com.swjd.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swjd.bean.User;
import com.swjd.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
