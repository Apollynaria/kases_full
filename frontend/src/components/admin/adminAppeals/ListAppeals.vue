<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-question-circle-fill"></i>
                        &nbsp;Список новых обращений<br>
                        <div to="/addVacancy" v-on:click="updateAppeals()" class="btn btn-secondary ms-3 mt-2 me-2">ИЗМЕНИТЬ
                            СТАТУС ВЫБРАННЫХ НА: РЕШЕНО
                        </div>
                        <!-- <div type="submit" class="btn btn-danger mt-2" v-on:click="deleteAllAppeals()">УДАЛИТЬ ВСЕ</div> -->
                    </span>
                    <br>
                    <div>
                        <ul class="list-group p-3">
                            <li class="list-group-item d-flex flex-row justify-content-start"
                                v-for="(appeal, index) in appeals" :key="index">
                                <div class="">
                                    <input class="form-check-input me-2" v-model="selectedAppeals" type="checkbox"
                                        :value="appeal.id">
                                </div>
                                <div class="">
                                    <i class="bi bi-person-circle"></i> {{ appeal.name }}, <i
                                        class="bi bi-envelope-at-fill"></i> {{ appeal.email }}
                                    <hr>
                                    {{ appeal.message }}
                                </div>

                            </li>
                        </ul>
                    </div>
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
    </div>
    <div v-else>
        {{ $router.push('/') }}
    </div>
</template>
  
<script>
import AdminNavbar from '../AdminNavbar';
import http from "../../../http-common";

export default {
    name: "ListAppeals",
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            selectedAppeals: [],
            appeals: [],
            page: 0,
            firstPage: true,
            lastPage: false,
            countPage: 0,
            pages: []
        };
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
        }
    },
    methods: {
        getAppeals() {
            http
            .get("/listNotAnsweredAppeals/" + "page=" + this.page)
                .then(response => {
                    this.countPage = response.data.totalPages;
                    this.appeals = response.data.content;
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
                });
        },
        getResponseInfo() {
            this.getAppeals();
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
        },
        updateAppeals() {
            console.log(this.selectedAppeals);
            var data = JSON.parse(JSON.stringify(this.selectedAppeals));
            console.log(data);
            http
                .post("/updateAnsweredAppeals", data)
                .then(() => {
                    this.$router.go();
                })
                .catch(e => {
                    console.log(e);
                });
        }
    },
    mounted() {
        this.getAppeals();
    }
};
</script>
  
<style scoped>
</style>