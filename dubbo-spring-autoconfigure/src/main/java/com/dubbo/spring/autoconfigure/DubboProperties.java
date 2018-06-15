package com.dubbo.spring.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * Dubbo参数
 * @author <a href="mailto:leukony@yeah.net">leukony</a>
 * @version $Id: DubboProperties.java, v 0.1 2018年6月15日 下午2:25:34 leukony Exp $
 */
@ConfigurationProperties(prefix = DubboProperties.SPRING_DUBBO_PREFIX)
public class DubboProperties {

    public static final String SPRING_DUBBO_PREFIX = "spring.dubbo";

    /** 系统应用配置 */
    private ApplicationConfig  application;

    /** 注册中心配置 */
    private RegistryConfig     registry;

    /** 调用协议配置 */
    private ProtocolConfig     protocol;

    /** 监控配置 */
    private MonitorConfig      monitor;

    /** 服务提供方配置 */
    private ProviderConfig     provider;

    /** 服务消费方配置 */
    private ConsumerConfig     consumer;

    /** Dubbo接口扫描路径 */
    private String             scan;

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public ApplicationConfig getApplication() {
        return application;
    }

    public void setApplication(ApplicationConfig application) {
        this.application = application;
    }

    public RegistryConfig getRegistry() {
        return registry;
    }

    public void setRegistry(RegistryConfig registry) {
        this.registry = registry;
    }

    public ProtocolConfig getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolConfig protocol) {
        this.protocol = protocol;
    }

    public MonitorConfig getMonitor() {
        return monitor;
    }

    public void setMonitor(MonitorConfig monitor) {
        this.monitor = monitor;
    }

    public ProviderConfig getProvider() {
        return provider;
    }

    public void setProvider(ProviderConfig provider) {
        this.provider = provider;
    }
    
    public ConsumerConfig getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerConfig consumer) {
        this.consumer = consumer;
    }
}