<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid align-self-center zag-txt">КОНТАКТЫ</div>
                </div>

                <div>
                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="text-center mb-0"><font-awesome-icon icon="fa-solid fa-map-location-dot"
                                style="color: #d7b369ff;" size="lg" /></p>
                        <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto hr-width">
                        <p class="color-red text-center f-16">
                            Юридический / фактический адрес
                        </p>
                        <p class="color-black text-center">
                            664011, Россия, г. Иркутск, ул. Польских Повстанцев, 1.
                        </p>
                    </div>
                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="text-center mb-0"><font-awesome-icon icon="fa-solid fa-business-time"
                                style="color: #d7b369ff;" size="lg" /></p>
                        <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto hr-width">
                        <p class="color-red text-center f-16">
                            Время работы
                        </p>
                        <p class="color-black text-center">
                            понедельник- пятница с 8.00 до 17.00
                        </p>
                    </div>
                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="text-center mb-0"><font-awesome-icon icon="fa-solid fa-phone" style="color: #d7b369ff;"
                                size="lg" /></p>
                        <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto hr-width">
                        <p class="color-red text-center f-16">
                            Многоканальный номер телефона
                        </p>
                        <p class="color-black text-center">
                            +7(3952) 210 230
                        </p>
                    </div>
                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="text-center mb-0"><font-awesome-icon icon="fa-solid fa-bread-slice"
                                style="color: #d7b369ff;" size="lg" /></p>
                        <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto hr-width">
                        <p class="color-red text-center f-16">
                            Фирменный розничный магазин "Свежий хлеб"
                        </p>
                        <p class="color-black text-center">
                            г. Иркутск, ул. Польских Повстанцев, 1, ежедневно с 8.00 до 20.00
                        </p>
                    </div>
                    <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto w-50">
                    <div class="d-flex row mt-3 justify-content-center ">
                        <p class="color-red text-center f-16">
                            Приемная генерального директора
                        </p>
                        <p class="color-black text-center">
                            +7(3952) 335 611
                        </p>
                    </div>

                    <div class="d-flex row mt-3 justify-content-center ">
                        <p class="color-red text-center f-16">
                            Заместитель генерального директора по экспорту
                        </p>
                        <p class="color-black text-center">
                            +7(977)957 78 88, E-mail: <a class="link-danger" href="mailto:bbq-baikal@kacec.ru">bbq-baikal@kacec.ru</a>
                        </p>
                    </div>

                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="color-red text-center f-16">
                            Отдел продаж
                        </p>
                        <p class="color-black text-center">
                            +7(3952) 210 230, E-mail: <a class="link-danger" href="mailto:pp@kacec.ru">pp@kacec.ru</a>
                        </p>
                    </div>

                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="color-red text-center f-16">
                            Отдел кадров
                        </p>
                        <p class="color-black text-center">
                            +7(3952) 335 617, E-mail: <a class="link-danger" href="mailto:ok@kacec.ru">ok@kacec.ru</a>
                        </p>
                    </div>

                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="text-center mb-0"><font-awesome-icon icon="fa-solid fa-envelope color-warning"
                                style="color: #d7b369ff;" size="lg" /></p>
                        <p class="color-black text-center">
                            По вопросам рекламы и маркетинга, связи со СМИ: <a class="link-danger"
                                href="mailto:marketolog@kacec.ru">marketolog@kacec.ru</a>
                        </p>
                        <p class="color-black text-center">
                            По вопросам поставок сырья и материалов: <a class="link-danger"
                                href="mailto:snab@kacec.ru">snab@kacec.ru</a>
                        </p>                       
                    </div>
                </div>
            </div>
            <iframe
                src="https://yandex.ru/map-widget/v1/?um=constructor%3Af4b519a8cd44cddbacc754ea104c2123682a0c42771c38e64b2c740aee6a6873&amp;source=constructor"
                width="100%" height="400" frameborder="0" />
        </div>
        <contactUs />
        <footerBar />
    </div>
</template>
  
<script>
    import Navbar from './Navbar';
    import FooterBar from './Footer';
    import ContactUs from './ContactUs';

    export default {

        name: 'ContactsPage',
        components: {
            Navbar: Navbar,
            FooterBar: FooterBar,
            ContactUs: ContactUs,
        }
    }
</script>
  
  <!--определение стилей-->
<style scoped>
.zag {
    height: 200pt;
    font-size: 30pt;
    font-weight: bold;
    color: #fff;
    letter-spacing: 0.5pt;
    background-image: url("../assets/zag.jpg");
    background-size: cover;
}

.f-16 {
    font-family: 'Playfair Display';
    font-weight: bold;
}

.hr-width {
    width: 50pt;
}
</style>