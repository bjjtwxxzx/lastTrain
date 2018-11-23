package gov.bjjtw.lastTrain.CommonTools;

import java.io.OutputStream;
import java.io.InputStream;

/**
 * FastByteArrayOutputStream{@link String}字节输出流类
 *
 * <p> 末班车可达技术应用的接口及框架
 * <a href="https://github.com/bjjtwxxzx/lastTrain">项目位置</a>
 * 更全面的项目 {@code String} 信息.
 *
 * <p> 当前类通过Java.io.OutputStream{@link String}和{@link StringBuilder}类，
 * 实现字节输入流操作。
 *
 * @author wuxinran@bjjtw.gov.cn
 */
public class FastByteArrayOutputStream extends OutputStream {
    protected byte[] buf = null;
    protected int size = 0;

    public FastByteArrayOutputStream() {
        this(5 * 1024);
    }

    public FastByteArrayOutputStream(int initSize) {
        this.size = 0;
        this.buf = new byte[initSize];
    }

    private void verifyBufferSize(int sz) {
        if (sz > buf.length) {
            byte[] old = buf;
            buf = new byte[Math.max(sz, 2 * buf.length )];
            System.arraycopy(old, 0, buf, 0, old.length);
            old = null;
        }
    }

    public int getSize() {
        return size;
    }

    public byte[] getByteArray() {
        return buf;
    }

    public final void write(byte b[]) {
        verifyBufferSize(size + b.length);
        System.arraycopy(b, 0, buf, size, b.length);
        size += b.length;
    }

    public final void write(byte b[], int off, int len) {
        verifyBufferSize(size + len);
        System.arraycopy(b, off, buf, size, len);
        size += len;
    }

    public final void write(int b) {
        verifyBufferSize(size + 1);
        buf[size++] = (byte) b;
    }

    public void reset() {
        size = 0;
    }

    public InputStream getInputStream() {
        return new FastByteArrayInputStream(buf, size);
    }

}