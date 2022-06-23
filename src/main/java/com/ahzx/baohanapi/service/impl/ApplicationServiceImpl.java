package com.ahzx.baohanapi.service.impl;

import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.mapper.ApplicationMapper;
import com.ahzx.baohanapi.service.ApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投保申请表 服务实现类
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}
