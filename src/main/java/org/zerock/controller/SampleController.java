package org.zerock.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value = "/gettext", produces = "text/plain; charset=utf-8")
	public String getText() {
		log.info("MIME TYPE: " +MediaType.TEXT_PLAIN_VALUE);
		
		return "?ȳ??ϼ???";
	}
}
