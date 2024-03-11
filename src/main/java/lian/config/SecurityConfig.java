package lian.config;

import lian.video.Video;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;//定义认证规则
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import lian.redis.*;
import lian.user.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("vip1")
                .antMatchers("/level2/**").hasAnyRole("vip2")
                .antMatchers("/level3/**").hasAnyRole("vip3");
        http.formLogin();
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 从连接池获取连接
            conn = JDBCUtils.getConnection();
            // 执行sql语句
            String sql = "select * from work4.video where videoId = ?";
            pstmt = conn.prepareStatement(sql);
            int paramUid=1;
            // 设定sql语句的参数
            pstmt.setInt(1, paramUid);
            // 返回结果集
            rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.password = rs.getString("password");
                user.id= rs.getInt("id");
                user.avatar_url= rs.getString("avatar_url");
                user.email = rs.getString("email");
                //        在内存中定义，也可以在jdbc中去拿....
            auth.inMemoryAuthentication()
                    .withUser(user.username).password(user.password).roles("vip2","vip3");
                return ;
            } else {
                System.out.printf("不太行没找到!\n");
                // 当查询结果不存在时，可以返回null，也可以考虑抛出一个自定义异常或返回一个默认值
                return;
            }

        } catch (Exception e) {
            // 更具体地捕获并处理SQL异常，而不是笼统地返回null
            throw new RuntimeException("Failed to get user by ID due to SQL Exception", e);
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
    }

}



