<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid align-self-center zag-txt">ФИРМЕННЫЕ МАГАЗИНЫ</div>
                </div>

                <div>
                    <div class="d-flex row mt-2 justify-content-center ">
                        <p class="text-center mb-0"><font-awesome-icon icon="fa-solid fa-bread-slice"
                                style="color: #d7b369ff;" size="lg" /></p>
                        <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto hr-width">
                        <p class="color-red text-center f-16">
                            Фирменные розничные магазины "Свежий хлеб"
                        </p>

                    </div>
                </div>

                <iframe
                    src="https://yandex.ru/map-widget/v1/?um=constructor%3Ad7858b5fa8d16f852a722a032aebfd24760946323fb6f2d91c024e2b69228c45&amp;source=constructor"
                    width="100%" height="400" frameborder="0"></iframe>

                <div v-for="(address, index) in addresses" :key="index">
                    <p class="color-black text-center f-10">
                        {{ address }}
                    </p>
                    <hr class="border border-1 border-warning opacity-100 mt-2 mb-2 m-auto hr-width">
                </div>


            </div>

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

    name: 'StoresPage',
    data() {
        return {
            addresses: [
                "Иркутск, Академическая улица, 12, 1 этаж",
                "Иркутск, 43 микрорайон Университетский, торговый центр \"Мельниковский\"",
                "Иркутск, Байкальская улица, 207/3",
                "Иркутск, Байкальская улица, 284Б/4",
                "Иркутск, Байкальская улица, 320/2, 1 этаж",
                "Иркутск, бульвар Постышева, 17, 1 этаж",
                "Иркутск, бульвар Рябикова 2А, цокольный этаж",
                "Иркутск, бульвар Рябикова, 42/2",
                "Иркутск, бульвар Рябикова, 9А/2",
                "Иркутск, Волжская улица, 3А, киоск",
                "Иркутск, Депутатская улица, 11, 1 этаж",
                "Иркутск, Депутатская улица, 55, 1 этаж",
                "Иркутск, микрорайон Берёзовый, 116, киоск",
                "Иркутск, микрорайон Первомайский, 51/1",
                "Иркутск, микрорайон Первомайский, 6 ст1",
                "Иркутск, микрорайон Первомайский, улица Мамина-Сибиряка, 29а",
                "Иркутск, Советская улица, 137В",
                "Иркутск, Трактовая улица, 1/6, 12 павильон",
                "Иркутск, Трактовая улица, 2А, киоск",
                "Иркутск, улица Академическая, 27, 74 павильон, торговый центр \"Южный\", 1 этаж",
                "Иркутск, улица Баумана, 215а/2 киоск",
                "Иркутск, улица Гоголя, 44а, 113 павильон",
                "Иркутск, улица Грибоедова, 108/2",
                "Иркутск, улица Декабрьских Событий, 103Д, 1 этаж",
                "Иркутск, улица Зимняя, 1, торговый центр \"Торгсервис\", 1 этаж",
                "Иркутск, улица Карла Либкнехта, 245, 1 этаж",
                "Иркутск, улица Ленина, 56, киоск",
                "Иркутск, улица Лермонтова, 297/2",
                "Иркутск, улица Маршала Конева, 44/1",
                "Иркутск, улица Нижняя Набережная, 4/1, 1 этаж",
                "Иркутск, улица Омулевского, 33Б/2, киоск",
                "Иркутск, улица Розы Люксембург, 150/4 киоск",
                "Иркутск, улица Розы Люксембург, 215В, киоск",
                "Иркутск, улица Розы Люксембург, 217",
                "Иркутск, улица Софьи Перовской, 31А/2, киоск",
                "Иркутск, улица Тельмана, 38/7",
                "Иркутск, улица Чехова, 22, киоск",
                "Иркутск, улица Чехова, 22, 234, 294 павильон; 1 этаж",
                "Иркутск, Цимлянская улица, 2, 1 этаж",
                "Иркутский район, п. Листвянка, улица Горького, 91Б"
            ]
        }
    },
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
        ContactUs: ContactUs,
    }
}
</script>
  
  <!--определение стилей-->
<style scoped>
.f-10 {
    font-size: 13pt;
}

.zag {
    height: 200pt;
    font-size: 30pt;
    font-weight: bold;
    color: #fff;
    letter-spacing: 0.5pt;
    background-image: url("../assets/zagStore.jpg");
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