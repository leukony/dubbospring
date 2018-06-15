package com.dubbo.spring.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * Dubbo自动装备
 * @author <a href="mailto:leukony@yeah.net">leukony</a>
 * @version $Id: DubboAutoConfiguration.java, v 0.1 2018年6月15日 下午2:28:12 leukony Exp $
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {

    @Autowired
    private DubboProperties dubboProperties;

    @Primary
    @Bean
    public ApplicationConfig createApplicationConfig() {
        ApplicationConfig applicationConfig = dubboProperties.getApplication();
        if (applicationConfig == null) {
            applicationConfig = new ApplicationConfig();
        }
        return applicationConfig;
    }

    @Primary
    @Bean
    public RegistryConfig createRegistryConfig() {
        RegistryConfig registryConfig = dubboProperties.getRegistry();
        if (registryConfig == null) {
            registryConfig = new RegistryConfig();
        }
        return registryConfig;
    }

    @Primary
    @Bean
    public ProtocolConfig createProtocolConfig() {
        ProtocolConfig protocolConfig = dubboProperties.getProtocol();
        if (protocolConfig == null) {
            protocolConfig = new ProtocolConfig();
        }
        return protocolConfig;
    }

    @Primary
    @Bean
    public MonitorConfig createMonitorConfig() {
        MonitorConfig monitorConfig = dubboProperties.getMonitor();
        if (monitorConfig == null) {
            monitorConfig = new MonitorConfig();
        }
        return monitorConfig;
    }

    @Primary
    @Bean
    public ProviderConfig createProviderConfig() {
        ProviderConfig providerConfig = dubboProperties.getProvider();
        if (providerConfig == null) {
            providerConfig = new ProviderConfig();
        }
        return providerConfig;
    }

    @Primary
    @Bean
    public ConsumerConfig createConsumerConfig() {
        ConsumerConfig consumerConfig = dubboProperties.getConsumer();
        if (consumerConfig == null) {
            consumerConfig = new ConsumerConfig();
        }
        return consumerConfig;
    }

    @Primary
    @Bean
    public ModuleConfig createModuleConfig() {
        ModuleConfig moduleConfig = dubboProperties.getModule();
        if (moduleConfig == null) {
            moduleConfig = new ModuleConfig();
        }
        return moduleConfig;
    }

    @Primary
    @Bean
    public MethodConfig createMethodConfig() {
        MethodConfig methodConfig = dubboProperties.getMethod();
        if (methodConfig == null) {
            methodConfig = new MethodConfig();
        }
        return methodConfig;
    }
}