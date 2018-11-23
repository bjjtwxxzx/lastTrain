package gov.bjjtw.lastTrain.CommonTools;

import java.io.InputStream;

/**
 * FastByteArrayInputStream{@link String}字节输入流类
 *
 * <p> 末班车可达技术应用的接口及框架
 * <a href="https://github.com/bjjtwxxzx/lastTrain">项目位置</a>
 * 更全面的项目 {@code String} 信息.
 *
 * <p> 当前类通过Java.io.InputStream{@link String}和{@link StringBuilder}类，
 * 实现字节输入流操作。
 *
 * @author wuxinran@bjjtw.gov.cn
 */
public class FastByteArrayInputStream extends InputStream {
    protected byte[] buf = null;
    protected int count = 0;
    protected int pos = 0;

    public FastByteArrayInputStream(byte[] buf, int count) {
        this.buf = buf;
        this.count = count;
    }

    public final int available() {
        return count - pos;
    }

    public final int read() {
        return (pos < count) ? (buf[pos++] & 0xff) : -1;
    }

    public final int read(byte[] b, int off, int len) {
        if (pos >= count)
            return -1;

        if ((pos + len) > count)
            len = (count - pos);

        System.arraycopy(buf, pos, b, off, len);
        pos += len;
        return len;
    }

    public final long skip(long n) {
        if ((pos + n) > count)
            n = count - pos;
        if (n < 0)
            return 0;
        pos += n;
        return n;
    }

}