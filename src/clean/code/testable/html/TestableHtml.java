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
                includeSetups();
            }

            buffer.append(pageData.getContent());
            if (pageData.hasAttribute("Test")) {
                includeTearDowns();
            }

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private void includeTearDowns() throws Exception {
            includeIfInherited("teardown", "TearDown");
            if (includeSuiteSetup) {
                includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);
            }
        }

        private void includeSetups() throws Exception {
            if (includeSuiteSetup) {
                includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
            }
            includeIfInherited("setup", "SetUp");
        }

        private void includeIfInherited(String mode, String pageName) throws Exception {
            WikiPage page = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            if (page != null) {
                includePage(mode, page);
            }
        }

        private void includePage(String mode, WikiPage page) throws Exception {
            WikiPagePath pagePath = crawler.getFullPath(page);
            String pagePathName = PathParser.render(pagePath);
            buffer.append(String.format("!include -%s .%s\n", mode, pagePathName));
        }
    }
}
