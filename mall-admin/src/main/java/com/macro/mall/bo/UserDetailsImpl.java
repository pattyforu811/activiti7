package com.macro.mall.bo;

import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.entity.UmsPermission;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UmsAdmin umsAdmin;
    private final List<UmsPermission> list;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限/角色
        return list.stream()
//                .filter(umsPermission -> !umsPermission.getValue().isEmpty())
                .filter(umsPermission -> umsPermission.getValue()!=null)
                .map(umsPermission -> new SimpleGrantedAuthority(umsPermission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
