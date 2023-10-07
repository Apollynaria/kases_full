<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-info-circle-fill"></i>
                        &nbsp;Список страниц с полезной информацией
                        <router-link to="/addUsefulInformation" class="btn btn-secondary txt"><i class="bi bi-plus-lg"></i></router-link>
                    </span>
                    <br>
                    <div>
                        <ul class="list-group p-3">
                            <li class="list-group-item d-flex flex-row justify-content-between"
                                v-for="(information, index) in information_array" :key="index">
                                <div class="">
                                    <router-link class="link" :to="{
                                        name: 'admin-useful-information-details',
                                        params: { id: information.id }
                                    }">
                                    {{index+1 + ". " + information.name }}
                                    </router-link>
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
    name: "ListUsefulInformation",
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            information_array: [],
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
        getInformation() {
            http
                .get("/listInformation/page=" + this.page)
                .then(response => {
                    this.countPage = response.data.totalPages;
                    this.information_array = response.data.content;
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
        },
    },
    mounted() {
        this.getInformation();
    }
};
</script>
  
<style>


.page-link.disabled{
    color: rgb(186, 188, 190) !important;
}
.page-item-active {
    background-color: rgba(233, 236, 239) !important;
    /* text-decoration: underline !important; */
}

.pagination {
    --bs-pagination-focus-bg: #fff !important;
}

.pagination {
    --bs-pagination-focus-box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0) !important;
}


.page-link{
    color: #434343 !important;
}
.page-item{
    font-size: 12pt;
    font-weight: bold;
    font-family: Arial, Helvetica, sans-serif;
}

.link {
    text-decoration: none;
    /* color:rgb(1, 70, 123); */
    color: #434343;
    transition: 0.35s;
}


.btn {
    font-weight: bold;
}

.catalog-menu-headings {
    font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
}

.list-group-item {
    /* padding: 8px 15px 6px; */
    color: #434343 !important;
    font-size: 14pt;
}

.catalog-menu-headings {
    background: #fff;
    /* padding: 8px 15px 6px; */
    color: #434343 !important;
    font-size: 18pt;
    font-weight: bold;
}
</style>