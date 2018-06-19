package com.example.julianparker.popularmovie;

import java.util.List;

public class ReviewResults {

    /**
     * id : 343611
     * page : 1
     * results : [{"author":"TopKek","content":"I was a supporter of the first Jack Reacher film, having never developed a literary attachment to the eponymous hero and thus being perfectly happy to see him misinterpreted (apparently) by the diminutive Tom Cruise.\r\n\r\nBut this sequel, adapted from another of Lee Child's bestselling books, has the misfortune to bear a title which may provide its epitaph.\r\n\r\nReacher does come back, on a similar mission to last time: that is, to clear someone's name and run around (he does a lot of running) dodging those who would rather see him hand-cuffed and out of their ill-intentioned way.","id":"580f000d9251416c7d006717","url":"https://www.themoviedb.org/review/580f000d9251416c7d006717"},{"author":"Reno","content":"**...but he did go back and got into a trouble!**\r\n\r\nThe original source is a long book series, so they did not do it in order. Like the first film, which was based on the ninth book, this one was on the eighteenth. It was a stylishly made film. The actors were good, and their stunts were excellent. But not the storyline. This is a very familiar theme. You know, someone framed you and you go on to dig the truth while everyone trying to hunt you down. There are lots of close encounter, which give great thrilling entertainment. So, other than the story, everything looked fine.\r\n\r\nJack goes to meet one of his ex colleagues at his old headquarters. But soon he discovers she's behind the bars and now he's too for the crime they did not do. So escaping from the prison and looking for clues, who framed them and why, all one by one disclosed with some excellent running-chasing action sequences. The film almost as good as any timepass action film. But like it was the new wine in an old bottle. So it won't work for everyone, especially those with greater expectations.\r\n\r\nThe 55 year old Tom Cruise on the edge to become a veteran actor, but still he got that action hero macho in him. Probably another 3-4 films, including the upcoming 'Mission: Impossible' sequel. So this franchise could replace his cast with younger one in the future. Because another 20 books to go. Though, I'm thinking about the television series. Cobie too was awesome. The film justifies to its original, but not more than an above average. So good for once watching it.\r\n\r\n_6.5/10_","id":"59b1ea5bc3a368244303734c","url":"https://www.themoviedb.org/review/59b1ea5bc3a368244303734c"}]
     * total_pages : 1
     * total_results : 2
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * author : TopKek
         * content : I was a supporter of the first Jack Reacher film, having never developed a literary attachment to the eponymous hero and thus being perfectly happy to see him misinterpreted (apparently) by the diminutive Tom Cruise.

         But this sequel, adapted from another of Lee Child's bestselling books, has the misfortune to bear a title which may provide its epitaph.

         Reacher does come back, on a similar mission to last time: that is, to clear someone's name and run around (he does a lot of running) dodging those who would rather see him hand-cuffed and out of their ill-intentioned way.
         * id : 580f000d9251416c7d006717
         * url : https://www.themoviedb.org/review/580f000d9251416c7d006717
         */

        private String author;
        private String content;
        private String id;
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
