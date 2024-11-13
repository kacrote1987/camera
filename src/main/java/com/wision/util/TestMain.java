package com.wision.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestMain {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable consumerTask = () -> {
            // 此处调用Kafka消费函数
            KafkaConsumer.main(null);
        };

        // 每10秒执行一次
        scheduler.scheduleAtFixedRate(consumerTask, 0, 10, TimeUnit.SECONDS);
    }
}