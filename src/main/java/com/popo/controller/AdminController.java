package com.popo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.popo.service.BoardService;

@Controller
public class AdminController {

    @Autowired
    private BoardService boardService;

    // 관리자 페이지
    @GetMapping("/admin/adminPage")
    public void adminPage() {

    }
    
}