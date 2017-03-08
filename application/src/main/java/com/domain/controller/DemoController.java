package com.domain.controller;

import com.domain.common.MessageConstants;
import com.domain.common.MessageHelper;
import com.domain.entity.Version;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(value = "Demo", description = "Demo controller")
public class DemoController extends AbstractRestController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Version version;
    private final MessageHelper messageHelper;

    @Autowired
    public DemoController(Version version, MessageHelper messageHelper) {
        this.version = version;
        this.messageHelper = messageHelper;
    }

    @RequestMapping(value = "/demo", method= RequestMethod.GET)
    @ResponseBody
    @ApiOperation(
            value = "Demo method.",
            notes = "Demo method.",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(
            value = {@ApiResponse(code = HTTP_STATUS_OK, message = API_STATUS_DESCRIPTION)
            })
    public Result<Version> getVersion(@RequestParam(value="name") String name) {
        logger.info(messageHelper.getMessage(MessageConstants.INFO_REQUEST, "/demo"));
        version.setName(name);
        return Result.success(version);
    }
}
