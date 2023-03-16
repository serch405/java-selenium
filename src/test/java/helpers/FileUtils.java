package helpers;

import java.io.File;
import java.time.Instant;
import java.util.Optional;


public class FileUtils {
    public static File getFile(String name) {
        File[] files = Globals.DOWNLOAD_FOLDER.listFiles();
        Optional<Integer> opt = Optional.of(files.length);

        if (opt.equals(0)) return null;

        for (int i = 1; i < files.length; i++) {
            if (files[i].getName().equals(name)) return files[i];
        }
        return null;
    }

    public static boolean isFilePresented(String name) {
        File file = getFile(name);
        Optional<File> opt = Optional.ofNullable(file);

        if (opt.isPresent()) return true;
        return false;
    }

    public static void removeFile(String name) {
        File file = getFile(name);
        Optional<File> opt = Optional.ofNullable(file);

        if (opt.isPresent()) {
            file.delete();
        }
    }

    public static File getLatestModifiedFile() {
        File[] files = Globals.DOWNLOAD_FOLDER.listFiles();
        Optional<Integer> opt = Optional.of(files.length);

        if (opt.equals(0)) return null;
        File lastModifiedFile = files[0];

        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public static void waitUntilDownloadingIsFinished(int seconds) throws InterruptedException {
        Instant deadline = Instant.now().plusSeconds(seconds);
        Long fileSize = FileUtils.getLatestModifiedFile().length();

        while (Instant.now().isBefore(deadline)) {
            Thread.sleep(500);

            if (!fileSize.equals(FileUtils.getLatestModifiedFile().length())) {
                fileSize = FileUtils.getLatestModifiedFile().length();
                continue;
            }
            break;
        }
    }

}
