package com.example.learn.base.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuofan on 2018-7-11.
 *
 */
@RestController
@Api(value = "demo", description = "demo description")
@RequestMapping("/${demo.api.prefix}/demo/")
public class DemoController {

	@ApiOperation(value = "demoFunction", tags = { "demo", "demoTag" })
    @PostMapping("demoFunc")
	public Integer demoFunc() {
		return 100;
	}


	@ApiOperation(value = "demoFunc1", tags = { "demo", "demoTag" })
	@PostMapping("demoFunc1")
	public String demoFunc1() {
		return "1222";
	}
}
