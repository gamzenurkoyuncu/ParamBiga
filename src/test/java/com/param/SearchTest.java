package com.param;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static com.param.Constant.searchKeyword;
import static com.param.Constant.searchBarPlaceholder;

public class SearchTest extends BaseTest {

    @Test
    public void shouldSearchKeywordProperly() {
        HomePage homePage = new HomePage();
        AfterSearchPage resultPage = homePage.search(searchKeyword);
        assertEquals(getDriver().getCurrentUrl(), "https://www.trendyol.com/sr?q=bilgisayar&qt=bilgisayar&st=bilgisayar&os=1");
        assertTrue(resultPage.hasProducts());
    }

    @Test
    public void shouldSearchPlaceholderBeCorrect() {
        HomePage homePage = new HomePage();
        String SearchPlaceholder = homePage.getSearchBarPlaceholderText();
        assertEquals(SearchPlaceholder, searchBarPlaceholder);
    }
}
