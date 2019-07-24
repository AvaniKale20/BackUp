package com.bridgelabz.fundoo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.fundoo.model.Label;

@RequestMapping("/")
public class ExampleController {
	@GetMapping("/")
	String getLabel() {
		return "hello world";
	}
}
