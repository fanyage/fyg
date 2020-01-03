package com.fh.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatId {
    public static String getCreatId(){
        SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmm");
        String format = sim.format(new Date());
        return format+ IdWorker.getId();
}


}

