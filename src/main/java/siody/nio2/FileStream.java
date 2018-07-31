package siody.nio2;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FileStream {
    public static void main(String[] args) {
        Path sql = Paths.get("E://sqllot.sql");
        try (AsynchronousFileChannel sqlchannel = AsynchronousFileChannel.open(sql)) {
            ByteBuffer sqlbuffer = ByteBuffer.allocate(1000);
            Future<Integer> result = sqlchannel.read(sqlbuffer, 0);
            Thread.sleep(200);
            System.out.println(result.get() + " charactors have gotten.");
            sqlbuffer.clear();
            sqlchannel.read(sqlbuffer, 0, sqlbuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.printf("end method! Have got " + result + " chars.\n");
                    System.out.println(new String(Arrays.copyOfRange(sqlbuffer.array(), 0, result)));
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("failed method!");
                }
            });
            System.out.println("wait for rollback...");
            Thread.sleep(200);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
