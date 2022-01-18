package guru.qa.hw6;

import guru.qa.hw6.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 69;

    private WebSteps steps = new WebSteps();

    @Test
    public void testGithub() {
        steps.openRepository();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldFindIssueWithNumber(ISSUE_NUMBER);
    }
}
