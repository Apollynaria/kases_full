<template>
    <div id="app" class="footer_back row">
        <div class="container-fluid" style="width: 96%;">
            <footer class="">
                <div class="row">
                    <div class="col-md-3 mb-3 text-left mt-3">
                        <img src="../assets/logo_fot.svg" class="width-logo" />
                    </div>

                    <div class="col-6 col-md-2 mb-3">
                        <ul class="mt-3 nav flex-column">
                            <li class="nav-item mb-2"><a href="/aboutCompany" class="nav-link footer-link p-0">О
                                    компании</a></li>
                            <li class="nav-item mb-2"><a href="/news" class="nav-link footer-link p-0">Новости</a></li>
                            <li class="nav-item mb-2"><a href="/products/all" class="nav-link footer-link p-0">Продукция</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-6 col-md-2 mb-3">
                        <ul class="mt-3 nav flex-column">
                            <li class="nav-item mb-2"><a href="/information" class="nav-link footer-link p-0">Информация</a>
                            </li>
                            <li class="nav-item mb-2"><a href="/usefulInformation" class="nav-link footer-link p-0">Полезная
                                    информация</a></li>
                            <li class="nav-item mb-2"><a href="/contacts" class="nav-link footer-link p-0">Контакты</a></li>
                            <li class="nav-item mb-2"><a href="/stores" class="nav-link footer-link p-0">Фирменные магазины</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-6 col-md-2 mb-3">
                        <ul class="mt-3 nav flex-column">
                            <li class="nav-item mb-2"><a href="/clients" class="nav-link footer-link p-0">Стать клиентом</a>
                            </li>
                            <li class="nav-item mb-2"><a href="/vacancies" class="nav-link footer-link p-0">Вакансии</a>
                            </li>
                            <li class="nav-item mb-2"><a href="/china" class="nav-link footer-link p-0">对于中国</a></li>
                        </ul>
                    </div>

                    <div class="col-6 col-md-3 mb-3">
                        <ul class="mt-3 nav flex-column">
                            <li class="nav-item mb-2"><a class="nav-link footer-txt p-0"><img
                                        src="../assets/telephone-fill.svg" width="15" height="15">&nbsp;+7 (3952)
                                    210-230</a></li>
                            <li class="nav-item mb-2"><a class="nav-link footer-txt p-0"><img
                                        src="../assets/geo-alt-fill.svg" width="15" height="15">&nbsp;г. Иркутск, ул.
                                    Польских Повстанцев, 1</a></li>
                            <li class="nav-item mb-2"><a class="nav-link footer-link p-0"
                                    href="mailto:referent@kacec.ru"><img src="../assets/envelope-fill.svg" class="me-1"
                                        width="15" height="15">referent@kacec.ru</a></li>
                        </ul>
                    </div>

                </div>

                <div class="d-flex flex-column flex-sm-row justify-content-between border-top">
                    <p style="font-size: 1em;" class="footer-txt">&copy; ЗАО "Иркутский хлебозавод" 2023</p>
                    <!-- <ul class="list-unstyled d-flex">
                    <li class="ms-3"><a class="link-dark" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"/></svg></a></li>
                    <li class="ms-3"><a class="link-dark" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"/></svg></a></li>
                    <li class="ms-3"><a class="link-dark" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"/></svg></a></li>
                </ul> -->
                </div>
            </footer>
        </div>

    </div>
</template>

<script>
export default {
    name: "FooterBar",
    data() {
        return {};
    }
};
</script>

<style scoped>
.width-logo {
    width: 80pt;
}

.footer_back {
    background-color: #303030 !important;
}

.footer-link {
    color: #ededed !important;
    transition: 0.5s;
    font-size: 12pt;
    font-family: Arial, Helvetica, sans-serif;
}

.footer-link:hover {
    text-decoration: underline;
}

.footer-txt {
    color: #ededed !important;
    font-size: 12pt;
    font-family: Arial, Helvetica, sans-serif;
}
</style>