package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

//스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면  UserDetails 타입의 오브젝트를
//  스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
@Getter     //BoardApiController에서 User 객체를 꺼내 쓰기위해 getter
public class PrincipalDetail implements UserDetails { // 타입을 UserDetails로 지정.
    private User user; // 객체를 품고잇는것. 콤포지션 ( extends는 상속. 품고잇는것은 컴포지션)

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지 않았는지 리턴한다. (true:만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겼는지 리턴 (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만려되었는지 리턴 (true: 만료가 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정활성화상태 리턴(true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정이 갖고있는 권한 목록을 리턴한다. (권한이 여러개 있을수 잇어써 루프를 돌려야 하는데 우리는 한개만)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>(); // 어레이리스트의 부모를 타고가다보면 collection이 있다. 따라서 어레이리스트는
        // 컬렉션타입
        collectors.add(() -> {
            return "ROLE_" + user.getRole();
        });
        return collectors;
    }

}
