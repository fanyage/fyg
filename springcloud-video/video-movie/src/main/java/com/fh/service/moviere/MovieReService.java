package com.fh.service.moviere;

import com.fh.common.ServerResponse;

public interface MovieReService {
    ServerResponse queryListMovie();

    ServerResponse queryListType();

    ServerResponse queryListArea();

    ServerResponse initType(Integer typeId);

    ServerResponse initArea(Integer areaId);

    ServerResponse initNum(Integer movieId);
}