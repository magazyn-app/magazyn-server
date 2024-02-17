package com.magazyn.magazynserver.util;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class HttpUtil {
    public static <T> ResponseEntity<List<T>> toResponse(List<T> list) {
        if (list == null || list.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }

    public static ResponseEntity<String> toResponse(String data, int statusCode) {
        return ResponseEntity.status(statusCode).body(data);
    }
}
