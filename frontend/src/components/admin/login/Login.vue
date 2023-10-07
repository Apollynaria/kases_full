<template>
    <div class="container-fluid">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-sm-6 col-md-4 p-0">
                <div class="catalog-menu-headings position-relative text-center">
                    <span class="catmenu-name">Вход в систему</span>
                </div>
                <form @submit="handleLogin">
                    <input class="form-control mt-3" placeholder="Логин" name="login" type="text" v-model="user.login"
                        required />
                    <input class="form-control mt-3" placeholder="Пароль" type="password" name="password"
                        v-model="user.password" required />
                    <div class="d-flex justify-content-end">
                        <!-- <input type="submit" class="btn btn-secondary  mt-3 ml-3" value="ВОЙТИ"> -->
                        <button class="btn btn-secondary mt-3 ml-3" :disabled="loading">
                            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                            <span>Войти</span>
                        </button>
                    </div>
                    <div v-if="message" class="alert alert-danger mt-2" role="alert">{{ message }}</div>
                    <router-link to="/home" class="">На главную</router-link>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "LoginAdmin",
    components: {

    },
    data() {
        return {
            user: {
                login: "",
                password: ""
            },
            loading: false,
            message: ''
        };
    },
    computed: { // вычисляемые свойства
        loggedIn() {
            return this.$store.state.auth.status.loggedIn; // $store - локальное хранилище
            // return false;
        }
    },
    created() {
        if (this.loggedIn) {
            // Авторизация прошла успешно, переходим к главной странице.
            // Используем такую конструкцию, а не this.$router.push, так как требуется перезагрузить страницу для обновления локального хранилища
            window.location.href = '/adminListProducts';
        }
    },
    methods: {
        handleLogin(e) {
            console.log(this.user);
            this.loading = true;

            e.preventDefault();
            this.$store.dispatch("auth/login", this.user) // обращаемся к методу login, который определён в auth.service.js
                .then(() => {
                    window.location.href = '/adminListProducts';
                })
                .catch(e => {
                    this.message = e.response.data;
                    this.loading = false;
                }
                );
        }
    }
};
</script>

<style scoped>
.col-sm-6.col-md-4 {
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.6);
}


h3 {
    font-weight: bold;
}

.catalog-menu-headings {
    background: #434343;
    padding: 8px 15px 6px;
    color: #ffffff !important;
    font-size: 20pt;
}

.catmenu-name {
    text-transform: uppercase;
    font-weight: 700;
    /* font-size: 1.0rem; /
/ line-height: 1.8; */
}

.container-fluid {
    height: 100vh;
    font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
    color: #434343 !important;
}

form {
    background-color: #dbdbdb;
    padding: 2rem;
}

.form-control {
    margin-bottom: 1rem;
}

.btn-secondary {
    margin-left: 1rem;
}
</style>