<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-clipboard-plus-fill"></i>
                        &nbsp;Вакансия: {{ this.vacancy.name }}&nbsp;
                        <router-link to="/adminListVacancies" class="btn btn-secondary">ВЕРНУТЬСЯ К СПИСКУ
                            ВАКАНСИЙ</router-link>
                    </span>
                    <br>
                    <div class="p-3">
                        <form>
                            <div class="mt-2" style="font-size: 12pt;">
                                <input class="form-check-input" type="checkbox" value="" v-model="checkVacancyOne">
                                &nbsp;Отображать на сайте
                            </div>
                            <div class="mt-2" style="font-size: 12pt;">Название вакансии</div>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Название"
                                v-model="vacancy.name" required>
                            <div class="mt-2" style="font-size: 12pt;">Описание вакансии</div>
                            <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Описание вакансии"
                                rows="15" v-model="vacancy.description" required></textarea>
                            <div class="mt-2" style="font-size: 12pt;">Телефон для связи</div>
                            <input type="text" name="phone" class="form-control" id="phone" placeholder="Телефон"
                                v-model="vacancy.phone" required>
                        </form>
                        <div class="d-flex justify-content-between">
                            <input type="submit" class="btn btn-primary mt-3 me-2" value="      ИЗМЕНИТЬ      "
                                v-on:click="updateVacancy()">
                            <input type="submit" class="btn btn-danger mt-3 " value="УДАЛИТЬ" v-on:click="deleteVacancy()">
                        </div>
                    </div>
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
    name: "admin-vacancy-details",
    props: ['id'],
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            checkVacancyOne: "",
            vacancy: {
                name: "",
                isShow: "",
                description: "",
                phone: ""
            },
        };
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
        }
    },
    methods: {
        getVacancy() {
            http
                .get("/vacancy/" + this.id)
                .then(response => {
                    this.vacancy = response.data;
                    this.checkVacancyOne = Boolean(this.vacancy.isShow);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        updateVacancy() {
            if (this.checkVacancyOne === true) {
                this.vacancy.isShow = 1;
            }
            else {
                this.vacancy.isShow = 0;
            }
            var data = {
                name: this.vacancy.name,
                isShow: this.vacancy.isShow,
                description: this.vacancy.description,
                phone: this.vacancy.phone
            };
            console.log(data);
            http
                .post("/updateVacancy/" + this.vacancy.id, data)
                .then(() => {
                    window.location.href = '/adminListVacancies';
                })
                .catch(e => {
                    console.log(e);
                });
            this.submitted = true;
        },
        deleteVacancy() {
            http
                .post("/deleteVacancy/" + this.vacancy.id)
                .then(() => {
                    window.location.href = '/adminListVacancies';
                })
                .catch(e => {
                    console.log(e);
                });
        },
    },

    mounted() {
        this.getVacancy();
    }
};
</script>
  
<style scoped>
textarea {
    resize: none;
}
</style>