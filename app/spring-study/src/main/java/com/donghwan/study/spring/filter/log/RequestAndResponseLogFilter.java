package com.donghwan.study.spring.filter.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j
@Component
public class RequestAndResponseLogFilter extends OncePerRequestFilter {

    private final String TAG = String.format("[%s]", this.getClass().getSimpleName());

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        WrapHttpServletRequest requestWrapper = new WrapHttpServletRequest(request);
        WrapHttpServletResponse responseWrapper = new WrapHttpServletResponse(response);

        String requestBodyString = requestWrapper.getBody(request.getCharacterEncoding());
        Object requestBody = objectMapper.readTree(requestBodyString).toPrettyString();
        log.info("{} Request Body : {}", TAG, requestBody);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String responseBodyString = responseWrapper.getBody(response.getCharacterEncoding());
        Object responseBody = objectMapper.readTree(responseBodyString).toPrettyString();
        log.info("{} Response Body : {}", TAG, responseBody);

        byte[] responseMessageBytes = responseBodyString.getBytes(response.getCharacterEncoding());
        int responseContentLength = responseMessageBytes.length;
        response.setContentLength(responseContentLength);
        response.getOutputStream().write(responseMessageBytes);
        response.flushBuffer();
    }
}
