package org.cheery.core.io;

import cn.hutool.core.lang.Assert;
import org.cheery.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过 ClassLoader 读取 ClassPath 下的文件信息，具体的读取过程主要是：classLoader.getResourceAsStream(path)
 */
public class ClassPathResource  implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
