package com.fh.service.type;

import com.fh.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
        @Autowired
        private TypeMapper  typeMapper;

}
