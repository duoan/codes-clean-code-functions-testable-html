package clean.code.testable.html;

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class TestableHtml {

    public String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        return new TestableHtmlMaker(pageData, includeSuiteSetup).invoke();
    }

    private class TestableHtmlMaker {
        private PageData pageData;
        private boolean includeSuiteSetup;
        private WikiPage wikiPage;
        private StringBuffer buffer;
        private PageCrawler crawler;

        public TestableHtmlMaker(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            this.wikiPage = pageData.getWikiPage();
            this.buffer = new StringBuffer();
            this.crawler = wikiPage.getPageCrawler();
        }

        public String invoke() throws Exception {
            if (pageData.hasAttribute("Test")) {
                if (includeSuiteSetup) {
                    WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
                    if (suiteSetup != null) {

                        WikiPagePath pagePath = crawler.getFullPath(suiteSetup);
                        String pagePathName = PathParser.render(pagePath);
                        buffer.append("!include -setup .").append(pagePathName).append("\n");
                    }
                }
                WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
                if (setup != null) {
                    WikiPagePath setupPath = crawler.getFullPath(setup);
                    String setupPathName = PathParser.render(setupPath);
                    buffer.append("!include -setup .").append(setupPathName).append("\n");
                }
            }

            buffer.append(pageData.getContent());
            if (pageData.hasAttribute("Test")) {
                WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
                if (teardown != null) {
                    WikiPagePath tearDownPath = crawler.getFullPath(teardown);
                    String tearDownPathName = PathParser.render(tearDownPath);
                    buffer.append("!include -teardown .").append(tearDownPathName).append("\n");
                }
                if (includeSuiteSetup) {
                    WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                    if (suiteTeardown != null) {
                        WikiPagePath pagePath = crawler.getFullPath(suiteTeardown);
                        String pagePathName = PathParser.render(pagePath);
                        buffer.append("!include -teardown .").append(pagePathName).append("\n");
                    }
                }
            }

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }
    }
}
