<template>
  <div id="app" class="user_margin">
    <navbar />
    <div id="demo" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
      </div>

      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="../assets/home1.jpg" class="d-block w-100">
        </div>
        <div class="carousel-item">
          <img src="../assets/home2.jpg" class="d-block w-100">
        </div>
        <div class="carousel-item">
          <img src="../assets/home3.jpg" class="d-block w-100">
        </div>
      </div>

      <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
      </button>
    </div>

    <div class="p-4 secondBlock container-fluid d-flex row justify-content-between mx-auto">
      <div class="text-center p-2 big-font">
        <a class="catalogs m-auto" href="/products/all">КАТАЛОГИ&nbsp;&nbsp;ПРОДУКЦИИ</a>
      </div>

      <div
        class="d-flex justify-content-center flex-column flex-sm-column flex-md-column flex-lg-column flex-xl-row mt-3">

        <div class="d-flex justify-content-center flex-column flex-sm-column flex-md-row flex-lg-row flex-xl-row">
          <div class="card mb-3 ms-3 me-3 d-flex ">
            <div class="figure">
              <a href="/products/1">
                <img src="../assets/catalog1.jpg"
                  class="card-img-top mt-0 rounded-0" alt="...">
                </a>
            </div>
            <div class="card-body  p-0 mt-1">
              <p class="card-title m-0">&nbsp;</p>
              <div class="d-flex col justify-content-between">
                <p class="card-title h-100"><a class="nav-link big-font" href="/products/1">ХЛЕБА</a></p>
                <span class="align-self-center span-catalog"></span>
              </div>
            </div>
          </div>

          <div class="card mb-3 ms-3 me-3">
            <div class="figure">
              <a href="/products/2">
                <img src="../assets/catalog2.jpg"
                  class="card-img-top mt-0 rounded-0" alt="...">
                </a>
            </div>
            <div class="card-body p-0 mt-1">
              <p class="card-title m-0" href="/news"><a class="nav-link big-font" href="/products/2">БАТОНЫ</a></p>
              <div class="d-flex col justify-content-between">
                <p class="card-title "><a class="nav-link big-font" href="/products/2">СДОБА</a></p>
                <span class="align-self-center span-catalog"></span>
              </div>
            </div>
          </div>

          <div class="card mb-3 ms-3 me-3">
            <div class="figure">
              <a href="/products/3">
                <img src="../assets/catalog3.jpg"
                  class="card-img-top mt-0 rounded-0" alt="...">
                </a>
            </div>
            <div class="card-body p-0 mt-1">
              <p class="card-title m-0"><a class="nav-link big-font" href="/products/3">ТОРТЫ</a></p>
              <div class="d-flex col justify-content-between mt-0">
                <p class="card-title "><a class="nav-link big-font" href="/products/3">ПИРОЖНЫЕ</a></p>
                <span class="align-self-center span-catalog"></span>
              </div>
            </div>
          </div>
        </div>

        <div class="d-flex justify-content-center flex-column flex-sm-column flex-md-row flex-lg-row flex-xl-row">

          <div class="card mb-3 ms-3 me-3 d-flex ">
            <div class="figure">
              <a href="/products/4">
                <img src="../assets/catalog4.jpg"
                  class="card-img-top mt-0 rounded-0" alt="...">
                </a>
            </div>
            <div class="card-body  p-0 mt-1">
              <p class="card-title m-0"><a class="nav-link big-font" href="/products/4">ВАФЛИ</a></p>
              <div class="d-flex col justify-content-between">
                <p class="card-title "><a class="nav-link big-font" href="/products/4">ПЕЧЕНЬЕ</a></p>
                <span class="align-self-center span-catalog"></span>
              </div>
            </div>
          </div>

          <div class="card mb-3 ms-3 me-3">
            <div class="figure">
              <a href="/products/5">
                <img src="../assets/catalog5.jpg"
                  class="card-img-top mt-0 rounded-0" alt="...">
                </a>
            </div>
            <div class="card-body  p-0 mt-1">
              <p class="card-title m-0"><a class="nav-link big-font" href="/products/5">СЛОЙКИ</a></p>
              <div class="d-flex col justify-content-between">
                <p class="card-title "><a class="nav-link big-font" href="/products/5">ПОНЧИКИ</a></p>
                <span class="align-self-center span-catalog"></span>
              </div>
            </div>
          </div>

          <div class="card mb-3 ms-3 me-3">
            <div class="figure scale">
              <a href="/products/6">
                <img src="../assets/catalog6.jpg"
                  class="card-img-top mt-0 rounded-0" alt="...">
                </a>
            </div>
            <div class="card-body  p-0 mt-1">
              <p class="card-title m-0"><a class="nav-link big-font" href="/products/6">ЗАМОРОЖЕННЫЕ</a></p>
              <div class="d-flex col justify-content-between">
                <p class="card-title"><a class="nav-link big-font" href="/products/6">ПОЛУФАБРИКАТЫ</a></p>
                <span class="align-self-center span-catalog"></span>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="container-fluid d-flex flex-column">
      <div class="d-flex flex-column justify-content-center text-center">
        <p class="mt-3 color_black text-center f-16">Сегодня ЗАО "Иркутский хлебозавод" — <br>
          это предприятие с современной инфраструктурой, менеджментом и оборудованием
        </p>
      </div>
      <div
        class="d-flex flex-column flex-sm-column flex-md-column flex-lg-row flex-xl-row justify-content-center text-center f-16">
        <div class="p-3 m-2 block_center align-self-center rounded">
          <font-awesome-icon icon="fa-solid fa-building-wheat" size="2xl" class="color-yellow" />
          <hr class="border border-1 border-warning opacity-100 mt-3 mb-1 m-auto">
          <span class="d-flex h-100 justify-content-center f-14">
            3<br>завода в<br>г.Иркутске
          </span>
        </div>
        <div class="p-3 m-2 block_center align-self-center rounded">
          <font-awesome-icon icon="fa-solid fa-bread-slice" size="2xl" class="color-yellow" />
          <hr class="border border-1 border-warning opacity-100 mt-3 mb-1 m-auto">
          <span class="d-flex h-100 justify-content-center f-14">
            3<br>пекарни<br><br>
          </span>
        </div>
        <div class="p-3 m-2 block_center align-self-center rounded">
          <font-awesome-icon icon="fa-solid fa-store" size="2xl" class="color-yellow" />
          <hr class="border border-1 border-warning opacity-100 mt-3 mb-1 m-auto">
          <span class="d-flex h-100 justify-content-center f-14">
            Сеть<br>мелкооптовых<br>филиалов
          </span>
        </div>
        <div class="p-3 m-2 block_center align-self-center rounded">
          <font-awesome-icon icon="fa-solid fa-car" size="2xl" class="color-yellow" />
          <hr class="border border-1 border-warning opacity-100 mt-3 mb-1 m-auto">
          <span class="d-flex h-100 justify-content-center f-14">
            Собственное<br>автохозяйство<br><br>
          </span>
        </div>
      </div>


      <div class="text-center">
        <p class="mt-2 text-center f-16">Более 400 наименований<br>хлебобулочных, кондитерских и сухаро-бараночных изделий
        </p>
      </div>

      <div class="mb-4 mt-4 d-flex row video align-self-center w-mine">
        <iframe width="auto" height="auto" src="https://www.youtube.com/embed/iFzTU1pY2ls" title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
          allowfullscreen></iframe>
      </div>
    </div>

    <div class="container-fluid d-flex flex-column flex-md-row flex-lg-row flex-xl-row" style="width: 95%;">
      <div class="d-flex flex-column ">
        <div class="d-flex flex-row" style="height: 25%;">
          <font-awesome-icon class="p-3" icon="fa-solid fa-building-wheat" size="2xl" style="color: #d9b369;" />
          <p class="p-3">Наше предприятие основано в январе 1936 г.</p>
        </div>

        <div class="d-flex flex-row" style="height: 35%;">
          <font-awesome-icon class="p-3 w-10" icon="fa-solid fa-file-contract" size="2xl" style="color: #d9b369;" />
          <p class="p-3" style="margin-left: 12pt;">На предприятии внедрена система менеджмента безопасности пищевой
            продукции по стандарту ГОСТ Р ИСО 22000-2019 (ISO 22000:2018).</p>
        </div>

        <div class="d-flex flex-row" style="height: 40%;">
          <font-awesome-icon class="p-3" icon="fa-solid fa-award" size="2xl" style="color: #d9b369;" />
          <p class="p-3" style="margin-left: 12pt;">Наша продукция отмечена наградами за высокие потребительские качества,
            отвечающие всем требованиям современного рынка.</p>
        </div>
      </div>

      <div class="d-flex flex-column ">
        <div class="d-flex flex-row" style="height: 25%;">
          <font-awesome-icon class="p-3" icon="fa-solid fa-briefcase" size="2xl" style="color: #d9b369;" />
          <p class="p-3 text-justify" style="margin-left: 6pt;">На рабочих местах завершена специальная оценка условий
            труда (СОУТ). </p>
        </div>

        <div class="d-flex flex-row" style="height: 35%;">
          <font-awesome-icon class="p-3" icon="fa-solid fa-handshake" size="2xl" style="color: #d9b369;" />
          <p class="p-3 text-justify">Продукция поставляется во все регионы России, а также в Китай и Монголию.</p>
        </div>

        <div class="d-flex flex-row" style="height: 40%;">
          <font-awesome-icon class="p-3" icon="fa-solid fa-school-flag" size="2xl" style="color: #d9b369;" />
          <p class="p-3" style="margin-left: 3pt;">Основной поставщик хлебобулочной и кондитерской продукции в
            муниципальные и бюджетные организации Иркутской области.</p>
        </div>
      </div>
    </div>
    <top3News />
    <contactUs />
    <footerBar />
  </div>
</template>
  
<script>
import Navbar from './Navbar';
import FooterBar from './Footer';
import ContactUs from './ContactUs';
import Top3News from './Top3News';
import http from "../http-common";

export default {
  name: 'HomePage',
  components: {
    Navbar: Navbar,
    FooterBar: FooterBar,
    ContactUs: ContactUs,
    Top3News: Top3News
  },
  data() {
    return {
      news: [],
    };
  },
  methods: {
    getNews() {
      http
        .get("/listTop3ShowingNews")
        .then(response => {
          this.news = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.getNews();
  }
}
</script>
  
  <!--определение стилей-->
<style>

.row {
  --bs-gutter-x: 0 !important;
}

.user_margin {
  margin-top: 80pt;
}

.f-16 {
  font-size: 16pt;
}

.f-14 {
  font-size: 14pt;
}

.f-18 {
  font-size: 18pt;
}

.f-14 {
  font-size: 14pt;
}

.video {
  min-height: 450pt;
}

.spanCatalog {
  background: rgba(0, 0, 0, 0.4);
  transition: 0.5s;
}

.spanCatalog:hover {
  background: rgba(0, 0, 0, 0);
}

.img1 {
  background-image: url("../assets/catalog1.jpg");
  background-size: cover;
  transition: background-image 0.5s ease-in-out 0.1s;
}

.img2 {
  background-image: url("../assets/catalog2.jpg");
  background-size: cover;
}

.img3 {
  background-image: url("../assets/catalog3.jpg");
  background-size: cover;
}

.img4 {
  background-image: url("../assets/catalog4.jpg");
  background-size: cover;
}

.img5 {
  background-image: url("../assets/catalog5.jpg");
  background-size: cover;
}

.img6 {
  background-image: url("../assets/catalog6.jpg");
  background-size: cover;
}

p {
  font-size: 15pt;
  font-weight: normal;
  word-wrap: break-word;
  text-align: justify;
}

.back {
  background-color: #a40431ff;
}

.color_white {
  color: #fff;
}

.color_black {
  color: rgb(64, 59, 50);
}

.color-red {
  color: #a40431ff;
  font-weight: bold;
}

.color-yellow {
  color: #d7b369ff;
  font-weight: bold;
}

@media (max-width: 767px) {
  .itemCatalog {
    font-size: 24pt !important;
    height: 280pt !important;
    width: 280pt !important;
    word-wrap: break-word;
  }

  .secondBlock {
    font-size: 16pt !important;
    hyphens: auto;
    word-wrap: break-word;
  }

  .last {
    font-size: 20pt !important;
  }

  .video {
    min-height: 200pt;
  }
}

.big-font {
  font-family: 'Playfair Display' !important;
  font-weight: bold !important;
}

@media (max-width: 992px) {
  .block_center {
    width: 80% !important;
  }
}

.block_center {
  width: 17%;
}

@media (min-width: 767px) {
  .last {
    font-size: 15pt !important;
  }
}

.itemCatalog {
  color: #fff;
  font-size: 20pt;
  height: 200pt;
}

.carousel-item {
  height: 40vw;
}

.secondBlock {
  background-color: #a40431ff;
  width: 100%;
  font-size: 24pt;
  color: #fff;
  letter-spacing: 1px;
}

.catalog {
  width: 98%;
  height: 90%;
  background-color: #fff;
}

.w-mine {
  width: 95%;
}

.card-title {
  font-weight: bold;
  font-size: 12pt;
}

.card {
  width: auto;
  background-color: #a40431ff;
  border: none;
}

.card-body {
  color: #fff;
}

.card-body:hover {
  color: #d7b369ff;
}

.catalogs {
  text-decoration: none;
  color: #fff;
  transition: 0.5s;
}

.catalogs:hover {
  color: #d7b369ff;
}

.span-catalog {
  background-color: #fff;
  width: 30pt;
  height: 1pt;
  top: 50%;
}

.figure {
  display: inline-block;
  overflow: hidden;
}

.figure img {
  transition: 0.5s;
  display: block;
  outline-offset: 0pt;
  outline: 1pt solid rgba(255, 255, 255, 0.05);
}

.figure img:hover {
  transform: scale(1.2);
  outline-offset: -3rem;
  outline: 1pt solid #fff;
}

hr {
  width: 100pt;
}

.zag-txt {
  font-family: 'Playfair Display';
  font-size: 30pt;
}
</style>