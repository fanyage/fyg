package com.fh.service.area;

import com.fh.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
        @Autowired
        private AreaMapper areaMapper;



}
