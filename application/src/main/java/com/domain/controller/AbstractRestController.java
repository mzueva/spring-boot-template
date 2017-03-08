package com.domain.controller;

public class AbstractRestController {

    protected static final int BUF_SIZE = 2 * 1024;
    /**
     * Declares HTTP status OK code value, used to specify this code when REST API
     * is described, using Swagger-compliant annotations. It allows create nice
     * documentation automatically.
     */
    protected static final int HTTP_STATUS_OK = 200;

    /**
     * {@code String} specifies API responses description that explains meaning of different values
     * for $.status JSON path. It's required and used with swagger ApiResponses annotation.
     */
    protected static final String API_STATUS_DESCRIPTION =
            "It results in a response with HTTP status OK, but "
                    + "you should always check $.status, which can take several values:<br/>"
                    + "<b>OK</b> means call has been done without any problems;<br/>"
                    + "<b>ERROR</b> means call has been aborted due to errors (see $.message "
                    + "for details in this case).";

}
