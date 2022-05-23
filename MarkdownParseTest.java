import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void newFile2Test() throws IOException{
        String markdown = Files.readString(Path.of("new-file-2.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(markdown));
    }

    @Test
    public void newFile5Test() throws IOException{
        String markdown = Files.readString(Path.of("new-file-5.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(markdown));
    }

    @Test
    public void testMarkdownParseSnippet1() throws IOException {
        Path whichTest = Path.of("snippet1.md");
        String contents = Files.readString(whichTest);
        ArrayList<String> inputResult = MarkdownParse.getLinks(contents);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), inputResult);
    }

    @Test
    public void testMarkdownParseSnippet2() throws IOException{
        Path whichTest = Path.of("snippet2.md");
        String contents = Files.readString(whichTest);
        ArrayList<String> inputResult = MarkdownParse.getLinks(contents);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), inputResult);

    }
    @Test
    public void testMarkdownSnippet3() throws IOException{
        Path whichTest = Path.of("snippet3.md");
        String contents = Files.readString(whichTest);
        ArrayList<String> inputResult = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://www.twitter.com", "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/"), inputResult);

    }

}