<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid h1-00 align-self-center zag-txt">ИНФОРМАЦИЯ</div>
                </div>
                <div class="p-3">
                    <div class="d-flex justify-content-center w-75 m-auto flex-column flex-sm-column flex-md-row flex-lg-row flex-xl-row m-3 rounded block-white"
                        style="background: #fff;">
                        <div class="p-3">
                            Сайт содержит материалы, охраняемые авторским правом,и средства индивидуализации (логотипы, фирменные знаки). Использование материалов сайта в интернете разрешено только с указанием гиперссылки на сайт касес.ru. Использование материалов сайта разрешено только с указанием названия сайта «компания "Иркутский хлебозавод"». К нарушителям данного положения применяются все меры, предусмотренные ст. 1301 ГК РФ.
                        </div>
                    </div>
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
    name: 'InformationPage',
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
        ContactUs: ContactUs,
    }
}
</script>
  
  <!--определение стилей-->
<style scoped>
.block-white {
    box-shadow: 0 14px 28px rgba(60, 60, 60, 0.25), 0 10px 10px rgba(60, 60, 60, 0.25);
}

.list-group-item {
    font-size: 13pt;
}

.badge {
    background-color: #a40431ff;
}

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

</style>