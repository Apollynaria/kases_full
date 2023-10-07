<template>
  <div class="d-flex flex-column sticky-top" style="height: 100vh; ">
    <div class="catalog-menu-headings position-relative">
      <span class="catmenu-name">Панель администратора</span>
    </div>
    <nav class="navbar-expand navbar-light catalog-navbar">
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto d-block">
          <li class="nav-item">
            <router-link to="/adminListProducts" class="nav-link"><i class="bi bi-basket2-fill"></i>&nbsp;&nbsp;Вся
              продукция</router-link>
          </li>
          <li class="nav-item" v-for="(type, index) in types" :key="index">
            <a class="nav-link" :href="`/adminListProducts/${type.id}`">
              <i class="bi bi-x-diamond-fill"></i>&nbsp;&nbsp;{{ type.name }}</a>
          </li>
          <li class="nav-item">
            <router-link to="/addProduct" class="nav-link"><i class="bi bi-plus-lg"></i>&nbsp;&nbsp;Добавить
              продукт</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/adminListNews" class="nav-link"><i
                class="bi bi-newspaper"></i>&nbsp;&nbsp;Новости</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/adminListUsefulInformation" class="nav-link"><i
                class="bi bi-info-circle-fill"></i>&nbsp;&nbsp;Полезная информ.</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/adminListVacancies" class="nav-link"><i
                class="bi bi-people-fill"></i>&nbsp;&nbsp;Вакансии</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/adminListAppeals" class="nav-link">
              <i class="bi bi-question-circle-fill"></i>&nbsp;&nbsp;Обращения</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/adminListArchiveAppeals" class="nav-link">
              <i class="bi bi-file-earmark-zip-fill"></i>&nbsp;&nbsp;Архив обращений</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/login" @click.prevent="logOut" class="nav-link"><i class="bi bi-box-arrow-right"></i>&nbsp;&nbsp;Выход</router-link>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
// listProductTypes
import http from "../../http-common";

export default {
  name: "AdminNavbar",
  data() {
    return {
      types: [],
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    getTypes() {
      http
        .get("/listProductTypes")
        .then(response => {
          this.types = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    logOut() {
      this.$store.dispatch('auth/logout'); // обращаемся к методу logout, который определён в auth.service.js
      window.location.href = '/login'; // // Используем такую конструкцию, а не this.$router.push, так как требуется перезагрузить страницу для обновления локального хранилища
    }
  },
  mounted() {
    this.getTypes();
  }
};
</script>

<style scoped>
.catalog-menu-headings {
  font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
  height: 100px;
}

.catalog-menu-headings {
  background: #434343;
  padding: 8px 15px 6px;
  color: #ffffff !important;
}

.catmenu-name {
  text-transform: uppercase;
  font-weight: 700;
  font-size: 14pt !important;
  /* line-height: 1.8; */
}

.catalog-navbar {
  font-family: 'Roboto Condensed', sans-serif;
  font-size: 1.1rem;
  padding: 0;
}

.catalog-navbar .navbar-brand {
  padding-top: 0.6rem;
  padding-bottom: 0.6rem;
  font-size: 1.2rem;
  text-transform: uppercase;
  font-weight: 700;
  font-family: 'Roboto', sans-serif;
  margin-left: 15px;
}

.catalog-navbar .navbar-brand:hover,
.catalog-navbar .navbar-brand:focus {
  color: #ffffff;
}

.catalog-navbar .navbar-collapse {
  padding: 0;
}

.catalog-navbar .navbar-toggler {
  font-size: 1.25rem;
  margin-right: 15px;
  color: #ffffff;
}

.catalog-navbar .navbar-nav .nav-item .nav-link {
  display: block;
  padding-left: 20px;
  padding-right: 20px;
  color: #434343;
  transition: .2s all ease-out;
  position: relative;
}

.catalog-navbar .navbar-nav .nav-item .nav-link:hover,
.catalog-navbar .navbar-nav .nav-item .nav-link:focus {
  background-color: #dbdbdb;
  color: #434343;
}

@media (min-width: 992px) {
  .catalog-navbar {
    background: #eeeeee;
    padding: 0;
    color: #434343;
  }

  .catalog-navbar .navbar-nav {
    width: 100%;
  }
}
</style>