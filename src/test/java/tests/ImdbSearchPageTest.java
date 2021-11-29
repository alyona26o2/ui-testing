package tests;

import pages.ImdbSearchPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Epic("Search Page")
public class ImdbSearchPageTest {

    private final ImdbSearchPage searchPage = new ImdbSearchPage();
    private String query = "Harry Potter";

    @Test
    @DisplayName("Should show search query in page header")
    public void searchQueryInPageHeaderTest() {
        searchPage.openImdb();
        searchPage.search(query);
        String header = searchPage.getHeader();
        assertTrue(header.contains(query));
    }

    @Test
    @DisplayName("Should show change search query in page header")
    public void changeHeaderTest() {
        searchPage.openImdb();
        searchPage.search(query);

        String headerBefore = searchPage.getHeader().toLowerCase();
        searchPage.clickExactMatches();
        String headerAfter = searchPage.getHeader().toLowerCase();
       assertNotEquals(headerBefore, headerAfter);

    }

    @Test
    @DisplayName("Should show number of results in page header")
    public void numberOfResultsInPageHeaderTest() {
        searchPage.openImdb();
        searchPage.search(query);
        List<String> titles = searchPage.getAllExactResults();
        String header = searchPage.getHeader().toLowerCase();
        String results = String.valueOf(titles.size());
        assertTrue(header.contains(results));

    }

    @Test
    @DisplayName("Each result should contain query")
    public void resultsMatchesQueryTest() {
        searchPage.openImdb();
        searchPage.search(query);
        List<String> titles = searchPage.getAllExactResults();
        for (String title : titles){
            assertTrue(title.contains(query));
        }
    }
}
