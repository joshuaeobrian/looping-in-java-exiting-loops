package com.theironyard;

import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MainTest extends TestifierTest{

    @Test
    public void testMainOutput() {
        /* arrange */

        /* act */
        Main.main(null);

        /* assert */
        String output = (String) outputWatcher.getPrinted().stream().map(Object::toString).collect(Collectors.joining(""));

        assertThat(output, equalTo("1 \n" +
                "2 2 \n" +
                "4 4 4 4 \n" +
                "5 5 \n" +
                "6 6 6 6 6 6 \n"));
    }

    @Test
    public void testMainHasNestedForLoops(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The main() method should contain nested for loops.",
                source, RegexMatcher.matches("^.*?ForStmt.*?BlockStmt.*?ForStmt.*?BlockStmt.*?\\/BlockStmt.*?\\/BlockStmt.*?$"));
    }

    @Test
    public void testMainHasContinueStatement(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The main() method should contain a continue statement.",
                source, RegexMatcher.matches("^.*?ContinueStmt.*?$"));
    }

    @Test
    public void testMainHasBreakStatement(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The main() method should contain a break statement.",
                source, RegexMatcher.matches("^.*?BreakStmt.*?$"));
    }
}