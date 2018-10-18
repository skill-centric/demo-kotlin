package com.skillcentric;

import java.io.File;
import java.util.List;

public interface FileContentProcessor {

    void processContents(File file, byte[] binaryContents, List<String> textContents);
}
