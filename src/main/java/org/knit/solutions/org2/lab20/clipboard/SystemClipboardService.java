package org.knit.solutions.org2.lab20.clipboard;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

@Service
public class SystemClipboardService implements ClipboardService {
    @Override
    public void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
}