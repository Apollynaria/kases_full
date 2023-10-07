<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid h1-00 align-self-center zag-txt">ПОЛЕЗНАЯ ИНФОРМАЦИЯ</div>
                </div>
                <div class="me-3 mt-2 mb-4" v-if="information.length > 0">
                    <div class="row ms-3 justify-content-center">
                        <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 col-xxl-4 col-12 p-3"
                            v-for="(oneInformation, index) in information" :key="index">
                            <div class="card h-100 border">
                                <div class="card-body h-100 d-flex flex-column">
                                    <img v-if="oneInformation.files.length > 0"
                                        :src="`/api/getFile/${oneInformation.files[0]}`" class="card-img-top"
                                        alt="...">
                                    <img v-else src="../assets/defaultCatalog.png" class="card-img-top" alt="...">
                                    <h3 class="card-title color-red big-font mt-2">
                                        {{ oneInformation.name }}
                                        <hr class="border border-1 mt-2 border-danger opacity-100 mb-2 m-auto w-100">
                                    </h3>
                                    <p class="card-text-description">{{ oneInformation.description.slice(0, 150) }}...</p>
                                    <a class="btn btn-danger f-14 mt-auto card-btn"
                                        :href="'/usefulInformation/' + oneInformation.id">Читать далее</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="p-2" v-else>
                    <p class="f-16 text-center color-red">
                        В разработке.
                    </p>
                </div>

                <div class="text-center d-flex justify-content-center" v-if="this.countPage > 1">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination rounded">
                            <li class="page-item rounded">
                                <a class="page-link" :class="{ 'disabled': this.firstPage }" href="#" @click="toFirstPage()"
                                    aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item rounded">
                                <a class="page-link" :class="{ 'disabled': this.firstPage }" href="#" @click="prevPage()"
                                    aria-label="Previous">
                                    <span aria-hidden="true">&lsaquo;</span>
                                </a>
                            </li>
                            <li class="page-item" v-for="(num, index) in pages" :key="index">
                                <a :class="{ 'page-item-active': num === this.page + 1 }" class="page-link"
                                    @click="clickNumber(num)" href="#" aria-label="Next">
                                    <span aria-hidden="true">{{ num }}</span>
                                </a>
                            </li>
                            <li class="page-item rounded">
                                <a class="page-link" :class="{ 'disabled': this.lastPage }" href="#" @click="nextPage()"
                                    aria-label="Previous">
                                    <span aria-hidden="true">&rsaquo;</span>
                                </a>
                            </li>
                            <li class="page-item rounded">
                                <a class="page-link" :class="{ 'disabled': this.lastPage }" href="#" @click="toLastPage()"
                                    aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <contactUs />
        <footerBar />
    </div>
</template>
  
<script>

import Navbar from './Navbar';
import FooterBar from './Footer';
import ContactUs from './ContactUs';
import http from "../http-common";


export default {
    name: 'UsefulInformation',
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
        ContactUs: ContactUs,
    },
    data() {
        return {
            information: [],
            page: 0,
            firstPage: true,
            lastPage: false,
            countPage: 0,
            pages: []
        };
    },
    methods: {
        getInformation() {
            http
                .get("/listShowingInformation/page=" + this.page)
                .then(response => {
                    this.countPage = response.data.totalPages;
                    this.information = response.data.content;
                    if (this.pages.length == 0) {
                        if (this.countPage >= 5) {
                            this.pages = Array.from({ length: 5 }, (_, i) => i + 1);
                        } else {
                            this.pages = Array.from({ length: this.countPage }, (_, i) => i + 1);
                        }
                    }
                })
                .catch(e => {
                    console.log(e);
                    window.location.href = '/notFound';
                });
        },
        getResponseInfo() {
            this.getInformation();
            this.firstPage = Boolean(this.page == 0);
            this.lastPage = Boolean(this.page == this.countPage - 1);
            const startPage = Math.max(Math.min(this.page - 2, this.countPage - 4), 1);
            const endPage = Math.min(startPage + 4, this.countPage);
            this.pages = Array.from({ length: endPage - startPage + 1 }, (_, i) => startPage + i);
        },
        clickNumber(num) {
            this.page = num - 1;
            this.getResponseInfo();
        },
        prevPage() {
            this.page--;
            this.getResponseInfo();
        },
        nextPage() {
            this.page++;
            this.getResponseInfo();
        },
        toFirstPage() {
            this.page = 0;
            this.getResponseInfo();
        },
        toLastPage() {
            this.page = this.countPage - 1;
            this.getResponseInfo();
        }
    },
    mounted() {
        this.getInformation();
    }
}
</script>
  

<style scoped>

.page-link {
    font-weight: normal;
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