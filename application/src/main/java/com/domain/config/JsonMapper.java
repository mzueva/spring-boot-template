package com.domain.config;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonMapper extends ObjectMapper {
    private static final long serialVersionUID = -1414537788709027470L;

    /**
     * {@code String} specifies date format without offset used to serialize
     * or deserialize dates with Jackson
     */
    private static final String FMT_ISO_LOCAL_DATE = "yyyy-MM-dd";

    public JsonMapper() {
        // calls the default constructor
        super();

        // configures ISO8601 formatter for date without time zone
        // the used format is 'yyyy-MM-dd'
        super.setDateFormat(new SimpleDateFormat(FMT_ISO_LOCAL_DATE));

        // enforces to skip null and empty values in the serialized JSON output
        super.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        // enforces to skip null references in the serialized output of Map
        super.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        // enables serialization failures, when mapper encounters unknown properties names
        super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        // configures the format to prevent writing of the serialized output for java.util.Date
        // instances as timestamps. any date should be written in ISO format
        super.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}