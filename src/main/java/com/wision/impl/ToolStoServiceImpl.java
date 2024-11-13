package com.wision.impl;

import com.wision.service.ToolStoService;
import com.wision.util.KafkaConsumer;
import com.wision.util.MinioUtil;
//import com.wision.util.QRCodeGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ToolStoServiceImpl implements ToolStoService {
//    @Resource
//    QRCodeGenerator qrCodeGenerator;
//    @Resource
//    KafkaConsumer kafkaConsumer;

    @Override
    public void qrcode() {
//        qrCodeGenerator.simple();
    }

    @Override
    public void kafka() {
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        Runnable consumerTask = () -> {
//            // 此处调用Kafka消费函数
//            KafkaConsumer.main(null);
//        };
//        // 每10秒执行一次
//        scheduler.scheduleAtFixedRate(consumerTask, 0, 10, TimeUnit.SECONDS);
    }

}
