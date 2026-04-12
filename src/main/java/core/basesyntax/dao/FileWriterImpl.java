package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String resultingReport, String fileName) {
        try {
            Files.writeString(Path.of(fileName), resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Error while writing resulting report to " + fileName, e);
        }
    }
}
