<template>
    <div id="app" class="mt-0">
        <header id="header" class="fixed-top mt-0">
            <div
                class="container-fluid d-flex align-items-center justify-content-end justify-content-sm-end justify-content-md-end justify-content-lg-center">
                <nav id="navbar" class="navbar">
                    <ul>
                        <li class="dropdown">
                            <a class="nav-link" href="#" v-on:click="this.toggleNav = 1"><span>О КОМПАНИИ▹</span></a>
                            <ul id="dropMen1">
                                <li><a class="nav-link" href="/aboutCompany">ИНФОРМАЦИЯ О КОМПАНИИ</a></li>
                                <li><a class="nav-link" href="/usefulInformation">ПОЛЕЗНАЯ ИНФОРМАЦИЯ</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="nav-link" href="#" v-on:click="this.toggleNav = 2"><span>ПРОДУКЦИЯ▹</span> 
                            <!-- <i class="bi bi-chevron-down" style="font-size: 13pt;"></i> -->
                        </a>
                            <ul id="dropMen2">
                                <li><a class="nav-link" href="/products/all">ВСЯ ПРОДУКЦИЯ</a></li>
                                <li><a class="nav-link" href="/products/1">ХЛЕБА</a></li>
                                <li><a class="nav-link" href="/products/2">БАТОНЫ, СДОБА</a></li>
                                <li><a class="nav-link" href="/products/3">СЛОЙКИ, ПОНЧИКИ</a></li>
                                <li><a class="nav-link" href="/products/4">ВАФЛИ, ПЕЧЕНЬЕ</a></li>
                                <li><a class="nav-link" href="/products/5">ЗАМОРОЖЕННЫЕ ПОЛУФАБРИКАТЫ</a></li>
                            </ul>
                        </li>
                        <li><a class="nav-link" href="/news">НОВОСТИ</a></li>
                        <li class="dropdown">
                            <a class="nav-link" href="#" v-on:click="this.toggleNav = 3"><span>КОНТАКТЫ▹</span></a>
                            <ul id="dropMen3">
                                <li><a class="nav-link" href="/contacts">КОНТАКТЫ КОМПАНИИ</a></li>
                                <li><a class="nav-link" href="/stores">ФИРМЕННЫЕ МАГАЗИНЫ</a></li>
                            </ul>
                        </li>
                        <li><a class="nav-link" href="/china" style="font-weight: normal;">对于中国</a></li>
                        <li><a class="nav-link " href="/clients">СТАТЬ КЛИЕНТОМ</a></li>
                        <li><a class="nav-link" href="/vacancies">ВАКАНСИИ</a></li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle" @click="toggleMobileNav"
                        style="color: #a40431ff; font-size: 25pt;"></i>
                </nav>
            </div>
            <div id="container">
                <div id="logo_up" class="m-auto w-100 text-center border-bottom border-4 border-danger">
                    <a href="/"><img src="../assets/logo.svg" width="230" height="100" /></a>
                </div>
            </div>
        </header>
    </div>
</template>

<script>


export default {
    name: "NavBar",
    el: '#header',
    data() {
        return {
            toggleNav: 1
        }
    },
    methods: {
        select(el, all = false) {
            el = el.trim()
            if (all) {
                return [...document.querySelectorAll(el)]
            } else {
                return document.querySelector(el)
            }
        },
        on(type, el, listener, all = false) {
            let selectEl = this.select(el, all)
            if (selectEl) {
                if (all) {
                    selectEl.forEach(e => e.addEventListener(type, listener))
                } else {
                    selectEl.addEventListener(type, listener)
                }
            }
        },
        toggleMobileNav(e) {
            console.log(e)
        }
    },
    mounted() {
        this.on('click', '.mobile-nav-toggle', (e) => {
            this.select('#navbar').classList.toggle('navbar-mobile')

            var elem = document.getElementsByClassName(e.target.className)[0];
            elem.classList.toggle('bi-list')
            elem.classList.toggle('bi-x')
        })
        this.on('click', '.navbar .dropdown > a', () => {
            if (this.select('#navbar').classList.contains('navbar-mobile')) {
                var elem = document.getElementById("dropMen"+this.toggleNav);
                elem.classList.toggle('dropdown-active')
            }
        }, true)
    }
}
</script>

<style scoped>
@media screen and (max-width: 768px) {
    [data-aos-delay] {
        transition-delay: 0 !important;
    }
}

#header {
    transition: all 0.5s;
    z-index: 997;
    padding: 5pt 0;
    background-color: #fff;
    
}

#header.header-scrolled,
#header.header-inner-pages {
    background: rgba(0, 0, 0, 0.8);
}

#header .logo {
    font-size: 32pt;
    margin: 0;
    padding: 0;
    line-height: 1;
    font-weight: 700;
    letter-spacing: 2px;
    text-transform: uppercase;
}

#header .logo a {
    color: #fff;
}

#header .logo a span {
    color: #d7b369ff;
}

#header .logo img {
    max-height: 40pt;
}

/**
* Desktop Navigation 
*/
.navbar {
    padding: 0;
}

.navbar ul {
    margin: 0;
    padding: 0;
    display: flex;
    list-style: none;
    align-items: center;
}

.navbar li {
    position: relative;
}

.navbar a,
.navbar a:focus {
    font-family: 'Playfair Display';
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 3pt 0 0 30pt;
    font-size: 14pt;
    font-weight: 600;
    color: #a40431ff;
    white-space: nowrap;
    transition: 0.3s;
}

.navbar a i,
.navbar a:focus i {
    line-height: 0;
    margin-left: 5px;
}

.navbar a:hover,
.navbar .active,
.navbar .active:focus,
.navbar li:hover>a {
    color: #d7b369ff;
}

.navbar .dropdown ul {
    display: block;
    position: absolute;
    left: 14px;
    top: calc(100% + 30px);
    margin: 0;
    padding: 10px 0;
    z-index: 99;
    opacity: 0;
    visibility: hidden;
    background: #fff;
    box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.25);
    transition: 0.3s;
}

.navbar .dropdown ul li {
    min-width: 200px;
}

.navbar .dropdown ul a {
    /* font-family: Georgia, serif !important; */
    padding: 10px 20px;
    font-size: 12pt;
    font-weight: bold;
    text-transform: none;
    color: #a40431ff;
}

.navbar .dropdown ul a i {
    font-size: 15pt;
}

.navbar .dropdown ul a:hover,
.navbar .dropdown ul .active:hover,
.navbar .dropdown ul li:hover>a {
    background-color: #d7b369ff;
}

.navbar .dropdown:hover>ul {
    opacity: 1;
    top: 100%;
    visibility: visible;
}

.navbar .dropdown .dropdown ul {
    top: 0;
    left: calc(100% - 30px);
    visibility: hidden;
}

.navbar .dropdown .dropdown:hover>ul {
    opacity: 1;
    top: 0;
    left: 100%;
    visibility: visible;
}

@media (max-width: 1366px) {
    .navbar .dropdown .dropdown ul {
        left: -90%;
    }

    .navbar .dropdown .dropdown:hover>ul {
        left: -100%;
    }
}

/**
* Mobile Navigation 
*/
.mobile-nav-toggle {
    color: #fff;
    font-size: 28px;
    cursor: pointer;
    display: none;
    line-height: 0;
    transition: 0.5s;
}

@media (max-width: 991px) {
    .mobile-nav-toggle {
        display: block;
    }

    .navbar ul {
        display: none;
    }
}

.navbar-mobile {
    position: fixed;
    overflow: hidden;
    top: 0;
    right: 0;
    left: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 1);
    transition: 0.3s;
    z-index: 999;
}

.navbar-mobile .mobile-nav-toggle {
    position: absolute;
    top: 15px;
    right: 15px;
}

.navbar-mobile ul {
    display: block;
    position: absolute;
    top: 55px;
    right: 15px;
    bottom: 15px;
    left: 15px;
    padding: 10px 0;
    background-color: #fff;
    overflow-y: auto;
    transition: 0.3s;
}

.navbar-mobile a,
.navbar-mobile a:focus {
    padding: 10px 20px;
    color: #a40431ff;
}

.navbar-mobile a:hover,
.navbar-mobile .active,
.navbar-mobile li:hover>a {
    color: #a40431ff;
    background-color: #d7b369ff;
}

.navbar-mobile .getstarted,
.navbar-mobile .getstarted:focus {
    margin: 15px;
}

.navbar-mobile .dropdown ul {
    position: static;
    display: none;
    margin: 10px 20px;
    padding: 10px 0;
    z-index: 99;
    opacity: 1;
    visibility: visible;
    background: #fff;
    box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.25);
}

.navbar-mobile .dropdown ul li {
    min-width: 200px;
}

.navbar-mobile .dropdown ul a {
    padding: 10px 20px;
    color: #a40431ff;
}

.navbar-mobile .dropdown ul a i {
    font-size: 12px;
}

.navbar-mobile .dropdown ul a:hover,
.navbar-mobile .dropdown ul .active:hover,
.navbar-mobile .dropdown ul li:hover>a {
    background-color: #d7b369ff;
}

.navbar-mobile .dropdown>.dropdown-active {
    display: block;
}

#logo_up {
    position: fixed;
    display: block;
    z-index: 98;
    height: 56pt;
    background-color: #fff;
}
</style>