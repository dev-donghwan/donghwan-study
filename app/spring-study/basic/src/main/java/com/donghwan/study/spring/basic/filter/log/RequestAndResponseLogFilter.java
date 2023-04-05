package com.donghwan.study.spring.basic.filter.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j
@Component
public class RequestAndResponseLogFilter extends OncePerRequestFilter {

    private final String TAG = String.format("[%s]", this.getClass().getSimpleName());

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        WrapHttpServletRequest req = new WrapHttpServletRequest(request);
        WrapHttpServletResponse res = new WrapHttpServletResponse(response);

        try {
            if (req.getContentType() != null && isVisible(MediaType.valueOf(req.getContentType()))) {
                try {
                    String reqCharterEncoding = req.getCharacterEncoding() == null ? StandardCharsets.UTF_8.name() : req.getCharacterEncoding();
                    String reqBodyString = new String(req.getContentAsByteArrays(), reqCharterEncoding);
                    String reqPrettyPrint = this.prettyPrint(reqBodyString);
                    log.info("{} Request Body : {}", TAG, reqPrettyPrint);
                } catch (Exception e) {
                    log.error("{} request exception {}", TAG, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        filterChain.doFilter(req, res);

        try {
            if (res.getContentType() != null && isVisible(MediaType.valueOf(res.getContentType()))) {
                try {
                    String resCharacterEncoding = res.getCharacterEncoding();
                    String resBodyString = new String(res.getContentAsByteArrays(), resCharacterEncoding);
                    String resPrettyPrint = this.prettyPrint(resBodyString);
                    log.info("{} Response Body : {}", TAG, resPrettyPrint);

                    byte[] responseMessageBytes = resBodyString.getBytes(resCharacterEncoding);
                    int responseContentLength = responseMessageBytes.length;
                    response.setContentLength(responseContentLength);
                    response.getOutputStream().write(responseMessageBytes);
                    response.flushBuffer();
                } catch (Exception e) {
                    log.error("{} response exception {}", TAG, e);
                }
            }
        } catch (Exception e) {

        }
    }

    private String prettyPrint(String jsonString) throws IOException {
        return objectMapper.readTree(jsonString).toPrettyString();
    }

    private static boolean isVisible(MediaType mediaType) {
        final List<MediaType> VISIBLE_TYPES = Arrays.asList(
            MediaType.valueOf("text/*"),
            MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.valueOf("application/*+json"),
            MediaType.valueOf("application/*+xml")
        );

        return VISIBLE_TYPES.stream()
            .anyMatch(visibleType -> visibleType.includes(mediaType));
    }
}
