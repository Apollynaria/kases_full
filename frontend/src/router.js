import { createWebHistory, createRouter } from "vue-router";
// импорт компонентов
import HomePage from './components/Home';
import ContactPage from './components/Contacts';
import AboutCompany from './components/AboutCompany';
import BecomeClient from './components/BecomeClient';
import NewsPage from './components/News';
import VacancyPage from './components/Vacancy';
import ProductPage from './components/Product';
import OneNews from './components/OneNews';
import NotFound from './components/NotFound';
import InformationPage from './components/Information';
import ChinaPage from './components/China';
import UsefulInformation from './components/UsefulInformation';
import OneUsefulInformation from './components/OneUsefulInformation';
import StoresPage from './components/Stores';

import ListProducts from './components/admin/adminProducts/ListProducts';
import ListNews from './components/admin/adminNews/ListNews';
import ListAppeals from './components/admin/adminAppeals/ListAppeals';
import ListProductsByType from './components/admin/adminProducts/ListProductsByType';
import ArchiveAppeals from './components/admin/adminAppeals/ArchiveAppeals';
import ListVacancies from './components/admin/adminVacancies/ListVacancies';
import ListUsefulInformation from './components/admin/adminUsefulInformation/ListUsefulInformation';

import AddNews from './components/admin/adminNews/AddNews';
import AddProduct from './components/admin/adminProducts/AddProduct';
import AddVacancy from './components/admin/adminVacancies/AddVacancy';
import AddUsefulInformation from './components/admin/adminUsefulInformation/AddUsefulInformation';

import AdminNews from './components/admin/adminNews/AdminNews';
import LoginAdmin from './components/admin/login/Login';
import AdminVacancy from './components/admin/adminVacancies/AdminVacancy';
import AdminProduct from './components/admin/adminProducts/AdminProduct';
import AdminUsefulInformation from './components/admin/adminUsefulInformation/AdminUsefulInformation';

// определяем маршруты
const routes = [
    {
        path: "/",
        name: "Home",
        alias: "/home",
        component: HomePage,
        meta: {
            title: "ЗАО Иркутский Хлебозавод"
        }
    },
    {
        path: "/aboutCompany",
        name: "AboutCompany",
        component: AboutCompany,
        meta: {
            title: "О компании"
        }
    },

    {
        path: "/contacts",
        name: "Contacts",
        component: ContactPage,
        meta: {
            title: "Контакты"
        }
    },

    {
        path: "/clients",
        name: "BecomeClient",
        component: BecomeClient,
        meta: {
            title: "Стать клиентом"
        }
    },

    {
        path: "/information",
        name: "Information",
        component: InformationPage,
        meta: {
            title: "Информация"
        }
    },

    {
        path: "/china",
        name: "China",
        component: ChinaPage,
        meta: {
            title: "对于中国"
        }
    },

    {
        path: "/stores",
        name: "Stores",
        component: StoresPage,
        meta: {
            title: "Фирменные магазины"
        }
    },

    {
        path: "/news",
        name: "News",
        component: NewsPage,
        meta: {
            title: "Новости"
        }
    },

    {
        path: "/vacancies",
        name: "VacancyPage",
        component: VacancyPage,
        meta: {
            title: "Вакансии"
        }
    },

    {
        path: "/news/:id",
        name: "OneNews",
        component: OneNews,
        props: true,
        meta: {
            title: "Новость"
        }
    },

    {
        path: "/usefulInformation/:id",
        name: "OneUsefulInformation",
        component: OneUsefulInformation,
        props: true,
        meta: {
            title: "Полезная информация"
        }
    },

    {
        path: "/products/:typeNav",
        name: "ProductPage",
        component: ProductPage,
        props: true,
        meta: {
            title: "Продукция"
        }
    },

    {
        path: "/adminHome",
        name: "ListProducts",
        alias: "/adminListProducts",
        component: ListProducts,
        meta: {
            title: "Список продукции",
            requiredAuth: true
        }
    },
    {
        path: "/adminListProducts/:id",
        name: "ListProductsByType",
        component: ListProductsByType,
        props: true,
        meta: {
            title: "Список продукции",
            requiredAuth: true
        }
    },
    {
        path: "/addProduct",
        name: "AddProduct",
        component: AddProduct,
        meta: {
            title: "Создание продукции",
            requiredAuth: true
        }
    },
    {
        path: "/adminProduct/:id",
        name: "admin-product-details",
        component: AdminProduct,
        props: true,
        meta: {
            title: "Продукт",
            requiredAuth: true
        }
    },
    {
        path: "/adminListNews",
        name: "ListNews",
        component: ListNews,
        meta: {
            title: "Список новостей",
            requiredAuth: true
        }
    },
    {
        path: "/addNews",
        name: "AddNews",
        component: AddNews,
        meta: {
            title: "Создание новости",
            requiredAuth: true
        }
    },
    {
        path: "/adminNews/:id",
        name: "admin-news-details",
        component: AdminNews,
        props: true,
        meta: {
            title: "Новость",
            requiredAuth: true
        }
    },
    {
        path: "/adminListVacancies",
        name: "ListVacancies",
        component: ListVacancies,
        meta: {
            title: "Список вакансий",
            requiredAuth: true
        }
    },
    {
        path: "/addVacancy",
        name: "AddVacancy",
        component: AddVacancy,
        meta: {
            title: "Создание вакансии",
            requiredAuth: true
        }
    },
    {
        path: "/adminVacancy/:id",
        name: "admin-vacancy-details",
        component: AdminVacancy,
        props: true,
        meta: {
            title: "Вакансия",
            requiredAuth: true
        }
    },

    {
        path: "/login",
        name: "LoginAdmin",
        component: LoginAdmin,
        meta: {
            title: "Вход"
        }
    },
    {
        path: "/adminListAppeals",
        name: "ListAppeals",
        component: ListAppeals,
        meta: {
            title: "Список обращений",
            requiredAuth: true
        }
    },
    {
        path: "/adminListArchiveAppeals",
        name: "ArchiveAppeals",
        component: ArchiveAppeals,
        meta: {
            title: "Архив обращений",
            requiredAuth: true
        }
    },
    {
        path: "/adminListUsefulInformation",
        name: "ListUsefulInformation",
        component: ListUsefulInformation,
        meta: {
            title: "Список полезной информации",
            requiredAuth: true
        }
    },
    {
        path: "/addUsefulInformation",
        name: "AddUsefulInformation",
        component: AddUsefulInformation,
        meta: {
            title: "Создание страницы полезной информации",
            requiredAuth: true
        }
    },
    {
        path: "/adminUsefulInformation/:id",
        name: "admin-useful-information-details",
        component: AdminUsefulInformation,
        props: true,
        meta: {
            title: "Страница полезной информации",
            requiredAuth: true
        }
    },

    {
        path: "/usefulInformation",
        name: "UsefulInformation",
        component: UsefulInformation,
        meta: {
            title: "Полезная информация"
        }
    },

    

    {
        path: '/:CatchAll(.*)',
        component: NotFound
    }
];



const router = createRouter({
    history: createWebHistory(),
    routes,

    scrollBehavior() {
        return { x: 0, y: 0 }
    }
});

router.beforeEach(async (to, from, next) => {
    document.title = to.meta.title || 'Главная страница';
    next();
});

export default router;