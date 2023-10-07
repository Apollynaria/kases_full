import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'

import './assets/style.css'
import store from './store';

import './assets/vendor/bootstrap-icons/bootstrap-icons.css'

import router from './router' // Маршрутизация
/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

import DatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
import { fas } from "@fortawesome/free-solid-svg-icons";
import Vuelidate from 'vuelidate';
import VueEasyLightbox from 'vue-easy-lightbox'


/* add icons to the library */
library.add(faUserSecret)
library.add(fas)

function createMyApp() {

    const app = createApp(App, {

    }); // Создание экземпляра приложения со свойством types
    app.use(router); // Подключение маршрутизации
    app.use(store); 
    app.component('DatePicker', DatePicker);
    app.component('font-awesome-icon', FontAwesomeIcon);
    app.use(Vuelidate)
    app.use(VueEasyLightbox)
    app.mount('#app');
}

createMyApp(); // вызов функции для создания приложения и запуска его