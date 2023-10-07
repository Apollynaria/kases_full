<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid h1-00 align-self-center zag-txt">СТАТЬ КЛИЕНТОМ</div>
                </div>
                <div class="p-2">
                    <div class="d-flex col mt-4 justify-content-center mb-3">
                        <p class="color-red f-16 text-center">
                            Для заключения договора необходимо обратиться в отдел продаж,<br>тел.
                            <font-awesome-icon icon="fa-solid fa-phone" style="color: #d9b369;" />
                            +7 3952 210-230.
                        </p>
                    </div>

                    <div
                        class="d-flex justify-content-center w-75 m-auto flex-column flex-sm-column flex-md-row flex-lg-row flex-xl-row m-3 rounded block-white" style="background: #fff;">
                        <div class="p-3">
                            <p class=" f-16 text-center">
                                Для индивидуальных предпринимателей (ИП):
                            </p>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">1</span>
                                    Копия паспорта
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">2</span>
                                    Копия свидетельства ИНН, ОГРН
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">3</span>
                                    Выписка с налогового органа
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">4</span>
                                    Уведомление о применяемой форме налогообложения (НДС / или без НДС)
                                </li>
                            </ul>
                        </div>
                        <div class="p-3">
                            <p class=" f-16 text-center">
                                Для организаций <br>(ООО, ЗАО):
                            </p>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-primary badge-pill me-2">1</span>
                                    Карточка предприятия
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">2</span>
                                    Свидетельство ИНН, ОГРН
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">3</span>
                                    Устав организации
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">4</span>
                                    Решение о назначении директора, приказ директора
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">5</span>
                                    Выписка с налогового органа
                                </li>
                                <li class="list-group-item d-flex justify-content-start align-items-center">
                                    <span class="badge badge-warning badge-pill me-2">6</span>
                                    Уведомление о применяемой форме налогообложения (НДС / или без НДС)
                                </li>
                            </ul>
                        </div>
                    </div>

                    <p class="m-auto mb-3 mt-3 text-center w-75 m-auto">
                        ЗАО "Иркутский хлебозавод" сотрудничает со всеми торговыми сетями, которые готовы реализовывать, в
                        соответствии с требованиями законодательства Российской Федерации, производимую им продукцию и
                        торговые объекты которых находятся в зоне действия доставки при приобретении продукции недлительного
                        срока хранения.
                    </p>

                    <div
                        class="d-flex justify-content-center flex-column flex-sm-column flex-md-row flex-lg-row flex-xl-row mt-3">
                        <a class="btn btn-danger button-size m-2 d-flex justify-content-center"
                            href="/api/getFile/dogpostavki.doc" download="" target="_blank">
                            <p class="align-self-center m-0 f-16">
                                <font-awesome-icon icon="fa-solid fa-file-arrow-down" style="color: #d9b369;" size="lg" />
                                Договор поставки
                            </p>
                        </a>

                        <a class="btn btn-danger button-size m-2 d-flex justify-content-center"
                            href="/api/getFile/doverennost.doc" download="" target="_blank">
                            <p class="align-self-center m-0 f-16">
                                <font-awesome-icon icon="fa-solid fa-file-arrow-down" style="color: #d9b369;" size="lg" />
                                Доверенность
                            </p>
                        </a>
                    </div>


                    <div class="d-flex justify-content-center flex-column flex-sm-column flex-md-row flex-lg-row flex-xl-row mb-3">
                        <a class="btn btn-danger button-size m-2 d-flex justify-content-center"
                            href="/api/getFile/pravopodpisi.doc" download="" target="_blank">
                            <p class="align-self-center m-0 f-16">
                                <font-awesome-icon icon="fa-solid fa-file-arrow-down" style="color: #d9b369;" size="lg" />
                                Право подписи
                            </p>
                        </a>
                        <a class="btn btn-danger button-size m-2 d-flex justify-content-center row"
                            href="/api/getFile/formanalog.doc" download="" target="_blank">
                            <p class="align-self-center m-0 f-16 text-center">
                                <font-awesome-icon icon="fa-solid fa-file-arrow-down" style="color: #d9b369;" size="lg" />
                                Форма
                            </p>
                            <p class="align-self-center m-0 f-16 text-center">
                                налогообложения
                            </p>
                        </a>

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
    name: 'BecomeClient',
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
        ContactUs: ContactUs,
    },
}
</script>
  

<style scoped>

.block-white{
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

.button-size {
    width: 200pt;
    height: 60pt;
    align-self: center;
}
</style>