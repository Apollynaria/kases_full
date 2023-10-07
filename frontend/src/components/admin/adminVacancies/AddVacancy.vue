<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-person-plus-fill"></i>
                        &nbsp;Добавление вакансии&nbsp;
                        <router-link to="/adminListVacancies" class="btn btn-secondary txt">ВЕРНУТЬСЯ К СПИСКУ
                            ВАКАНСИЙ</router-link>
                    </span>
                    <br>
                    <div class="p-3" v-if="!submitted">
                        <form @submit="addVacancy">
                            <div style="font-size: 12pt;">
                                <input class="form-check-input" type="checkbox" value="" v-model="checkVacancy">
                                &nbsp;Отображать на сайте
                            </div>
                            <div class="mt-2" style="font-size: 12pt;">Название вакансии</div>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Название"
                                v-model="vacancy.name" required>
                            <div class="mt-2" style="font-size: 12pt;">Описание вакансии</div>
                            <textarea class="form-control" name="description" id="description"
                                placeholder="Описание вакансии" rows="15" v-model="vacancy.description" required></textarea>
                            <div class="mt-2" style="font-size: 12pt;">Телефон для связи</div>
                            <input type="text" name="phone" class="form-control" id="phone" placeholder="Телефон"
                                v-model="vacancy.phone" required>
                                <input type="submit" class="btn btn-success mt-2" value="       ДОБАВИТЬ       ">
                        </form>
                    </div>
                    <div class="p-3" v-else>
                        Вы успешно добавили запись!<br>
                        <button v-on:click="newVacancy()" class="btn btn-success mt-2" value="ДОБАВИТЬ">ДОБАВИТЬ ВАКАНСИЮ</button>
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
    name: "AddVacancy",
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            checkVacancy: "",
            vacancy: {
                name: "",
                description: "",
                isShow: "",
                phone: ""
            },
            submitted: false
        };
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
        }
    },
    methods: {
        addVacancy(e) {
            e.preventDefault();
            if (this.checkVacancy === true) {
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
            http
                .post("/addVacancy", data)
                .then(response => {
                    this.vacancy.id = response.data.id;
                    console.log(data);
                })
                .catch(e => {
                    console.log(e);
                });
            this.submitted = true;
        },
        newVacancy() {
            this.submitted = false;
            this.vacancy = {
                name: "",
                description: ""
            };
        }
    },

};
</script>
  
<style scoped></style>