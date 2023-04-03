package com.donghwan.study.spring.basic.filter.log;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WrapHttpServletResponse extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream cachedBytes;

    private CachedServletOutputStream cachedServletOutputStream = null;

    public WrapHttpServletResponse(HttpServletResponse response) {
        super(response);
        this.cachedBytes = new ByteArrayOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (cachedServletOutputStream == null) {
            cachedServletOutputStream = new CachedServletOutputStream(cachedBytes);
        }
        return cachedServletOutputStream;
    }

    public byte[] getContentAsByteArrays() {
        return cachedBytes.toByteArray();
    }

    private static class CachedServletOutputStream extends ServletOutputStream {

        private final DataOutputStream buffer;

        public CachedServletOutputStream(OutputStream outputStream) {
            this.buffer = new DataOutputStream(outputStream);
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setWriteListener(WriteListener listener) {

        }

        @Override
        public void write(int b) throws IOException {
            buffer.write(b);
        }
    }
}