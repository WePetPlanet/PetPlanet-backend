package top.zynorl.petplanet.post.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.transaction.PostPublishTransactionalService;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zynorl on 2024/1/11 12:57
 */
@Service
public class PostPublishScheduler {

    @Autowired
    private PostPublishTransactionalService postPublishTransactionalService;
    private ScheduledExecutorService scheduler;

    private void init() {
        // 初始化一个定长线程池
        scheduler = Executors.newScheduledThreadPool(3);
    }

    // 假设这是一个服务方法，接收前端传递的发布时间（LocalDateTime类型）
    public void schedulePublication(PublishPostReqBO publishPostReqBO) {
        init();
        // 计算从当前时间到目标发布时间的时间差
        LocalDateTime publishTime = Instant.ofEpochMilli(publishPostReqBO.getPublishTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        long delay = Duration.between(LocalDateTime.now(), publishTime).toMillis();

        // 如果延迟时间为负数，说明发布时间已过，则立即执行
        if (delay < 0) {
            postPublishTransactionalService.doProcess(publishPostReqBO);
        } else {
            // 使用ScheduledExecutorService安排任务
            scheduler.schedule(() -> postPublishTransactionalService.doProcess(publishPostReqBO), delay, TimeUnit.MILLISECONDS);
        }
        shutdown();
    }


    private void shutdown() {
        // 当不再需要定时任务时，确保关闭scheduler
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }

}
