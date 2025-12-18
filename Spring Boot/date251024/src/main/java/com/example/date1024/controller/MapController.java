package com.example.date1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MapController {

    @GetMapping("/map")
    @ResponseBody
    public Map<String , Object> getMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("이름", "감홍"); // .put : 추가, 수정할 때
        map.put("나이", "22");
        map.put("현재 시간", System.currentTimeMillis()); //현재 시간을 밀리초로 저장

        return map; //JSON으로 자동 변환
    }

}

/*
Map<k, v> -> 인터페이스
"키key"-"값value" 하나의 쌍으로 구성
 HashMap<> 입력된 순서대로 출력되지 않음 (list)와의 차이
 키는 중복 안됨
 */