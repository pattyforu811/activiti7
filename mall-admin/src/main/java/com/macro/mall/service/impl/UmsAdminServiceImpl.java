package com.macro.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.bo.UserDetailsImpl;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.entity.UmsPermission;
import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.security.util.JwtTokenUtil;
import com.macro.mall.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 后台用户表(UmsAdmin)表服务实现类
 *
 * @author patty
 * @since 2020-06-19 14:14:09
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

   private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Resource
    private UmsAdminMapper mapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsAdmin umsAdmin = getAdminByUsername(username);

        if (umsAdmin != null) {
            List<UmsPermission> list = getPermissionList(umsAdmin.getId());
          return  new UserDetailsImpl(umsAdmin, list);
        }


        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {

        UmsAdmin umsAdmin = new UmsAdmin();

        BeanUtil.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        //查询是否有相同用户名的用户
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", umsAdmin.getUsername());

        UmsAdmin admin = mapper.selectOne(wrapper);
        if (admin != null) {
            return null;
        }

        String encode = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encode);

        mapper.insert(umsAdmin);

        return umsAdmin;

    }

    @Override
    public String login(String username, String password) {

        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            Optional.ofNullable(userDetails).orElseThrow(() -> new BadCredentialsException("用户名不正确"));
//            Optional.ofNullable(userDetails).orElseGet(() -> userDetails);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
          //  org.activiti.engine.impl.identity.Authentication.setAuthenticatedUserId(username);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            //   insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());//BadCredentialsException
        }
        return token;

/*
        UmsAdmin umsAdmin = mapper.selectOne(new QueryWrapper<UmsAdmin>()
                .lambda()
                .eq(UmsAdmin::getUsername, username)
                .eq(UmsAdmin::getPassword, password));

        Optional.ofNullable(umsAdmin).ifPresent();
*/


    }

    private List<UmsPermission> getPermissionList(Long id) {
        return mapper.getPermissionList(id);
    }

    private UmsAdmin getAdminByUsername(String username) {
/*        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<UmsAdmin> list = mapper.selectList(queryWrapper);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;*/


        UmsAdmin umsAdmin = mapper.selectOne(new QueryWrapper<UmsAdmin>().lambda().eq(UmsAdmin::getUsername, username));
        return umsAdmin;
    }
}