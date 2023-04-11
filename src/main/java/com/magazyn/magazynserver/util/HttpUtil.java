package com.magazyn.magazynserver.util;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class HttpUtil {
    public static <T> ResponseEntity<List<T>> toResponse(List<T> list) {
        return ResponseEntity.ok(list);
    }
}
