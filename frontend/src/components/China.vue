<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid align-self-center zag-txt">对于中国</div>
                </div>

                <div class="container-fluid text-center mt-3" style="width: 75%;">
                    <div
                        class="d-flex justify-content-center flex-column flex-sm-column flex-md-column flex-lg-row flex-xl-row">
                        <div class="p-3 text-center">
                            <img class="img-china" src="../assets/china.jpg">
                        </div>

                        <div>
                            <div class="d-flex row mt-2 justify-content-center ">
                                <p class="color-red text-center f-16">
                                    IRKUTSK BAKERY CLOSED JOINT STOCK
                                </p>
                                <p class="color-red text-center china">伊尔库茨克面包店封闭式股份公司</p>
                                <p class="color-black text-center">
                                    ADMINISTRATIVE OFFICE OF THE COMPANY <br>
                                    Legal/actual address: 664011, Russia, Irkutsk, st. Polish Rebels, 1. <br>
                                    公司行政办公室 <br>
                                    法律/实际地址:664011,俄罗斯, 伊尔库茨克，圣波兰叛军，1。
                                </p>
                            </div>
                            <div class="d-flex row mt-2 justify-content-center ">
                                <p class="color-red text-center china">
                                    出口副总干事
                                </p>
                                <p class="color-red text-center f-16">
                                    Deputy General Director for Export
                                    Sergey Mozulev<br>
                                    Tel: +7 (977) 9577-888
                                    bbq-baikal@kacec.ru
                                </p>
                                <p class="color-red text-center china">伊尔库茨克面包店封闭式股份公司</p>
                                <p class="color-black text-center">
                                    中国统一调度服务<br>
                                    Unified Order Service for China<br>
                                    <a class="link-danger" href="https://bbq-baikal.com/">bbq-baikal.com</a>
                                </p>
                            </div>
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
    name: 'ChinaPage',
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
        ContactUs: ContactUs,
    }
}
</script>
  
  <!--определение стилей-->
<style scoped>

.img-china{
        box-shadow: 0 14px 28px rgba(60, 60, 60, 0.25), 0 10px 10px rgba(60, 60, 60, 0.25);
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

.china {
    font-family: 'Playfair Display';
    font-weight: normal;
}
</style>