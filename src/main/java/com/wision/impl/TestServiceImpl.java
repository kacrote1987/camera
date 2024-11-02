package com.wision.impl;

import com.wision.service.TestService;
import com.wision.util.QRCodeGenerator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
//    @Mapper
//    QRCodeGenerator qrCodeGenerator;

    @Override
    public void qrcode() {
//        qrCodeGenerator.simple();
    }
}
