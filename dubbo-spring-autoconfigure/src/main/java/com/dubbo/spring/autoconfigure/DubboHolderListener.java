package com.dubbo.spring.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Dubbo监听
 * @author <a href="mailto:leukony@yeah.net">leukony</a>
 * @version $Id: DubboHolderListener.java, v 0.1 2018年6月15日 下午2:42:45 leukony Exp $
 */
@SuppressWarnings("rawtypes")
public class DubboHolderListener implements ApplicationListener {

    private static final Logger LOGGER  = LoggerFactory.getLogger(DubboHolderListener.class);

    private static Thread       holdThread;
    private static Boolean      running = Boolean.FALSE;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationPreparedEvent) {
            if (running == Boolean.FALSE) {
                running = Boolean.TRUE;
            }

            if (holdThread == null) {
                holdThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (LOGGER.isTraceEnabled()) {
                            LOGGER.trace(Thread.currentThread().getName());
                        }
                        while (running && !Thread.currentThread().isInterrupted()) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }, "Dubbo-Holder");
                holdThread.setDaemon(false);
                holdThread.start();
            }
        }
        if (event instanceof ContextClosedEvent) {
            running = Boolean.FALSE;
            if (holdThread != null) {
                holdThread.interrupt();
                holdThread = null;
            }
        }
    }
}