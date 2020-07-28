package greenfarm.sun.config.shiro;


import greenfarm.sun.filter.JWTFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    /**
     * 配置Shiro的Web过滤器，拦截浏览器请求并交给SecurityManager处理
     * 先经过filter, JWTFilter若检测到请求头中存在token, 再用token进行login, 最后经Realm验证
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        Map<String, Filter> filterMap = new LinkedHashMap<String, Filter>();

        filterMap.put("jwt", new JWTFilter());

        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized/no_authorized");

        Map<String, String> filterRuleMap = new HashMap<String, String>();

        // 所有请求都通过jwt
        filterRuleMap.put("/**", "jwt");

        // 访问/unauthorized/不通过JWTFilter
        filterRuleMap.put("/unauthorized/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);

        return shiroFilterFactoryBean;

    }


    /**
     * 自定义身份认证类
     * 必须写这个类，并且加上 @Bean 注解，目的是注入 UserRealm，
     * 否则会影响 UserRealm类 中其他类的依赖注入
     * 血的教训！！！
     * @return
     */
    @Bean
    public UserRealm userRealm() {

        final UserRealm userRealm = new UserRealm();
        return userRealm;

    }


    /**
     * SecurityManager安全管理器：所有与安全有关的操作都会与SecurityManager交互；
     * 它管理着所有Subject；负责与其他组件进行交互. (类似于SpringMVC中的DispatcherServlet控制器）
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 将自定义的realm交给SecurityManager管理
        securityManager.setRealm(userRealm());

        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();

        sessionStorageEvaluator.setSessionStorageEnabled(false);

        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);

        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;

    }


    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();

        advisorAutoProxyCreator.setProxyTargetClass(true);

        return advisorAutoProxyCreator;

    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;

    }


    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {

        return new LifecycleBeanPostProcessor();

    }

}