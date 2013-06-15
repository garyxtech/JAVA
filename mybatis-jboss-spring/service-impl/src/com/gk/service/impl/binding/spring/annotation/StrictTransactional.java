package com.gk.service.impl.binding.spring.annotation;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public @interface StrictTransactional {

}
