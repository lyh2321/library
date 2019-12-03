package com.louyh.m.controller;

import com.louyh.m.service.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("index.do")
    public String index() {

        return "";
    }
}
