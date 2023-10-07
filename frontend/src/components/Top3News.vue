<template>
    <div id="app">
        <div class="me-3 mb-4" v-if="news.length > 0">
            <div class="row ms-3 justify-content-center">
                <a class="text-center zagolovok-a" href="/news">НОВОСТИ</a>
                <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 col-xxl-3 col-12 p-3" v-for="(oneNews, index) in news"
                    :key="index">
                    <div class="card h-100 border">
                        <div class="card-body h-100 d-flex flex-column">
                            <p class="card-text text-center">
                                {{ oneNews.date.slice(8, 10) + `.` + oneNews.date.slice(5, 7) + `.` +
                                    oneNews.date.slice(0, 4) }}
                            </p>
                            <img v-if="oneNews.files.length > 0"
                                :src="`/api/getFile/${oneNews.files[0]}`" class="card-img-top"
                                alt="...">
                            <img v-else src="../assets/defaultCatalog.png" class="card-img-top" alt="...">
                            <h3 class="card-title color-red big-font mt-2">
                                {{ oneNews.name }}
                                <hr class="border border-1 mt-2 border-danger opacity-100 mb-2 m-auto w-100">
                            </h3>
                            <p class="card-text-description">{{ oneNews.description.slice(0, 150) }}...</p>
                            <a class="btn btn-danger f-14 mt-auto card-btn" :href="'/news/' + oneNews.id">Подробнее</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="p-2" v-else>
            <p class="f-16 text-center color-red">
                Актуальные новости отсутствуют.
            </p>
        </div>


    </div>
</template>
  
<script>
import http from "../http-common";

export default {
    name: 'Top3News',
    components: {
    },
    data() {
        return {
            news: [],
        };
    },
    methods: {
        getNews() {
            http
                .get("/listTop3ShowingNews")
                .then(response => {
                    this.news = response.data;
                    console.log(response.data);
                })
                .catch(e => {
                    console.log(e);
                });
        }
    },
    mounted() {
        this.getNews();
    }
}
</script>
  

<style scoped>
.zagolovok-a {
    text-decoration: none;
    font-family: 'Playfair Display' !important;
    font-weight: bold;
    color: #a40431ff;
    font-size: 24pt;
    transition: 0.5s;
}

.zagolovok-a:hover {
    color: #d7b369ff;
}

.selectedNav {
    background: #d7b369ff;
}

.card,
ul {
    box-shadow: 0 14px 28px rgba(60, 60, 60, 0.25), 0 10px 10px rgba(60, 60, 60, 0.25);
}

li {
    list-style-type: none;
    transition: 0.3s;
}

li:hover {
    background: #d7b369ff;
}

.nav-link {
    text-transform: uppercase;
    font-family: 'Playfair Display' !important;
    font-weight: bold;
    color: #a40431ff;
}

ul {
    background: #fff;
}

.card-img-top {
    height: 15em;
    object-fit: cover;
}

.card-btn {
    font-family: 'Playfair Display' !important;
}

.card-btn:active {
    background: #a40431ff;
}

.card-text {
    font-size: 14pt;
    /* color: #d7b369ff; */
    color: #a40431ff;
    font-weight: bold;
    font-family: Arial, Helvetica, sans-serif;
}

.card-text-description {
    font-size: 12pt;
    color: #000;
    /* font-weight: bold; */
    /* font-family: 'Playfair Display' !important; */
}

.card-title {
    font-size: 14pt;
}

.card {
    background: #fff;
    /* background: #f7f1eb; */
}

p {
    white-space: pre-line;
}

.zag {
    height: 200pt;
    font-size: 30pt;
    font-weight: bold;
    color: #fff;
    letter-spacing: 0.5pt;
    background-image: url("../assets/zag.jpg");
    background-size: cover;
}

.f-16 {
    font-family: 'Playfair Display';
    font-weight: bold;
}
</style>