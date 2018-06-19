package com.example.julianparker.popularmovie;

import java.util.List;

class TrailerResults {


    /**
     * adult : false
     * backdrop_path : /gBmrsugfWpiXRh13Vo3j0WW55qD.jpg
     * belongs_to_collection : {"id":328,"name":"Jurassic Park Collection","poster_path":"/qIm2nHXLpBBdMxi8dvfrnDkBUDh.jpg","backdrop_path":"/pJjIH9QN0OkHFV9eue6XfRVnPkr.jpg"}
     * budget : 170000000
     * genres : [{"id":28,"name":"Action"},{"id":12,"name":"Adventure"},{"id":878,"name":"Science Fiction"}]
     * homepage : http://www.jurassicworld.com/
     * id : 351286
     * imdb_id : tt4881806
     * original_language : en
     * original_title : Jurassic World: Fallen Kingdom
     * overview : A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.
     * popularity : 338.118848
     * poster_path : /c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg
     * production_companies : [{"id":56,"logo_path":"/cEaxANEisCqeEoRvODv2dO1I0iI.png","name":"Amblin Entertainment","origin_country":"US"},{"id":8111,"logo_path":null,"name":"Apaches Entertainment","origin_country":""},{"id":923,"logo_path":"/5UQsZrfbfG2dYJbx8DxfoTr2Bvu.png","name":"Legendary Entertainment","origin_country":"US"},{"id":103204,"logo_path":null,"name":"Perfect World Pictures","origin_country":"US"},{"id":33,"logo_path":"/8lvHyhjr8oUKOOy2dKXoALWKdp0.png","name":"Universal Pictures","origin_country":"US"}]
     * production_countries : [{"iso_3166_1":"US","name":"United States of America"}]
     * release_date : 2018-06-06
     * revenue : 370000000
     * runtime : 128
     * spoken_languages : [{"iso_639_1":"en","name":"English"}]
     * status : Released
     * tagline : The park is gone
     * title : Jurassic World: Fallen Kingdom
     * video : false
     * vote_average : 6.8
     * vote_count : 741
     * videos : {"results":[{"id":"5a254edec3a3680b9d0cf77f","iso_639_1":"en","iso_3166_1":"US","key":"70DUmBQytrc","name":"JURASSIC WORLD 2: Fallen Kingdom Teaser Trailer (2018)","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5a268f68c3a3680b960ec51a","iso_639_1":"en","iso_3166_1":"US","key":"7uwWLP9JVeQ","name":"JURASSIC WORLD 2: Fallen Kingdom Trailer Teaser 2 (2018)","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5a2905f0925141032c112f83","iso_639_1":"en","iso_3166_1":"US","key":"qEMjAf_Bf-g","name":"Jurassic World: Fallen Kingdom - Watch The Trailer Now! (Go Behind The Scenes) (HD)","site":"YouTube","size":720,"type":"Teaser"},{"id":"5a2ba7dec3a3680b9a146c87","iso_639_1":"en","iso_3166_1":"US","key":"vn9mMeWcgoM","name":"Jurassic World: Fallen Kingdom - Official Trailer [HD]","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5a77b35a0e0a265994009087","iso_639_1":"en","iso_3166_1":"US","key":"NooW_RbfdWI","name":"Jurassic World: Fallen Kingdom - Official Trailer #2 [HD]","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5ad83d7ec3a368718f00e11c","iso_639_1":"en","iso_3166_1":"US","key":"1FJD7jZqZEk","name":"Jurassic World: Fallen Kingdom - Final Trailer [HD]","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5ae44e38c3a368714f005d77","iso_639_1":"en","iso_3166_1":"US","key":"fLXqJhWUdCs","name":"Jurassic World: Fallen Kingdom| Movie Trailer | Release Date South Africa: 8 June 2018","site":"YouTube","size":1080,"type":"Trailer"}]}
     */

    private boolean adult;
    private String backdrop_path;
    private BelongsToCollectionBean belongs_to_collection;
    private int budget;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
    private VideosBean videos;
    private List<GenresBean> genres;
    private List<ProductionCompaniesBean> production_companies;
    private List<ProductionCountriesBean> production_countries;
    private List<SpokenLanguagesBean> spoken_languages;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public BelongsToCollectionBean getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(BelongsToCollectionBean belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public VideosBean getVideos() {
        return videos;
    }

    public void setVideos(VideosBean videos) {
        this.videos = videos;
    }

    public List<GenresBean> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresBean> genres) {
        this.genres = genres;
    }

    public List<ProductionCompaniesBean> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompaniesBean> production_companies) {
        this.production_companies = production_companies;
    }

    public List<ProductionCountriesBean> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<ProductionCountriesBean> production_countries) {
        this.production_countries = production_countries;
    }

    public List<SpokenLanguagesBean> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SpokenLanguagesBean> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public static class BelongsToCollectionBean {
        /**
         * id : 328
         * name : Jurassic Park Collection
         * poster_path : /qIm2nHXLpBBdMxi8dvfrnDkBUDh.jpg
         * backdrop_path : /pJjIH9QN0OkHFV9eue6XfRVnPkr.jpg
         */

        private int id;
        private String name;
        private String poster_path;
        private String backdrop_path;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }
    }

    public static class VideosBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 5a254edec3a3680b9d0cf77f
             * iso_639_1 : en
             * iso_3166_1 : US
             * key : 70DUmBQytrc
             * name : JURASSIC WORLD 2: Fallen Kingdom Teaser Trailer (2018)
             * site : YouTube
             * size : 1080
             * type : Teaser
             */

            private String id;
            private String iso_639_1;
            private String iso_3166_1;
            private String key;
            private String name;
            private String site;
            private int size;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIso_639_1() {
                return iso_639_1;
            }

            public void setIso_639_1(String iso_639_1) {
                this.iso_639_1 = iso_639_1;
            }

            public String getIso_3166_1() {
                return iso_3166_1;
            }

            public void setIso_3166_1(String iso_3166_1) {
                this.iso_3166_1 = iso_3166_1;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

    public static class GenresBean {
        /**
         * id : 28
         * name : Action
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ProductionCompaniesBean {
        /**
         * id : 56
         * logo_path : /cEaxANEisCqeEoRvODv2dO1I0iI.png
         * name : Amblin Entertainment
         * origin_country : US
         */

        private int id;
        private String logo_path;
        private String name;
        private String origin_country;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrigin_country() {
            return origin_country;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }
    }

    public static class ProductionCountriesBean {
        /**
         * iso_3166_1 : US
         * name : United States of America
         */

        private String iso_3166_1;
        private String name;

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class SpokenLanguagesBean {
        /**
         * iso_639_1 : en
         * name : English
         */

        private String iso_639_1;
        private String name;

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
