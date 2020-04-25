package tga_algo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public final class WriteFile {

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    WriteFile(String path) {
        setPath(path);
    }

    public void writetoFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, true);
        File actual = new File(path);
        if (actual.length() == 0) {
            try (PrintWriter print_line = new PrintWriter(write)) {
                print_line.printf("%s", textLine);
            }
        } else {
            try (PrintWriter print_line = new PrintWriter(write)) {

                print_line.printf("%n" + "%s", textLine);
            }
        }
    }

}
