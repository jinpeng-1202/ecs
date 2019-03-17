package com.jin.bean;

import com.jin.model.TSysRole;
import com.jin.model.TSysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/15.
 */
public class SysUser implements UserDetails {

    private TSysUser sysUser;
    /**
     * 用户具有的角色列表
     */
    private List<TSysRole> roles;

    public SysUser(){}

    public SysUser(TSysUser sysUser, List<TSysRole> roles) {
        this.sysUser = sysUser;
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (TSysRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return sysUser.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return sysUser.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getEnabled();
    }

    public List<TSysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TSysRole> roles) {
        this.roles = roles;
    }

    public TSysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(TSysUser sysUser) {
        this.sysUser = sysUser;
    }
}
