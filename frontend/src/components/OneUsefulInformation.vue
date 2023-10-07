<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="container-fluid text-center g-0">
            <div class="m-auto">
                <div class="zag d-flex row">
                    <div class="container-fluid align-self-center zag-txt">ПОЛЕЗНАЯ ИНФОРМАЦИЯ</div>
                </div>

                <div>
                    <div class="d-flex row mt-3 justify-content-center ">
                        <p class="color-red text-center name">
                            {{ information.name }}
                        </p>
                        <p class="color-black text-center">
                            {{ information.description }}
                        </p>
                    </div>
                </div>

                <div class="me-3" v-if="information.files.length > 0">
                    <div class="row ms-3 justify-content-center">
                        <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 col-12 p-3"
                            v-for="(file, index) in this.information.files" :key="index">
                            <div class="card h-100 border">
                                <div class="card-body h-100 d-flex flex-column">
                                    <img :src="`/api/getFile/${file}`" class="card-img-top" alt="...">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="p-3">
                    <a class="text-center zagolovok-a" href="/usefulInformation">Назад</a>
                </div>
                

                

            </div>
        </div>
    </div>
    <contactUs />
    <footerBar />
</template>
  
<script>
import Navbar from './Navbar';
import FooterBar from './Footer';
import ContactUs from './ContactUs';
import http from "../http-common";

export default {

    name: 'OneUsefulInformation',
    props: ['id'],
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
        ContactUs: ContactUs,
    },
    data() {
        return {
            information: {
                name: "",
                isShow: "",
                description: "",
                files: []
            },
        };
    },
    methods: {
        getInformation() {
            http
                .get("/information/" + this.id)
                .then(response => {
                    this.information = response.data;
                })
                .catch(e => {
                    console.log(e);
                    window.location.href = '/notFound';
                });
        }
    },
    mounted() {
        this.getInformation();
    }
}
</script>
  
  <!--определение стилей-->
<style scoped>
.card {
    background: #fff;
    box-shadow: 0 14px 28px rgba(60, 60, 60, 0.25), 0 10px 10px rgba(60, 60, 60, 0.25);
}

.card-img-top {
    /* height: 26em; */
    object-fit: cover;
}

.zagolovok-a {
    text-decoration: underline;
    font-family: 'Playfair Display' !important;
    font-weight: bold;
    color: #a40431ff;
    font-size: 18pt;
    transition: 0.5s;
}

.zagolovok-a:hover {
    color: #d7b369ff;
}

.date {
    font-size: 16pt;
    /* color: #d7b369ff; */
    color: #a40431ff;
    font-weight: bold;
    font-family: Arial, Helvetica, sans-serif;
}

p {
    white-space: pre-line;
}

.name {
    font-size: 24pt;
    font-family: 'Playfair Display';
    font-weight: bold;
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

.hr-width {
    width: 50pt;
}
</style>