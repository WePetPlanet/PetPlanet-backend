package top.zynorl.petplanet.common.third.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/12/26
 **/

@Configuration
@Slf4j
public class ThreadPoolConfiguration {
    @Bean("commonThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("biz-handler-threadPoolTaskExecutor");
        threadPoolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        threadPoolTaskExecutor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 4);
        threadPoolTaskExecutor.setKeepAliveSeconds(300);
        threadPoolTaskExecutor.setQueueCapacity(512);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setThreadFactory(new ThreadFactoryBuilder()
                .setUncaughtExceptionHandler((t, e) -> {
                    log.error("thread={} throw Exception={}", t, e.getMessage(), e);
                }).build());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
