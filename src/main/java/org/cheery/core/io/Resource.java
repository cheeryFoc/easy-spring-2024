package org.cheery.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 主要用于处理资源加载流
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
