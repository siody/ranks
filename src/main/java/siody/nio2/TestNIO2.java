package siody.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;

public class TestNIO2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        read(AsynchronousFileChannel.open(
                Paths.get("Test.Scala")),
                ByteBuffer.allocate(100),
                0,
                "start reading",
                (readCount, buffer, attachment) -> {
                    System.out.println(attachment);
                    System.out.println(new String(buffer.array(), 0, readCount));
                },
                (exc, attachment) -> {
                    System.out.println("Error:" + exc);
                });
        System.out.println("continue doing other things");
        Thread.sleep(1000);
    }

    static <A> void read(AsynchronousFileChannel channel, ByteBuffer buffer, long position, A attachment, final ReadSuccess<A> success, final ReadFailed<A> failure) {
        channel.read(buffer, 0, attachment, new CompletionHandler<Integer, A>() {
            @Override
            public void completed(Integer readCount, A attachment) {
                success.apply(readCount, buffer, attachment);
            }

            @Override
            public void failed(Throwable exc, A attachment) {
                failure.apply(exc, attachment);
            }
        });
    }
}

interface ReadSuccess<A> {
    void apply(Integer readCount, ByteBuffer buffer, A attachment);
}

interface ReadFailed<A> {
    void apply(Throwable exc, A attachment);
}