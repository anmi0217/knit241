package org.knit.solutions.task20.clipboard;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

@Service
public class SystemClipboardService implements ClipboardService {
    @Override
    public void copyToClipboard(String value) {
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new StringSelection(value), null);
    }
}
