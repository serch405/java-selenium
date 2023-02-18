package helpers;

import java.io.File;
import java.time.Instant;

public class DownloadFolder {
    public static File dir = new File(System.getProperty("user.home") + "/Downloads/");

    public static File getFile(String name) {
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            return null;
        }

        for (int i = 1; i < files.length; i++) {
            if (files[i].getName().equals(name)) {
                return files[i];
            }
        }
        return null;
    }

    public static boolean isFilePresented(String name) {
        File file = getFile(name);

        if (file != null) {
            return true;
        }
        return false;
    }

    public static void removeFile(String name) {
        File file = getFile(name);

        if (file != null) {
            file.delete();
        }
    }

    public static File getLatestModifiedFile() {
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            return null;
        }
        File lastModifiedFile = files[0];

        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public static void waitUntilDownloadingIsFinished(int seconds) throws InterruptedException {
        int maxTimeInSeconds = seconds;
        Instant deadline = Instant.now().plusSeconds(maxTimeInSeconds);
        Thread.sleep(500);
        Long fileSize1 = DownloadFolder.getLatestModifiedFile().length();
        Thread.sleep(500);
        Long fileSize2 = DownloadFolder.getLatestModifiedFile().length();

        while (Instant.now().isBefore(deadline)) {
            if (!fileSize1.equals(fileSize2)) {
                Thread.sleep(500);
                fileSize1 = fileSize2;
                fileSize2 = DownloadFolder.getLatestModifiedFile().length();
                continue;
            }

            Thread.sleep(3000); // extra delay is required for finalization of downloading
            break;
        }
    }

}
